package tasks.lesson2;

public class Cat implements Action{
    double maxDistance;
    double maxHeight;
    public Cat(double maxDistance, double maxHeight) {
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }

    @Override
    public Result run(Treadmill treadmill) {
        if(treadmill.distance > maxDistance){
            return Result.FAIL;
        } else if (treadmill.distance <= 0){
            return Result.FAIL;
        } else {
            return Result.SUCCESS;
        }
    }

    @Override
    public Result jump(Wall wall) {
        if(wall.height > maxHeight){
            return Result.FAIL;
        }else if (wall.height <= 0){
            return Result.FAIL;
        } else {
            return Result.SUCCESS;
        }
    }
}
