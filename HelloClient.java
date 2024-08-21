import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class HelloClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 1234;

    public static void main(String[] args) {
        try {
            // Connect to the server
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            System.out.println("Connected to server");

            // Receive the message from the server
            String message = receiveMessage(socket);
            System.out.println("Received message: " + message);

            // Close the connection
            socket.close();
            System.out.println("Connection closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String receiveMessage(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int bytesRead = inputStream.read(buffer);
        return new String(buffer, 0, bytesRead);
    }
}