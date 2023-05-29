import java.io.* ;
import java.lang.* ;

public class Tring{
 public static void main(String[] args) throws Throwable{
 	DataInputStream di = new DataInputStream(System.in) ;
 	System.out.println("Enter num of nodes: ") ;
 	int n = Integer.parseInt(di.readLine()) ;
 	
 	int token = 0 ;
 	int ch = 1 ;
 	for(int i=0; i<n; i++){
 		System.out.print(" " + i) ;
 	}
 	
 	System.out.print("\n") ;
 	
 	try{
 		while(ch==1){
 			System.out.println("Enter sender: ") ;
 			int s = Integer.parseInt(di.readLine()) ;
 			System.out.println("Enter reciever: ") ;
 			int r = Integer.parseInt(di.readLine()) ;
 			System.out.println("Enter string: ") ;
 			String d = di.readLine() ;
 			System.out.println("Token passing: ") ;
 			for(int i=token; i!=s; i++){
 				System.out.println(" " + i + "->") ; 
 			}
 			
 			System.out.println(" " + s) ;
 			System.out.println("Sender " + s + " sending data: " + d) ;
 			for(int i=s+1; i!=r; i=(i+1)%n){
 				System.out.println("data " + d + " forwarded by " + i) ; 
 			}
 			
 			System.out.println("Reciever " + r + " recieved data " + d) ; 
 			token = s ;
 			
 	
 
 		}
 	}
 	
 	catch(Exception e){
 		
 	}
 	
 }
}
