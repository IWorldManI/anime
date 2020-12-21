import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
		
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = socket.getInputStream();
		} catch (IOException e) {
			System.out.println("Can not get input stream , or socket error");
		}
		
		try {
			out = new FileOutputStream("muhammed.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found !");
		}
		
		byte[] b = new byte[20*1024];

		int i ;
		
		while((i = in.read(b)) >0){
			out.write(b, 0, i);
		}
	out.close();
	in.close();
	socket.close();
	serversocket.close();

	}

}
