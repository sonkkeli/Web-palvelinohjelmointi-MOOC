
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HelloRedirectLoop {

    public static void main(String[] args) throws Exception {
        int port = 8080;
        ServerSocket server = new ServerSocket(port);
        int i = 0;
        while (true){
            Socket socket = server.accept();
            System.out.println("Pyyntöjen lkm: " +i);  
            i++;
            
            Scanner pyynnonLukija = new Scanner(socket.getInputStream());
            
            if (pyynnonLukija.nextLine().contains("/quit")){                
                break;
            }
            
            PrintWriter vastauksenKirjoittaja = new PrintWriter(socket.getOutputStream());
            vastauksenKirjoittaja.println("HTTP/1.1 302 Found");
            vastauksenKirjoittaja.println("Location: http://localhost:" + port + "/");
            vastauksenKirjoittaja.flush();

            pyynnonLukija.close();
            vastauksenKirjoittaja.close();
            socket.close();                      
        }
    }
}
