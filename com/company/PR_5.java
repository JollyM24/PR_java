package com.company;

public class PR_5 {
    public interface Movable{
        public void move(int x, int y);
    }

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public void setX(int x){
            this.x = x;
        }

        public int getX(){
            return x;
        }

        public void setY(int y){
            this.y = y;
        }

        public int getY(){
            return y;
        }

        @Override
        public String toString() {
            return "Point {" + "x=" + x +", y=" + y + '}';
        }
    }

    static class MovablePoint extends Point implements Movable{
        public MovablePoint(int x, int y) {
            super(x, y);
        }

        public void move(int x, int y){
            this.setX(getX() + x);
            this.setY(getY() + y);
        }
    }

    public static void main(String[] args) {
        MovablePoint MP = new MovablePoint(5,8);
        System.out.println(MP);
        System.out.println("Move to (15, 2): ");
        MP.move(15,2);
        System.out.println(MP);
    }
}
