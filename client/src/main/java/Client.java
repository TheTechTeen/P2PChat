import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Client {
    private ServerSocket port;
    Socket connection;
    ObjectOutputStream output;
    ObjectInputStream input;

    public Client()
    {
        // start listening for connections
        try 
        {
            connection = new Socket( InetAddress.getByName( "localhost" ), 12345 );// create ServerSocket
            output = new ObjectOutputStream( connection.getOutputStream() );
            output.flush();

            input = new ObjectInputStream( connection.getInputStream() );
            
            output.writeObject("Testing");
            String message = ( String ) input.readObject(); // read new message

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
        Client client = new Client();
    }
}
