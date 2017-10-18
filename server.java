
import java.io.*;
import java.net.*;
/**
 *
 * @author nguye
 */
public class server {
    
    public static void main(String[] args) throws Exception{
            server SERVER = new server();
            SERVER.run();
    }
    
    public void run() throws Exception
    {
        ServerSocket ServerSocket = new ServerSocket(444);
        Socket SOCK = ServerSocket.accept();
        InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
        BufferedReader BR = new BufferedReader(IR);
        
        String message = BR.readLine();
        System.out.println(message);
        
        if(message != null){
            PrintStream ps = new PrintStream(SOCK.getOutputStream());
                    ps.println("Message received");
        }
    }
}
