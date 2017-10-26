import java.io.*;
import java.net.*;

public class server {
public final static int socket_port = 1338;
public final static String file_sent = "C:/Users/Hung Mach/Downloads/termproject.docx";

public static void main(String[] args) throws IOException{
	FileInputStream fis = null;
	BufferedInputStream bis = null;
	OutputStream os = null;
	ServerSocket servSock = null;
	Socket sock = null;
	
	try{
		servSock = new ServerSocket(socket_port);
		while(true){
			System.out.println("waiting...");
			try{
				sock = servSock.accept();
				System.out.println("Accepted connection : " + sock);
		          // send file
		          File myFile = new File (file_sent);
		          byte [] mybytearray  = new byte [(int)myFile.length()];
		          fis = new FileInputStream(myFile);
		          bis = new BufferedInputStream(fis);
		          bis.read(mybytearray,0,mybytearray.length);
		          os = sock.getOutputStream();
		          System.out.println("Sending " + file_sent + "(" + mybytearray.length + " bytes)");
		          os.write(mybytearray,0,mybytearray.length);
		          os.flush();
		          System.out.println("Done.");
			}finally {
		        if (bis != null) bis.close();
		        if (os != null) os.close();
		        if (sock!=null) sock.close();
		      }
		}
	}finally {
	      if (servSock != null) servSock.close();
	    }
}
}
