package tasks.p8;

class Pyramid extends Figure {
    double side;
    double height;

    Pyramid(double a, double b) {
        side = a;
        height = b;
    }

    public double findVolume() {
        return (side * height) / 3;
    }
}
