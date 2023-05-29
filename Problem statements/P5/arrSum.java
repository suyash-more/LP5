import mpi.MPI.*;
import mpi.* ;

public class arrSum{

	public static void main(String args[]) throws Exception{
		
		MPI.Init(args) ;
		int size = MPI.COMM_WORLD.Size() ;
		int rank = MPI.COMM_WORLD.Rank() ;
		
		int root=0;
		int unitsize=5 ;
		int sendbuffer[] = null ;
		
		sendbuffer = new int[size*unitsize] ;
		int recvbuffer[] = new int[unitsize] ;
		int newrecvbuffer[] = new int[size] ;
		
		if(rank==root){
			int tot_ele = size*unitsize ;
			System.out.println("Total elements are: " + (tot_ele)) ;
			
			for(int i=0; i<tot_ele; i++){
				System.out.println("Element: " + i) ;
				sendbuffer[i] = i ;
			}
		}
		
		MPI.COMM_WORLD.Scatter(
			sendbuffer,
			0,
			unitsize,
			MPI.INT,
			recvbuffer,
			0,
			unitsize,
			MPI.INT,
			root
		) ;
		
		for(int i=1; i<unitsize; i++){
			recvbuffer[0] += recvbuffer[i] ;
		}
		
		System.out.println("Sum at intermediate: " + rank + " is " + recvbuffer[0]) ;
		
		MPI.COMM_WORLD.Gather(
			recvbuffer,
			0,
			1,
			MPI.INT,
			newrecvbuffer,
			0,
			1,
			MPI.INT,
			root
		) ;
		
		if(rank==root){
		
			int totsum = 0 ;
			for(int i=0; i<size; i++){
				totsum += newrecvbuffer[i] ;
			}
			System.out.println("Final sum is: " + totsum) ;
		
		}
		
		MPI.Finalize() ;
		
		
	}
}
