import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPChatClient {

    public static void main(String[] args) {
        String hostname = "localhost"; // Replace with server hostname or IP address
        int portNumber = 1234; // Replace with server port number

        try {
            Socket socket = new Socket(hostname, portNumber);
            System.out.println("Connected to server: " + hostname + ":" + portNumber);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            String inputLine;
            String outputLine;

            // Send messages to server and receive responses
            while ((inputLine = stdIn.readLine()) != null) {
                out.println(inputLine);

                // Check for server's response
                if ((outputLine = in.readLine()) != null) {
                    System.out.println(outputLine);
                }

                if (inputLine.equals("bye"))
                    break;
            }

            // Close connections
            out.close();
            in.close();
            stdIn.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}