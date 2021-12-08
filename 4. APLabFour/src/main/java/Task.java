import java.io.Serializable;

public class Task implements Serializable {

    double x;
    double y;

    public Task(double x, double y) {
        this.x = x;
        this.y = y;
    }

    final double equation() {

        return this.x + this.y;
    }
}
