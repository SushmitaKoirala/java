import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for a client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter outputWriter = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String inputLine, outputLine;
            while (true) {
                inputLine = inputReader.readLine();
                if (inputLine.equals("exit")) {
                    break;
                }
                System.out.println("Client: " + inputLine);

                System.out.print("Server: ");
                outputLine = consoleReader.readLine();
                outputWriter.println(outputLine);
            }

            serverSocket.close();
            System.out.println("Server closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}