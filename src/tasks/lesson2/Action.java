package tasks.lesson2;

public interface Action {
    Result run(Treadmill treadmill);
    Result jump(Wall wall);
}
