import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

 
 

public class Main {

	public static void main(String[] args) throws  IOException {

		String host = "www.yahoo.com";
		//String protocol = "http";
		
		Socket socket = new Socket( host ,80);
		
		OutputStream os = socket.getOutputStream();
		
		boolean autoflush = true;
		
		PrintWriter out = new PrintWriter(socket.getOutputStream(),autoflush);
		
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
 
       out.println("GET / HTTP/1.1");
       out.println(" Host : " +host +  ":80");
       out.println(" Connection : Close");
       out.println( );
       
       boolean loop = true;
       StringBuilder sb = new StringBuilder(8096);
       
       while(loop){
    	   if(in.ready()){
    		   int n = 0;
    		   while( n != -1){
    			   n = in.read();
    			   sb.append((char)n);
    			   
    		   }
    		   loop = false;
    	   }
       }
		
       System.out.println(sb.toString());
       socket.close();
       os.close();
       
       
	}

}
