package tasks.lesson2;

public class Treadmill implements Obstacle {
    double distance;

    public Treadmill(double distance) {
        this.distance = distance;
    }

    @Override
    public Result doAction(Action action) {
        return action.run(this);
    }
}
