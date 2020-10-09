package task7;

public class Pan extends Dish {
    int radius;
    int deep;
    double volume;

    public Pan(int radius, int deep){
        this.radius = radius;
        this.deep = deep;
        calcVolume();
    }

    @Override
    public void calcVolume() {
        volume = radius * deep *10;
        System.out.println("Volume = " + volume);
    }

    public void makeBorsh(){
        System.out.println("Borsh svaren");
    }
}
