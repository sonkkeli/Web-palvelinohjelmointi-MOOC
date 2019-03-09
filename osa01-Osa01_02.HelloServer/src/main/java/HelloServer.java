import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class HelloServer {

    public static void main(String[] args) throws Exception {
        int port = 8080;
        ServerSocket server = new ServerSocket(port);
        int i = 0;
        while (true){
            Socket socket = server.accept();
            System.out.println("Vuoronumero: " +i);
            i++;
            Scanner pyynnonLukija = new Scanner(socket.getInputStream());
            
            if (pyynnonLukija.nextLine().contains("/quit")){                
                break;
            }
            
            PrintWriter vastauksenKirjoittaja = new PrintWriter(socket.getOutputStream());
            vastauksenKirjoittaja.println("HTTP/1.1 200 OK");
            vastauksenKirjoittaja.println("");
            
            Files.lines(Paths.get("index.html"))
                    .forEach(line -> vastauksenKirjoittaja.println(line));
            vastauksenKirjoittaja.flush();

            pyynnonLukija.close();
            vastauksenKirjoittaja.close();
            socket.close();            
        }
    }
}
