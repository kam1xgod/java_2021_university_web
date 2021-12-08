import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {

    double doTask(double x, double y) throws RemoteException;
}
