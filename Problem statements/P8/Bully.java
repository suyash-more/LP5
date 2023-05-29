import java.util.Scanner ;

public class Bully{
	
	static boolean state[] = new boolean[5] ;
	int coord ;
	
	public static void up(int up){
		if(state[up-1] == true){
			System.out.println("process already up") ;
		}
		
		else{
			state[up-1] = true ;
			System.out.println("process held for election") ;
			for(int i=up; i<5; i++){
				System.out.println("election message sent from " + up + " to " + (i+1)) ;
			}
			
			for(int i=up+1; i<=5; i++){
				if(state[i-1] == true){
					System.out.println("alive msg sent from " + i + " to " + up) ;
					break ;
				}
				
			}
		}
	}
	public static void down(int down){
		if(state[down-1] == false){
			System.out.println("process already down") ;
		}
		
		else{
			state[down-1] = false ;
			
		}
	}
	
	public static void msg(int msg){
		if(state[msg-1] == false){
			System.out.println("process down") ;
		}
		
		else{
			if(state[4] == true){
				System.out.println("OK") ;
			}
			else{
				if(state[4] == false){
					System.out.println("process " + msg + " election") ;
					for(int i=msg; i<5; i++){
						System.out.println("Election send from process "+ msg+ " to " + (i+1)) ;
					}
					
					for(int i=5; i>=msg; i--){
						if(state[i-1]==true){
							System.out.println("Coordinator msg send from process "+ i+ " to all" ) ;
							break ;
						}
					}
				
				}				
			}
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in) ;
		int ch ;
		
		for(int i=0; i<5; i++){
			state[i] = true ;
		}
		
		System.out.println("5 active process currently\n Process up: p1, p2, p3, p4, p5\n P5 is coordinator") ;
		
		do{
			System.out.println(".........");
            		System.out.println("1 up a process.");
            		System.out.println("2.down a process");
            		System.out.println("3 send a message");
            		System.out.println("4.Exit");
            		ch = sc.nextInt();
		
			switch(ch){
				case 1: 
				{
					System.out.println("Enter process to bring up: ") ;
					int up = sc.nextInt() ;
					if(up == 5){
						System.out.println("P5 is coordinator") ;
						state[4] = true ;
					}
					else{
						up(up) ;
					}
				}
				break;
				case 2: 
				{
					System.out.println("Enter process to bring down: ") ;
					int down = sc.nextInt() ;
					down(down) ;
				}
				break;
				case 3: 
				{
					System.out.println("Enter process to send msg: ") ;
					int msg = sc.nextInt() ;
					msg(msg) ;
				}
				break;
			}
		}while(ch!=4);
		
	}


}
