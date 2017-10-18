
import java.io.*;
import java.net.*;

/**
 *
 * @author David Nguyen
 */
public class client {
    
    public static void main(String[] args) throws Exception
    {
    client q = new client();
    q.run();
    }
    public void run() throws Exception
    {
        Socket SOCK = new Socket("localhost", 444);
        PrintStream PS = new PrintStream(SOCK.getOutputStream());
        PS.println("Hello World");
        
        InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
        BufferedReader BR = new BufferedReader(IR);
        String message = BR.readLine();
        System.out.println(message);
    }
}
