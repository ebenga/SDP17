#include <Adafruit_NeoPixel.h>
#include <Wire.h>
#ifdef __AVR__
#include <avr/power.h>
#endif

#define PIN 6
#define NUMLEDS 11
//#define NUMPLAYERS 4
#define rxFault 0x80
#define txFault 0x40
#define txRequest 0x20
#define slaveAddress 8

// Parameter 1 = number of pixels in strip
// Parameter 2 = Arduino pin number (most are valid)
// Parameter 3 = pixel type flags, add together as needed:
//   NEO_KHZ800  800 KHz bitstream (most NeoPixel products w/WS2812 LEDs)
//   NEO_KHZ400  400 KHz (classic 'v1' (not v2) FLORA pixels, WS2811 drivers)
//   NEO_GRB     Pixels are wired for GRB bitstream (most NeoPixel products)
//   NEO_RGB     Pixels are wired for RGB bitstream (v1 FLORA pixels, not v2)
//   NEO_RGBW    Pixels are wired for RGBW bitstream (NeoPixel RGBW products)
Adafruit_NeoPixel strip = Adafruit_NeoPixel(NUMLEDS, PIN, NEO_GRB + NEO_KHZ800);

// IMPORTANT: To reduce NeoPixel burnout risk, add 1000 uF capacitor across
// pixel power leads, add 300 - 500 Ohm resistor on first pixel's data input
// and minimize distance between Arduino and first pixel.  Avoid connecting
// on a live circuit...if you must, connect GND first.

// Create a struct to hold player position and color in the game 
struct Player_type
{
    uint8_t pos;
    uint32_t color;
};

struct Player_type Player[5];
uint8_t spaceCount[NUMLEDS];
bool volatile gameOver = false;

// flag to trigger a Serial printout after an I2C event
// use volatile for variables that will be used in interrupt service routines.
// "Volatile" instructs the compiler to get a fresh copy of the data rather than try to
// optimise temporary registers before using, as interrupts can change the value.

void setup() {

  Serial.begin(9600);  // For monitoring on the PC
  while (!Serial) {};  // Wait for the Serial port to initialise properly
  Serial.println("I2C Wire Library Tests\n");

  Wire.begin(slaveAddress);  // I2C slave address 8 setup.
  Wire.onReceive(i2cReceive);  // register our handler function with the Wire library

  
  Player[0] = {0,strip.Color(255, 0, 0)};   // The Mangelor
  Player[1] = {100,strip.Color(0, 128, 0)};   // The green knight of Derelin
  Player[2] = {100,strip.Color(255, 32, 0)};  // The orange knight of Wybengaland
  Player[3] = {100,strip.Color(0, 0, 255)};   // The blue knight of Lassallax
  Player[4] = {100,strip.Color(255, 0, 255)}; // The kniht who has done literally nothing on our SDP

  spaceCount[Player[0].pos] = 1;
  
  strip.setPixelColor(Player[0].pos, Player[0].color);
  strip.setPixelColor(Player[1].pos, Player[1].color);
  strip.setPixelColor(Player[2].pos, Player[2].color);
  strip.setPixelColor(Player[3].pos, Player[3].color);
  strip.setPixelColor(Player[4].pos, Player[4].color);

  strip.begin();
  strip.show(); // Initialize knights to their home kingdoms
}

void loop() {
  delay(10000);

}

//====================================================
/*
   i2cReceive:
   Parameters: integer, number of bytes in rx buffer
   Returns: none
   Function called by twi interrupt service when master sends
   information to the slave, or when master sets up a
   specific read request.
   Incoming data must be processed according to the
   Interface Specification decided upon.
   The first byte sent is a command byte, and this informs
   the slave how to react to the transmission.
   See the end of this document for the Interface Specification
   for this example. Typically, the MSB of "command" is used to
   signal 'read' or 'write' instructions.
*/
void i2cReceive(int byteCount) {
  // if byteCount is zero, the master only checked for presence
  // of the slave device, triggering this interrupt. No response necessary
  if (byteCount == 0) return;

  // if byteCount is greater than zero then a command has been issued.
  // See cases for callable function descriptions
  byte command = Wire.read();
  i2cHandleRx(command);
}

byte i2cHandleRx(byte command) {
  // If you are here, the I2C Master has sent data
  // using one of the SMBus write commands.
  byte result = 0;
  // returns the number of bytes read, or FF if unrecognised
  // command or mismatch between data expected and received

  switch (command) {
    
    case 0x0A:
      if (Wire.available() == 1) { // good write from Master
        int numPlayers = Wire.read();
        for (int i = 1; i<=numPlayers; i++){
          Player[i].pos = i;
          spaceCount[i] += 1;
          strip.setPixelColor(Player[i].pos, Player[i].color);
        }
        strip.show();
      } else {
        result = 0xFF;
      }
      break;

    case 0x0B:  //The Move command: read two bytes in a block to set player and new position 
      if (Wire.available() == 2) { // good write from Master
        int playerNum = Wire.read();
        uint8_t prevSpace = Player[playerNum].pos;
        spaceCount[prevSpace] -= 1;
        Player[playerNum].pos = Wire.read();
        spaceCount[Player[playerNum].pos] += 1;
        if (spaceCount[prevSpace] == 0){
          strip.setPixelColor(prevSpace, 0);
        }
        else{
          for(int i = 0; i <= 4; i++){
            if (Player[i].pos == prevSpace){
              strip.setPixelColor(Player[i].pos, Player[i].color);
              break;
            }
          }
        }
        strip.setPixelColor(Player[playerNum].pos, Player[playerNum].color);
        strip.show();
        result = 2;
      } else {
        result = 0xFF;
      }
      break;

    case 0x0C:
      if (Wire.available() == 1) { // good write from Master
        int winner = Wire.read();
        gameEnd(winner);
        result = 1;
      } else {
        result = 0xFF;
      }
      break;

//
//    case 0x0D:
//      if (Wire.available() == 1) { // good write from Master
//        commsTable.brightB = Wire.read();
//        result = 1;
//      } else {
//        result = 0xFF;
//      }
//      break;
//
    default:
      result = 0xFF;
  }
//
//  if (result == 0xFF) commsTable.control |= rxFault;
//  return result;

}

void gameEnd(int win){
  //Turns off all of the LEDs
  int winner = win;
  for(uint8_t i=0; i<strip.numPixels(); i++) {
    strip.setPixelColor(i, Player[winner].color);
    strip.show();
    delay(50);
  }
  gameOver = true;
  strip.show();
}

//===============================================================================

// Fill the dots one after the other with a color
void colorWipe(uint32_t c, uint8_t wait) {
  for(uint16_t i=0; i<strip.numPixels(); i++) {
    strip.setPixelColor(i, c);
    strip.show();
    delay(wait);
  }
}

void rainbow(uint8_t wait) {
  uint16_t i, j;

  for(j=0; j<256; j++) {
    for(i=0; i<strip.numPixels(); i++) {
      strip.setPixelColor(i, Wheel((i+j) & 255));
    }
    strip.show();
    delay(wait);
  }
}

// Slightly different, this makes the rainbow equally distributed throughout
void rainbowCycle(uint8_t wait) {
  uint16_t i, j;

  for(j=0; j<256*5; j++) { // 5 cycles of all colors on wheel
    for(i=0; i< strip.numPixels(); i++) {
      strip.setPixelColor(i, Wheel(((i * 256 / strip.numPixels()) + j) & 255));
    }
    strip.show();
    delay(wait);
  }
}

//Theatre-style crawling lights.
void theaterChase(uint32_t c, uint8_t wait) {
  for (int j=0; j<10; j++) {  //do 10 cycles of chasing
    for (int q=0; q < 3; q++) {
      for (uint16_t i=0; i < strip.numPixels(); i=i+3) {
        strip.setPixelColor(i+q, c);    //turn every third pixel on
      }
      strip.show();

      delay(wait);

      for (uint16_t i=0; i < strip.numPixels(); i=i+3) {
        strip.setPixelColor(i+q, 0);        //turn every third pixel off
      }
    }
  }
}

//Theatre-style crawling lights with rainbow effect
void theaterChaseRainbow(uint8_t wait) {
  for (int j=0; j < 256; j++) {     // cycle all 256 colors in the wheel
    for (int q=0; q < 3; q++) {
      for (uint16_t i=0; i < strip.numPixels(); i=i+3) {
        strip.setPixelColor(i+q, Wheel( (i+j) % 255));    //turn every third pixel on
      }
      strip.show();

      delay(wait);

      for (uint16_t i=0; i < strip.numPixels(); i=i+3) {
        strip.setPixelColor(i+q, 0);        //turn every third pixel off
      }
    }
  }
}

// Input a value 0 to 255 to get a color value.
// The colours are a transition r - g - b - back to r.
uint32_t Wheel(byte WheelPos) {
  WheelPos = 255 - WheelPos;
  if(WheelPos < 85) {
    return strip.Color(255 - WheelPos * 3, 0, WheelPos * 3);
  }
  if(WheelPos < 170) {
    WheelPos -= 85;
    return strip.Color(0, WheelPos * 3, 255 - WheelPos * 3);
  }
  WheelPos -= 170;
  return strip.Color(WheelPos * 3, 255 - WheelPos * 3, 0);
}
