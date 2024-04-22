package tasks.p8;

class Square extends Figure {
    double side;

    Square(double a) {
        side = a;
    }

    @Override
    public double findVolume() {
        return side * side * side;
    }
}
