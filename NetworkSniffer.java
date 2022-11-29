import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
 
public class NetworkSniffer
{
    public static void main(String[] args) 
    {
        try
        {
            //get the localhost address
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local Host Address: " + localHost);
 
            //get the network interfaces
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while(networkInterfaces.hasMoreElements())
            {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                System.out.println("Network Interface: " + networkInterface);
 
                //get the IP addresses associated with this network interface
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while(inetAddresses.hasMoreElements())
                {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    System.out.println("IP Address: " + inetAddress);
                }
            }
        }
        catch (SocketException e)
        {
            e.printStackTrace();
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
    }
}
