import java.util.Scanner ;

class Rr{
	public int index ;
	public int id ;
	public int f ;
	String state ;
	
}

public class Ring{
	public static void main(String[] args){
		int temp, i, j ;
		char str[] = new char[10] ;
		Rr proc[] = new Rr[10] ;
		
		Scanner sc = new Scanner(System.in) ;
		
		for(i=0; i<10; i++){
			proc[i] = new Rr() ;
		}
		
		System.out.println("Enter number of processes: ") ;
		int n = sc.nextInt() ;
		
		for( i=0; i<n; i++){
			proc[i].index = i ;
			System.out.println("Enter id: ") ;
			proc[i].id = sc.nextInt() ;
			proc[i].state = "active" ;
			proc[i].f = 0 ;			
		}
		
		for(i=0; i<n-1; i++){
			for(j=0; j<n-1; j++){
				if(proc[j].id>proc[j+1].id){
					temp = proc[j].id ;
					proc[j].id = proc[j+1].id ;
					proc[j+1].id = temp ;
				}
			}
		}
		
		for (i = 0; i < n; i++) {
			System.out.println("  [" + i + "]" + " " + proc[i].id);
		}
		
		int init, ch, tmp1, tmp2, ch1 ;
		
		int arr[] = new int[10] ;
		
		proc[n-1].state = "inactive" ;
		
		System.out.println("Process "+ proc[n-1].id + " selected as coordinator") ;
		
		while(true){
			System.out.println("1. Election 2. Quit") ;
			ch = sc.nextInt() ;
			
			for(i=0; i<n; i++){
				proc[i].f = 0 ;
			}
			
			switch(ch){
				case 1: 
				{
					System.out.println("Enter initiator id: ") ;
					init = sc.nextInt() ;
					tmp1 = init+1 ;
					tmp2 = init ;
					
					i = 0 ;
					
					while(tmp1 != tmp2){
						if("active".equals(proc[tmp1].state) && proc[tmp1].f == 0){
						System.out.println("Process " + proc[init].id + " sends msg to " + proc[tmp1].id) ;
						proc[tmp1].f = 1 ;
						init = tmp1 ;
						arr[i] = proc[tmp1].id ;
						i++ ;		
						}
						
						if(tmp1 == n){
							tmp1 = 0 ;
						}
						else{
							tmp1++ ;
						}
					}
					
					System.out.println("Process " + proc[init].id + " sends msg to " + proc[tmp1].id) ;
					arr[i] = proc[tmp1].id ;
					i++ ;	
					int max = -1 ;
					
					for ( j=0 ; j<i; j++){
						if(max<arr[j]){
							max = arr[j] ;
						}
					}
					
					System.out.println("Process " + max + " selected as coordinator ") ;
					for (i = 0; i < n; i++) {

					if (proc[i].id == max) {
						proc[i].state = "inactive";
					}
				}
					

				}
				break ;
				case 2: 
				{
					System.out.println("Program terminated ...");
					return ;
				}
				
			}
 		} 
	}
}
