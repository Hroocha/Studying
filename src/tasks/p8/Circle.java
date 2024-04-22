package tasks.p8;

class Circle extends Figure {
    double radius;
    double pi = 3.14159;

    Circle(double a) {
        radius = a;
    }

    @Override
    public double findVolume() {
        double volume = pi * radius * radius;
        return volume;
    }
}
