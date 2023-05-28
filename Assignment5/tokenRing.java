import java.util.Scanner;

class TokenRing {
    public static void main(String[] args) throws Throwable {    
        System.out.println("Enter the number of processes: ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        int token = 0;
        int sender, receiver;
        String message;
        boolean message_pass = false;
        System.out.println("Initializing ring");
        for(int i = 0; i < n; i++) {
            System.out.print(" " + i);                        
        }
        System.out.print("\nEnter sender : ");
        sender = sc.nextInt();
        System.out.print("Enter receiver : ");
        receiver = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter message : ");
        message = sc.nextLine();

        System.out.println("Token Cicrulation Started");
        for(int i = token; i != sender; i++) {
            System.out.print(" " + i + "->");
        }
        System.out.println(" " + sender);
        System.out.println(sender + " Sending Message : " + message);
        for(int i = sender + 1; i != receiver; i = (i+1) % n){
            System.out.println("Message '" + message + "' forwarded by " + i);
        }
        System.out.println("Receiver " + receiver + " Received Message: " + message);
    }
}