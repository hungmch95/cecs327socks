/**
 *
 * @author David Nguyen
 */
import java.io.*;
import java.net.*;
public class client2
{
    private static String serv_Name;
   public static void main(String [] args)
   {
      String serverName = "localhost";
      int port = 444;
      try
      {
         Socket client = new Socket(serverName, port);
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);
         out.writeUTF("Hello from "+ client.getLocalSocketAddress());
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         System.out.println("Server says " + in.readUTF());
         client.close();
      }catch(IOException e)
      {
          e.printStackTrace();
      }
   }
}