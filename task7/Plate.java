package task7;

public class Plate extends Dish {
    int radius;
    int deep;
    double volume;

    public Plate(int deep, int radius){
        this.radius = radius;
        this.deep = deep;
        calcVolume();
    }

    @Override
    public void calcVolume() {
        volume = deep * radius;
        System.out.println("Volume = " + volume);
    }
}
