
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author David Nguyen
 */
public class server2 extends Thread{
    private static int port;
    private ServerSocket serv_Socket;
    

    public server2(int port) throws IOException
   {
      serv_Socket = new ServerSocket(port);
   }
    
    public void run(){
        while(true){
            try
            {
                Socket server = serv_Socket.accept();
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("Thank you for connecting to "+server.getLocalSocketAddress() + "\nGoodbye!");
                server.close();
            } catch(IOException e)
         {
            e.printStackTrace();
            break;
         }
        }
    }
    
    public static void main(String [] args){
        port = 444;
        try
        {
            Thread t = new server2(port);
            t.start();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}