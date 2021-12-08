import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    private Client() {
    }

    public static void main(String[] args) {
        double x = 0;
        double y = 0;

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("insert x and y:\n\tx= ");
            try {
                x = scanner.nextDouble();
                System.out.print("\ty= ");
                y = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Something went wrong. Try again.");
            }

            Registry registry = LocateRegistry.getRegistry(2732);
            ServerInterface stub = (ServerInterface) registry.lookup("equation");
            double response = stub.doTask(x, y);
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
