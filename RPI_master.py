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

"""
There are four commands that can be called:
	Num Players: "1"; expects one argument; number of players (Ex. python RPI_master.py 1 4)
	Move Player: "2"; expects two arguments; player number, new position (Ex. python RPI_master.py 2 2 4)
	Set Winner:  "3"; expects one argument; winning player (Ex. python RPI_master.py 3 2)
	Reset Board: "4"; expects no argument;  (Ex. python RPI_master.py 4)
"""

if len(sys.argv) >=2:
	if int(sys.argv[1])==1:	#The Initialize Player Number command
		command = 0x0A
	elif int(sys.argv[1])==2:	#The Move command
		command = 0x0B
	elif int(sys.argv[1])==3:	#The Player Wins command
		command = 0x0C
	elif int(sys.argv[1])==4:	#The Reset command
		command = 0x0D

	for i in range(len(sys.argv)-2):
		data.append(int(sys.argv[i+2]))

	i2c.write_i2c_block_data(addr, command, data)
