import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FtpServer {

	public static void main(String[] args) throws IOException {

		ServerSocket serversocket = null;
		try {
			
			serversocket  = new ServerSocket(4000);
			
		} catch (IOException e) {
			System.out.println("Can not connect please check port No.");
		}

		Socket socket = null;
		try {
			socket = serversocket.accept();
		} catch (IOException e) {
			System.out.println("Can not accept the connection.");

		}
		
		  File file = new File("muhammed.txt");

		    
		    
		    byte[] b = new byte[20*1024]; 
		    
		    InputStream in = new FileInputStream(file);
		    OutputStream out = socket.getOutputStream();
		    
		    int i ;
		    
		    while ((i = in.read(b)) >0    ) {
				out.write( b , 0 , i);
			}

		    
		    out.close();
		    in.close();
		    socket.close();
	serversocket.close();

	}

}
