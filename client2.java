/**
 *
 * @author David Nguyen
 */
import java.io.*;
import java.net.*;
public class client2
{
    private static String serverName;
    private final static String downloadspot ="C:/Users/nguye/Downloads/banana-dl.jpg";
    private final static int FILE_SIZE = 6022386;
    
    public static void main(String [] args) throws IOException
   {
       int bytesRead;
       int current = 0;
       FileOutputStream fs = null;
       BufferedOutputStream bs = null;
       Socket sock = null;
       serverName = "localhost";
       int port = 444;
      try
      {
         sock = new Socket(serverName, port);
         System.out.println("Connecting...");
         
         byte [] mybytearray = new byte[FILE_SIZE];
         InputStream is = sock.getInputStream();
         fs = new FileOutputStream(downloadspot);
         bs = new BufferedOutputStream(fs);
         bytesRead = is.read(mybytearray,0,mybytearray.length);
         current = bytesRead;
         System.out.println(current+ " the bytes read");
         do{
            bytesRead =is.read(mybytearray, current,(mybytearray.length-current)); 
            bs.write(mybytearray,0,current);
            if(bytesRead >=0) current +=bytesRead;
         }while(bytesRead < -1);
                
       //bs.write(mybytearray,0,current);
       bs.flush();
        System.out.println("File "+ downloadspot+ "downloaded("+current+ "bytes read)");
      }finally{
                if(fs!= null) fs.close();
                if(bs!= null) bs.close();
                if(sock != null) sock.close();
                }

      }
   }
