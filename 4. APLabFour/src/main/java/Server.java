import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements ServerInterface {

    @Override
    public double doTask(double x, double y) throws RemoteException {
        System.out.println("Got new numbers: " + x + ", " + y);
        Task task = new Task(x, y);
        System.out.println("Sending this back to a client: " + task.equation());
        return task.equation();
    }

    public static void main(String[] args) throws InterruptedException {
        try {
            Server server = new Server();
            ServerInterface stub = (ServerInterface) UnicastRemoteObject.exportObject(server, 0);
            Registry registry = LocateRegistry.createRegistry(2732);
            registry.bind("equation", stub);
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
        Thread.sleep(Integer.MAX_VALUE);
    }
}
