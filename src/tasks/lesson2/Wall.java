package tasks.lesson2;

public class Wall implements Obstacle{
    double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public Result doAction(Action action){ // принять джмпабал интерфейс
        return action.jump(this);
    }


}
