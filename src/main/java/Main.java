
import utils.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.connect();

   
        
        for (int i = 1; i <= 9999; i++) {  
            System.out.printf("Hello and welcome!");
            // System.out.println("JAVA = " + i);
        }
    }
}