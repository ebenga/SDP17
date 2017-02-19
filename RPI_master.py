# I2C write functions through SMBus implementation
# This work is licensed under a Creative Commons 
# Attribution-ShareAlike 4.0 International License.
# Created by Mike Ochtman. Find me on LinkedIn and drop me 
# a note if you found this helpful!

import time
import sys
import smbus

i2c = smbus.SMBus(1)
addr = 8 # address of the arduino I2C

data = []

if len(sys.argv) >=2:
	if int(sys.argv[1])==1:	#The Initialize Player Number command
		command = 0x0A
	elif int(sys.argv[1])==2:	#The Move command
		command = 0x0B
	elif int(sys.argv[1])==3:	#The Player Wins command
		command = 0x0C
	elif int(sys.argv[1])==4:	#The Player Wins command
		command = 0x0D

	for i in range(len(sys.argv)-2):
		data.append(int(sys.argv[i+2]))

	i2c.write_i2c_block_data(addr, command, data)

# while(1):
# 	try:
# 		cmd=int(raw_input('Enter Command #:'))
# 	except ValueError:
# 		print "Not a command number"
# 	if (cmd==1):
# 		try:
# 			player=int(raw_input('Player:'))
# 		except ValueError:
# 			print "Not a player number"
# 		try:
# 			pos=int(raw_input('Position:'))
# 		except ValueError:
# 			print "Not a position number"

# 		data = [player,pos]
# 		i2c.write_i2c_block_data(addr, 0x0A, data)
# 	if (cmd==2):
# 		try:
# 			winner=[int(raw_input('Winner:'))]
# 		except ValueError:
# 			print "Not a player number"
# 		i2c.write_i2c_block_data(addr, 0x0B, winner)

