import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class FtpClient {

	public static void main(String[] args) throws UnknownHostException, IOException {

Socket socket = null;


	socket = new Socket("127.0.0.1", 4000 );

    File file = new File("client\\muhammed.txt");

    
    
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
    
	}

}
