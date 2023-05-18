idlj -fall ReverseModule.idl
javac *.java ReverseModule/*.java
orbd -ORBInitialPort 8000
java ReverseServer -ORBInitialPort 8000 -ORBInitialHostlocalhost 
java ReverseClient -ORBInitialPort 8000 -ORBInitialHostlocalhost 