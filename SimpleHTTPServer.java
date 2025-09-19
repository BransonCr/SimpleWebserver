import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleHTTPServer {

    public static void main(String args[]) throws IOException {

        ServerSocket serverListener = new ServerSocket(4100);
        System.out.println("Listening for connection on port 4100 ....");
        while (true) {
            try (Socket socket = serverListener.accept()) {
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" +"You accessed the server on: " + today;
                socket.getOutputStream()
                      .write(httpResponse.getBytes("UTF-8"));
            }
        }
    }

}