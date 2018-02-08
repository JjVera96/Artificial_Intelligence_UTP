import numpy as np
import cv2
from library import *

cap = cv2.VideoCapture(0) 
kernel = np.ones((3,3),np.uint8)
b = ball(0,0)

while(True):
	#Reconocimientos colores y contornos
	ret, frame = cap.read()
	gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
	hsv = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)
	verde_bajos = np.array([0, 115, 121], dtype=np.uint8)
	verde_altos = np.array([115, 255, 255], dtype=np.uint8)
	mask = cv2.inRange(hsv, verde_bajos, verde_altos)
	cv2.bitwise_not(mask, mask)
	gray = cv2.GaussianBlur(gray,(5,5),0);
	gray = cv2.medianBlur(gray,5)
	gray = cv2.adaptiveThreshold(gray,255,cv2.ADAPTIVE_THRESH_GAUSSIAN_C,\
			cv2.THRESH_BINARY,11,3.5)
	gray = cv2.erode(gray,kernel,iterations = 1)
	gray = cv2.dilate(gray,kernel,iterations = 1)
	cv2.bitwise_or(mask, gray, mask)
	
	#Dibujando circulos
	circles = cv2.HoughCircles(mask, cv2.HOUGH_GRADIENT, 2, 20, param1=50, param2=30, minRadius=0, maxRadius=0)
	if circles is not None:
		circles = np.round(circles[0, :]).astype("int")
		for (x, y, r) in circles:
			cv2.circle(frame, (x, y), r, (0, 255, 0), 4)
			b.update(x, y)

	#Mostrando
	font = cv2.FONT_HERSHEY_SIMPLEX
	cv2.putText(frame, str(b.jumps), (10,400), font, 4,(255,255,255),2,cv2.LINE_AA)
	cv2.imshow('fin', mask)
	cv2.imshow('frame',frame)
	if cv2.waitKey(1) & 0xFF == ord('q'):
		break
cv2.destroyAllWindows()