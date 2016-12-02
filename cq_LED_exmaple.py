from __future__ import division
import time
import RPi.GPIO as GPIO
from threading import Thread

GPIO.setwarnings(False)

LED_G=10
LED_R=15
LED_B=11

CATH_TOP = 8
CATH_MID = 16
CATH_BOT = 13

delay = 1/200
# print "-----DELAY = %f-----"%delay

PlayerColor = [""]*4
PlayerPosition = [""]*4
topCount = 0
midCount = 0
botCount = 0
numPlayers = 0
gameOver = 0
topColors = [""]*4
midColors = [""]*4
botColors = [""]*4
topLEDColor = ""
midLEDColor = ""
botLEDColor = ""


def setup(*leds):
	#GPIO.cleanup()
	GPIO.setmode(GPIO.BOARD)
	for led in leds:
		GPIO.setup(led, GPIO.OUT)
		GPIO.output(led, GPIO.LOW)

def gameStart():
	global gameOver
	global PlayerColor
	global PlayerPosition
	global numPlayers
	global topCount
	global midCount
	global botCount
	global topColors
	global midColors
	global botColors
	validNumP = 0
	while (validNumP==0):
		try:
			numPlayers = int(raw_input('How many Players? (max 4): '))
			if((numPlayers>0)&(numPlayers<=4)):
				print "Players = %d"%numPlayers
				validNumP = 1
			else:
				print "Invalid # of players (must be 1-4)"
		except ValueError:
			print "Please enter a number 1-4"
	"""
	INITIAL PLAYER COLOR SETUP
	"""
	print "\n1: Red\n2: Blue\n3: Green\n4: Purple\n5: Cyan"
	i=0
	while i<numPlayers:
		question = "\nPlayer #"+str(i+1)+" pick a color from the list: "
		try:
			temp =str(raw_input(question)).lower()
			if(temp=="red"):
				PlayerColor[i]="red"
				print "Player %d is the %s hero!"%((i+1),PlayerColor[i])
				i+=1
			elif(temp=="blue"):
				PlayerColor[i]="blue"
				print "Player %d is the %s hero!"%((i+1),PlayerColor[i])
				i+=1
			elif(temp=="green"):
				PlayerColor[i]="green"
				print "Player %d is the %s hero!"%((i+1),PlayerColor[i])
				i+=1
			elif(temp=="purple"):
				PlayerColor[i]="purple"
				print "Player %d is the %s hero!"%((i+1),PlayerColor[i])
				i+=1
			elif(temp=="cyan"):
				PlayerColor[i]="cyan"
				print "Player %d is the %s hero!"%((i+1),PlayerColor[i])
				i+=1
			else:
				print "Sorry that isn't a color on the list, please try again"
		except ValueError:
			print "Please enter a color from the list"
	"""
	INITIAL PLAYER POSITION SETUP
	"""
	print "\n1: Top\n2: Middle\n3: Bottom"
	j=0
	while j<numPlayers:
		question = "\nPlayer #"+str(j+1)+" pick a starting position from the list: "
		try:
			temp =str(raw_input(question)).lower()
			if(temp=="top"):
				PlayerPosition[j]="top"
				print "Player %d is starting in the %s spot!"%((j+1),PlayerPosition[j])
				topColors[topCount]=PlayerColor[j]
				topCount += 1
				j+=1
			elif(temp=="middle"):
				PlayerPosition[j]="middle"
				print "Player %d is starting in the %s spot!"%((j+1),PlayerPosition[j])
				midColors[midCount]=PlayerColor[j]
				midCount += 1
				j+=1
			elif(temp=="bottom"):
				PlayerPosition[j]="bottom"
				print "Player %d is starting in the %s spot!"%((j+1),PlayerPosition[j])
				botColors[botCount]=PlayerColor[j]
				botCount += 1
				j+=1
			else:
				print "Sorry that isn't a number on the list, please try again"
		except ValueError:
			print "Please enter a valid space name (top, middle, bottom)"

def game():
	global gameOver
	global PlayerColor
	global PlayerPosition
	global numPlayers
	global topCount
	global midCount
	global botCount
	global topColors
	global midColors
	global botColors
	pturn=0
	while(gameOver==0):
		# print "gameOver = %d"%gameOver
		# print "numPlayers = %d"%numPlayers
		# print "topCount = %d"%topCount
		# print "midCount = %d"%midCount
		# print "botCount = %d"%botCount
		# print "PlayerColor[0] = %s"%PlayerColor[0]
		# print "PlayerColor[1] = %s"%PlayerColor[1]
		# print "PlayerColor[2] = %s"%PlayerColor[2]
		# print "PlayerColor[3] = %s"%PlayerColor[3]
		# print "PlayerPosition[0] = %s"%PlayerPosition[0]
		# print "PlayerPosition[1] = %s"%PlayerPosition[1]
		# print "PlayerPosition[2] = %s"%PlayerPosition[2]
		# print "PlayerPosition[3] = %s"%PlayerPosition[3]
		# print "topColors[0] = %s"%topColors[0]
		# print "topColors[1] = %s"%topColors[1]
		# print "topColors[2] = %s"%topColors[2]
		# print "topColors[3] = %s"%topColors[3]
		# print "midColors[0] = %s"%midColors[0]
		# print "midColors[1] = %s"%midColors[1]
		# print "midColors[2] = %s"%midColors[2]
		# print "midColors[3] = %s"%midColors[3]
		# print "botColors[0] = %s"%botColors[0]
		# print "botColors[1] = %s"%botColors[1]
		# print "botColors[2] = %s"%botColors[2]
		# print "botColors[3] = %s"%botColors[3]
		prompt="Player %d choose a space (Top, Middle, Bottom): "%(pturn+1)
		try:
			newPos=str(raw_input(prompt)).lower()
			if (PlayerPosition[pturn]!=newPos):
			#only mess with stuff if the player moves to a new position
				if (newPos=="quit"):
				#not a position but gives a way to exit the program from console
					gameOver=1
				elif(newPos=="top"):
					if (PlayerPosition[pturn]=="middle"):
					#switching from mid to top, decrement mid and shift down the midColors array
						count = 0
						while(midColors[count]!=PlayerColor[pturn]):
							count+=1
						while(count<(midCount-1)):
							midColors[count]=midColors[count+1]
							count+=1
						midColors[(midCount-1)]=""
						midCount -=1
					if (PlayerPosition[pturn]=="bottom"):
					#switching from bot to mid, decrement bot and shift down the botColors array
						count = 0
						while(botColors[count]!=PlayerColor[pturn]):
							count+=1
						while(count<(botCount-1)):
							botColors[count]=botColors[count+1]
							count+=1
						botColors[(botCount-1)]=""
						botCount -=1
					#once the other row arrays and indices have been adjusted, adjust the top ones
					PlayerPosition[pturn]="top"
					topColors[topCount]=PlayerColor[pturn]
					topCount +=1
					#indicate that the players turn is now over
					pturn=(pturn+1)%numPlayers
				elif(newPos=="middle"):
					if (PlayerPosition[pturn]=="top"):
					#switching from top to mid, decrement top and shift down the topColors array
						count = 0
						while(topColors[count]!=PlayerColor[pturn]):
							count+=1
						while(count<(topCount-1)):
							topColors[count]=topColors[count+1]
							count+=1
						topColors[(topCount-1)]=""
						topCount -=1
					if (PlayerPosition[pturn]=="bottom"):
					#switching from bot to mid, decrement bot and shift down the botColors array
						count = 0
						while(botColors[count]!=PlayerColor[pturn]):
							count+=1
						while(count<(botCount-1)):
							botColors[count]=botColors[count+1]
							count+=1
						botColors[(botCount-1)]=""
						botCount -=1
					#once the other row arrays and indices have been adjusted, adjust the mid ones
					PlayerPosition[pturn]="middle"
					midColors[midCount]=PlayerColor[pturn]
					midCount +=1
					#indicate that the players turn is now over
					pturn=(pturn+1)%numPlayers
				elif(newPos=="bottom"):
					if (PlayerPosition[pturn]=="top"):
					#switching from top to mid, decrement top and shift down the topColors array
						count = 0
						while(topColors[count]!=PlayerColor[pturn]):
							count+=1
						while(count<(topCount-1)):
							topColors[count]=topColors[count+1]
							count+=1
						topColors[(topCount-1)]=""
						topCount -=1
					if (PlayerPosition[pturn]=="middle"):
					#switching from mid to top, decrement mid and shift down the midColors array
						count = 0
						while(midColors[count]!=PlayerColor[pturn]):
							count+=1
						while(count<(midCount-1)):
							midColors[count]=midColors[count+1]
							count+=1
						midColors[(midCount-1)]=""
						midCount -=1
					#once the other row arrays and indices have been adjusted, adjust the bot ones
					PlayerPosition[pturn]="bottom"
					botColors[botCount]=PlayerColor[pturn]
					botCount +=1
					#indicate that the players turn is now over
					pturn=(pturn+1)%numPlayers
				else:
					print "Sorry that isn't a valid space, please try again"
			else:
				pturn=(pturn+1)%numPlayers
		except ValueError:
			print "Please enter a valid space name (top, middle, bottom)"

def setLEDColor(color):
	if (color=="red"):
		GPIO.output(LED_R, GPIO.HIGH)
	elif (color=="blue"):
		GPIO.output(LED_B, GPIO.HIGH)
	elif (color=="green"):
		GPIO.output(LED_G, GPIO.HIGH)
	elif (color=="purple"):
		GPIO.output(LED_R, GPIO.HIGH)
		GPIO.output(LED_B, GPIO.HIGH)
	elif (color=="cyan"):
		GPIO.output(LED_G, GPIO.HIGH)
		GPIO.output(LED_B, GPIO.HIGH)
	elif (color=="lime"):
		GPIO.output(LED_R, GPIO.HIGH)
		GPIO.output(LED_G, GPIO.HIGH)
	elif (color=="white"):
		GPIO.output(LED_R, GPIO.HIGH)
		GPIO.output(LED_G, GPIO.HIGH)
		GPIO.output(LED_B, GPIO.HIGH)
	else:
		print "Sorry, that isn't a displayable color"

def BoardDisplay():
	global gameOver
	global PlayerColor
	global PlayerPosition
	global numPlayers
	global topCount
	global midCount
	global botCount
	global topColors
	global midColors
	global botColors

	control = 0
	while (gameOver==0):
		if control == 0:
			GPIO.output(LED_R, GPIO.LOW)
			GPIO.output(LED_G, GPIO.LOW)
			GPIO.output(LED_B, GPIO.LOW)
			GPIO.output(CATH_MID, GPIO.HIGH)
			GPIO.output(CATH_BOT, GPIO.HIGH)
			GPIO.output(CATH_TOP, GPIO.LOW)
			if(topColors[0]!=""):
				setLEDColor(topLEDColor)
			time.sleep(delay)
			control = 1
		elif control == 1:
			GPIO.output(LED_R, GPIO.LOW)
			GPIO.output(LED_G, GPIO.LOW)
			GPIO.output(LED_B, GPIO.LOW)
			GPIO.output(CATH_TOP, GPIO.HIGH)
			GPIO.output(CATH_BOT, GPIO.HIGH)
			GPIO.output(CATH_MID, GPIO.LOW)
			if(midColors[0]!=""):
				setLEDColor(midLEDColor)
			time.sleep(delay)
			control = 2
		elif control == 2:
			GPIO.output(LED_R, GPIO.LOW)
			GPIO.output(LED_G, GPIO.LOW)
			GPIO.output(LED_B, GPIO.LOW)
			GPIO.output(CATH_TOP, GPIO.HIGH)
			GPIO.output(CATH_MID, GPIO.HIGH)
			GPIO.output(CATH_BOT, GPIO.LOW)
			if(botColors[0]!=""):
				setLEDColor(botLEDColor)
			time.sleep(delay)
			control = 0
	GPIO.cleanup()

def MultiPlayerTopLED():
	global gameOver
	global topCount
	global topColors
	global topLEDColor
	current = 0
	delay = 1
	while(gameOver==0):
		if(topCount>0):
			# for i in range(topCount):
			# 	print "topColors[%d] = %s"%(i,topColors[i])
			topLEDColor=topColors[current%topCount]
			# print "topCount = %d 	current = %d 	topLEDColor = %s"%(topCount,current,topLEDColor)
			delay=1/topCount
			time.sleep(delay)
			current +=1

def MultiPlayerMidLED():
	global gameOver
	global midCount
	global midColors
	global midLEDColor
	current = 0
	delay = 1
	while(gameOver==0):
		if(midCount>0):
			# for i in range(midCount):
			# 	print "midColors[%d] = %s"%(i,midColors[i])
			midLEDColor=midColors[current%midCount]
			# print "midCount = %d 	current = %d 	midLEDColor = %s"%(midCount,current,midLEDColor)
			delay=1/midCount
			time.sleep(delay)
			current +=1

def MultiPlayerBotLED():
	global gameOver
	global botCount
	global botColors
	global botLEDColor
	current = 0
	delay = 1
	while(gameOver==0):
		if(botCount>0):
			# for i in range(botCount):
			# 	print "botColors[%d] = %s"%(i,botColors[i])
			botLEDColor=botColors[current%botCount]
			# print "botCount = %d 	current = %d 	botLEDColor = %s"%(botCount,current,botLEDColor)
			delay=1/botCount
			time.sleep(delay)
			current +=1

if __name__=="__main__":
	setup(LED_G,LED_R,LED_B,CATH_TOP,CATH_MID,CATH_BOT)

#	GPIO.output(LED_G, GPIO.HIGH)
#	GPIO.output(LED_R, GPIO.HIGH)
#	GPIO.output(LED_B, GPIO.HIGH)
#	time.sleep(0.25)
#	GPIO.output(LED_G, GPIO.LOW)
#	GPIO.output(LED_R, GPIO.LOW)
#	GPIO.output(LED_B, GPIO.LOW)

#	t=Thread(target=green)
#	u=Thread(target=red)
#	v=Thread(target=blue)

#	t.start()
#	u.start()
#	v.start()
#	t.join()
#	u.join()
#	v.join()
#	time.sleep(1)
#	GPIO.output(CATH_TOP, GPIO.HIGH)
#	time.sleep(1)
#	GPIO.output(CATH_MID, GPIO.HIGH)
#	time.sleep(1)
#	GPIO.output(CATH_BOT, GPIO.HIGH)
#	GPIO.cleanup()
	gameStart()
	# game()
	pos=Thread(target=game)
	topLED=Thread(target=MultiPlayerTopLED)
	midLED=Thread(target=MultiPlayerMidLED)
	botLED=Thread(target=MultiPlayerBotLED)
	board=Thread(target=BoardDisplay)

	pos.start()
	topLED.start()
	midLED.start()
	botLED.start()
	board.start()
	pos.join()
	topLED.join()
	midLED.join()
	botLED.join()
	board.join()
	
