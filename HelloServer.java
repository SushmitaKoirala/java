import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected to client: " + clientSocket.getInetAddress());

                // Send the "Hello" message
                sendHello(clientSocket);

                // Close the connection
                clientSocket.close();
                System.out.println("Connection closed with client: " + clientSocket.getInetAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendHello(Socket clientSocket) throws IOException {
        OutputStream outputStream = clientSocket.getOutputStream();
        String message = "Hello";
        outputStream.write(message.getBytes());
        outputStream.flush();
    }
}
