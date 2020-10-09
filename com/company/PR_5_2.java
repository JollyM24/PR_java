package com.company;


public class PR_5_2 {
    public interface Movable{
        public void move(int x, int y);
    }

    public  static class Circle {
        private PR_5.Point center;
        private double radius;

        public Circle(PR_5.Point center, double radius) {
            this.center = center;
            this.radius = radius;
        }
        public void setCenter(PR_5.Point center) {
            this.center = center;
        }

        public PR_5.Point getCenter() {
            return center;
        }

        public double getRadius(){
            return radius;
        }

        @Override
        public String toString() {
            return "Circle{" + "center=" + center + ", radius=" + radius + '}';
        }
    }

    static class MovableCircle extends  Circle implements Movable{
        public MovableCircle(PR_5.Point center, double radius) {
            super(center, radius);
        }

        /////////////////////////   PointToMovablePoint ////////////////////////
        public static PR_5.MovablePoint PointToMovablePoint(PR_5.Point a){
            return new PR_5.MovablePoint(a.getX(), a.getY());
        }

        @Override
        public void move(int x, int y) {
            PR_5.Point center = getCenter();
            PR_5.MovablePoint c = PointToMovablePoint(center);
            c.move(x, y);
            center.setX(c.getX());
            center.setY(c.getY());
            setCenter(center);
        }
    }

    public static void main(String[] args) {
        MovableCircle circle = new MovableCircle(new PR_5.Point(0, 0), 5);
        System.out.println(circle.toString() + "\n");
        System.out.println("Move to (2, 4): ");
        circle.move(2, 4);
        System.out.println(circle.toString() + "\n");
    }
}