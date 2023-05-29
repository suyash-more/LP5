from timeit import default_timer as timer
from dateutil import parser
import threading
import datetime
import socket
import time

def startSend(slave_client):
	while True:
		slave_client.send(str(datetime.datetime.now()).encode())
		print("Time sent successfully")
		time.sleep(5)
		

def startRecv(slave_client):
	while True:
		sync_time = parser.parse(slave_client.recv(1024).decode())
		print("Sync time at client is: " + str(sync_time))

def initFunc(port=8080):
	slave_client = socket.socket()
	slave_client.connect(('127.0.0.1', port))
	
	send_time_thread = threading.Thread(target=startSend, args=(slave_client,))
	send_time_thread.start()
	
	recv_time_thread = threading.Thread(target=startRecv, args=(slave_client,))
	recv_time_thread.start()

if __name__ == "__main__":
	initFunc(port = 8080)
