import java.io.*;
import java.net.*;

public class client {

	public final static int SOCKET_PORT = 1338;      // you may change this
	  public final static String SERVER = "127.0.0.1";  // localhost
	  public final static String
	       FILE_TO_RECEIVED = "C:/Users/Hung Mach/Downloads/termproject-downloaded.docx";
	  public final static int FILE_SIZE = 29000;
	 public static void main(String[] args) throws IOException{
		 int bytesRead;
		    int current = 0;
		    Socket sock = null;
		    BufferedOutputStream BoutStream = null;
		    FileOutputStream outStream = null;
		    try {
		      sock = new Socket(SERVER, SOCKET_PORT);
		      System.out.println("Connecting...");

		      // receive file
		      byte [] mybytearray  = new byte [FILE_SIZE];
		      InputStream is = sock.getInputStream();
		      bytesRead = is.read(mybytearray,0,mybytearray.length);
		      current = bytesRead;
		      File targetFile = new File("C:/Users/Hung Mach/workspace/termproject-downloaded.docx");
		      outStream = new FileOutputStream(targetFile);
		      BoutStream = new BufferedOutputStream(outStream);
		      
		      do {
		    	  bytesRead =
				           is.read(mybytearray, current, (mybytearray.length-current));
		         if(bytesRead >= 0) current += bytesRead;
		      } while(bytesRead > -1); 
		      BoutStream.write(mybytearray, 0, current);
		      BoutStream.flush();
		      System.out.println("File " + FILE_TO_RECEIVED
		          + " downloaded (" + current + " bytes read)");
		    }
		    finally {
		    	outStream.close();
		    	BoutStream.close();
		      if (sock != null) sock.close();
		    }
		  }
}
