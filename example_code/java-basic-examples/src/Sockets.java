import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Sockets {
    public static void server(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            Socket socket = serverSocket.accept();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                out.println(inputLine);
            }
        }
        // Handle error
    }

    public static void client(String[] args)
            throws UnknownHostException, IOException {
        try (Socket socket = new Socket("localhost", 9999)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println(in.readLine());
            }
        }
        // Handle error
    }

    public static void main(String[] args) throws IOException {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory =
                    (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.
                    createServerSocket(9999);
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            PrintWriter out = new PrintWriter(sslSocket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(sslSocket.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                out.println(inputLine);
            }
        } finally {
            if (sslServerSocket != null) {
                try {
                    sslServerSocket.close();
                } catch (IOException x) {
                    // Handle error
                }
            }
        }
    }
}
