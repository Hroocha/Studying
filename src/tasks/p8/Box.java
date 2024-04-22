package tasks.p8;

public class Box {

    double volumeBox = 100;
    double fullSpace = 0;

    public boolean add (Figure figure){
        double vol = figure.findVolume();
        if ((volumeBox - fullSpace) >= vol) {
            fullSpace += vol;
            return true;
        }
        else return false;
    }


}
