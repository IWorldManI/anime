import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class FtpClient2 {

	public static void main(String[] args) throws UnknownHostException, IOException {

Socket socket = null;


	socket = new Socket("127.0.0.1", 4000 );

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
 
    
	}

}
