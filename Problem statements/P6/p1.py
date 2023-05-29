import datetime
import threading
import socket
import time
from dateutil import parser
from functools import reduce

client_data = {}

def startRecv(connector, address):
	while True:
		time_str = connector.recv(1024).decode()
		clk_time = parser.parse(time_str)
		clk_time_diff = datetime.datetime.now() - clk_time
		
		client_data[address] = {
			"connector" : connector,
			"time_diff" : clk_time_diff,
			"clock_time" : clk_time
		}
		
		print("Client updated with: " + str(address) + "\n")
		time.sleep(5) 
		
		
		
def startConn(master_server):
	while True:
		connector, address = master_server.accept()
		slave_addr = str(address[0]) + ":" + str(address[1])
		print("Connected with: " + str(slave_addr) + "\n")
		
		curr_thread = threading.Thread(target=startRecv, args=(connector, slave_addr))
		curr_thread.start()
		
		 
def getAvgTimeDiff():
	curr_client_data = client_data.copy()
	time_diff_list = list(client['time_diff'] for client_addr, client in client_data.items())
	sum_diff = sum(time_diff_list, datetime.timedelta(0,0))
	avg_diff = sum_diff/len(client_data)
	
	return avg_diff
	
	
def syncClks():
	while True:
		print("New Sync cycle:")
		print("No of clients to be synced: "+ str(len(client_data)))
		
		if len(client_data)>0:
			avg_diff = getAvgTimeDiff()
			for client_addr, client in client_data.items():
				try:
					sync_time = datetime.datetime.now() + avg_diff
					client['connector'].send(str(sync_time).encode())
				except Exception as e:
					print(e)
					
		else: 
			print("No data")
			
		time.sleep(5)
					
	
def initTimeClk(port=8080):
	master_server = socket.socket()
	master_server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
	
	print("Socket at master created")
	
	master_server.bind(('', port))
	
	master_server.listen(10)
	
	master_thread = threading.Thread(target=startConn, args=(master_server,))
	master_thread.start()
	
	sync_thread = threading.Thread(target=syncClks, args=())
	sync_thread.start()

if __name__=="__main__":
	initTimeClk(port=8080)
