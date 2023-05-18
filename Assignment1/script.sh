javac *.java
rmic AddServerImpl
rmiregistry &
java AddServer
java AddClient 127.0.0.1 2965.34 123.95