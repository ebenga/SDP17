# I2C write functions through SMBus implementation
# This work is licensed under a Creative Commons 
# Attribution-ShareAlike 4.0 International License.
# Created by Mike Ochtman. Find me on LinkedIn and drop me 
# a note if you found this helpful!

import smbus
import time
import sys

i2c = smbus.SMBus(1)
addr = 8 # address of the arduino I2C
command = sys.argv[1]
data = sys.argv[2:]
i2c.write_i2c_block_data(addr, command, data)
##
##
##/* Interface Specification
##    Data in a table thus:
##      byte purpose
##      0: command
##      1: control
##     2-5: Current Temperature (read-only)
##     6-9: Current light level (read only)
##     10: Brightness for RED r/w
##     11: Brightness for GREEN r/w
##     12: Brightness for BLUE r/w
##
##     Commands:
##     Write with no command: Ignore
##     Read with no command: Return slave address
##     Command 0x81: read temperature. Integer returned, int(round(temp*100))
##     Command 0x82: read light level, Integer returned, int(round(lux*100))
##     Command 0x0A: Write three bytes to RGB
##     Command 0x0B: Write single byte brightness red;
##     Command 0x0C: Write single byte brightness green;
##     Command 0x0D: Write single byte brightness blue;
##     Command 0x90: read three bytes brightness RGB
##     Command 0x91: read single byte brightness red;
##     Command 0x92: read single byte brightness green;
##     Command 0x93: read single byte brightness blue;
##
##     All other values are ignored, no data returned.
##
##*/

# i2c.write_i2c_block_data(addr, command, data)

while(1):
	try:
		cmd=int(raw_input('Enter Command #:'))
	except ValueError:
		print "Not a command number"
	if (cmd==1):
		try:
			player=int(raw_input('Player:'))
		except ValueError:
			print "Not a player number"
		try:
			pos=int(raw_input('Position:'))
		except ValueError:
			print "Not a position number"

		data = [player,pos]
		i2c.write_i2c_block_data(addr, 0x0A, data)
	if (cmd==2):
		try:
			winner=[int(raw_input('Winner:'))]
		except ValueError:
			print "Not a player number"
		i2c.write_i2c_block_data(addr, 0x0B, winner)

