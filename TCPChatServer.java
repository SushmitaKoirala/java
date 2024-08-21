import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPChatServer {

    public static void main(String[] args) {
        int portNumber = 1234; // Choose any available port number

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Server started. Listening on port " + portNumber);

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            String inputLine;
            String outputLine;

            // Read messages from client and respond
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Client: " + inputLine);
                if (inputLine.equals("bye"))
                    break;

                // Get server's response
                outputLine = stdIn.readLine();
                out.println("Server: " + outputLine);
            }

            // Close connections
            out.close();
            in.close();
            stdIn.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}