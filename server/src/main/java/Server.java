import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author TheTechTeen
 * @author Caleb
 * @author Jacob
 * The main class for a P2PChat server
 */

public class Server
{
    private ServerSocket port;
    Socket connection;
    ObjectOutputStream output;
    ObjectInputStream input;

    public Server()
    {
        // start listening for connections
        try 
        {
            port = new ServerSocket(1709, 100); // create ServerSocket

            connection = port.accept(); // wait for a connection
            output = new ObjectOutputStream( connection.getOutputStream() );
            output.flush();
            input = new ObjectInputStream( connection.getInputStream() );
            
            String message = ( String ) input.readObject(); // read new message
            output.writeObject("Testing" + message);

            System.out.println(message);
        } 
        catch ( Exception ex )
        {
            ex.printStackTrace();
        }
        // when there is a connection
        // If someone is asking for a friends's IP address
        // give it to them
        // if someone wants to register
        // add them to the database
    }

    public static void main (String[] args)
    {
        new Server();
    }
}