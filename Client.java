import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to the server.");

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outputWriter = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String inputLine, outputLine;
            while (true) {
                System.out.print("Client: ");
                outputLine = consoleReader.readLine();
                outputWriter.println(outputLine);

                inputLine = inputReader.readLine();
                if (inputLine.equals("exit")) {
                    break;
                }
                System.out.println("Server: " + inputLine);
            }

            socket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}