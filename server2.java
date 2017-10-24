
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author David Nguyen
 */
public class server2 extends Thread{
    private static int port = 444;
    private static ServerSocket serv_Socket;
    private final static String file_send ="c:/users/nguye/banana.jpg";
    
    public static void main(String [] args) throws IOException{
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        OutputStream os = null;
        Socket sock = null;

        
        try{
            serv_Socket= new ServerSocket(port);
            while(true){
                System.out.println("Waiting...");
                try{
                    sock =serv_Socket.accept();
                    System.out.println("Accepted connection : "+sock);
                    File myFile = new File (file_send);
                    byte [] mybytearray = new byte[(int)myFile.length()];
                    fis = new FileInputStream(myFile);
                    bis = new BufferedInputStream(fis);
                    bis.read(mybytearray,0,mybytearray.length);
                    os = sock.getOutputStream();
                    System.out.println("Sending "+ file_send+ "("+mybytearray.length +"bytes)");
                    os.write(mybytearray, 0, mybytearray.length);
                    os.flush();
                    System.out.println("Done. ");
                }
                finally{
                    if (bis !=null) bis.close();
                    if( os!= null) os.close();
                    if(sock!=null) sock.close();
                    
                }
            }
        }
        finally{
            if (serv_Socket != null) serv_Socket.close();
        }
    }
    
}