import java.net.ServerSocket;
import java.net.Socket;
public class EchoServer
{
public static void main(String [] args)
{
try{
System.out.println("wating for clients..");
ServerSocket ss=new ServerSocket(9806);
Socket soc=ss.accept();
System.out.println("Connection established");
}
catch(Exception e)
{
e.printStackTrace();
}
}
}