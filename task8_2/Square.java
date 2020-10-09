package task8_2;

public class Square extends Rectangle {
    Square(){
    }

    Square(double side){
        super(side, side);
    }

    Square(double side, String color, boolean filled){
        super(side, side);
        this.setColor(color);
        this.setFilled(filled);
    }

    public double getSide(){
        return getWidth();
    }

    public void setSide(double side){
        setWidth(side);
        setLength(side);
    }

    @Override
    public void setWidth(double side) {
        super.setWidth(side);
    }

    @Override
    public void setLength(double side) {
        super.setLength(side);
    }

    @Override
    public String toString() {
        return "Square[" + "side = " + getSide() + "]";
    }
}
