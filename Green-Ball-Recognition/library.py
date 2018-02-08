import cv2
import numpy as np
import sys

class ball():
	def __init__(self, x, y):
		self.x = x
		self.y = y
		self.dir = "down"
		self.jumps = 0

	def getX(self):
		return self.x

	def getY(self):
		return self.y

	def getDir(self):
		return self.dir

	def getJumps(self):
		return self.jumps

	def setPos(self, x, y):
		self.x = x
		self.y = y

	def update(self, x, y):
		if(self.y < y and self.dir == "down"):
			self.jumps += 1
			self.dir = "up"
		if(self.y > y):
			self.dir = "down"
		self.setPos(x, y)

"""
b = ball(10, 20)
print("y = " + str(b.getY()))
print("dir = " + str(b.getDir()))
print("jumps = " + str(b.getJumps()))
b.update(10, 10)
print("y = " + str(b.getY()))
print("dir = " + str(b.getDir()))
print("jumps = " + str(b.getJumps()))
b.update(10, 20)
print("y = " + str(b.getY()))
print("dir = " + str(b.getDir()))
print("jumps = " + str(b.getJumps()))
"""

