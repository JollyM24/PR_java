package com.company;

public class PR6 {
    public interface Movable{
        public void move(int new_x, int new_y);
    }//Movable - move(x, y)

    public static class Rectangle{//class Rectangle
        public int x1;
        public int y1;
        public int x2;
        public int y2;

        public PR_5.Point A;
        public PR_5.Point B;

        Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;

            this.A = new PR_5.Point(x1, y1);
            this.B = new PR_5.Point(x2, y2);
        }

        public void setA(PR_5.Point A){
            this.A = A;
        }

        public void setB(PR_5.Point B){
            this.B = B;
        }

        public PR_5.Point getA(){
            return A;
        }

        public PR_5.Point getB(){
            return B;
        }

        @Override
        public String toString() {
            return "Rectangle[MovableRectangle] { A(" + A.getX() +", " + A.getY() + "), " +
                    "B(" + B.getX() + ", " + B.getY() + ") }";
        }
    }

    ////////Прямоугольник с A(x1, y1), B(x1, y2), C(x2, y1), D(x2, y2)
    static class MovableRectangle extends Rectangle implements Movable{
        public MovableRectangle(int x1, int y1, int x2, int y2) {
            super(x1, y1, x2, y2);
        }

        public static PR_5.MovablePoint PointToMovablePoint(PR_5.Point a){
            return new PR_5.MovablePoint(a.getX(), a.getY());
        }

        @Override
        public void move(int new_x, int new_y) {
            PR_5.Point A = getA();
            PR_5.MovablePoint MA = PointToMovablePoint(A);
            MA.move(new_x, new_y);
            A.setX(MA.getX());
            A.setY(MA.getY());
            setA(A);

            PR_5.Point B = getB();
            PR_5.MovablePoint MB = PointToMovablePoint(B);
            MB.move(new_x, new_y);
            B.setX(MB.getX());
            B.setY(MB.getY());
            setB(B);
        }
    }

    ////////Прямоугольник с A(x1, y1), B(x2, y2)
    public static class MovablePoints implements PR_5.Movable{
        public PR_5.MovablePoint MA;
        public PR_5.MovablePoint MB;

        MovablePoints(PR_5.MovablePoint MA, PR_5.MovablePoint MB){
            this.MA = MA;
            this.MB = MB;
        }

        @Override
        public void move(int new_x, int new_y) {
            MA.move(new_x, new_y);
            MB.move(new_x, new_y);
        }

        @Override
        public String toString() {
            return "Rectangle[MovablePoints] { A(" + MA.getX() +", " + MA.getY() + "), " +
                    "B(" + MB.getX() + ", " + MB.getY() + ") }";
        }
    }

    public static void main(String[] args) {
        PR_5.MovablePoint a1 = new PR_5.MovablePoint(1,1);
        PR_5.MovablePoint b1 = new PR_5.MovablePoint(5, 3);
        MovablePoints rec1 = new MovablePoints(a1, b1);

        MovableRectangle rec2 = new MovableRectangle(0, 0,4, 2);

        System.out.println("\n Rectangles");
        System.out.println(rec1.toString());
        System.out.println(rec2.toString());

        System.out.println("\nMove to (2, 2): ");
        rec1.move(2, 2);
        rec2.move(2, 2);

        System.out.println(rec1.toString());
        System.out.println(rec2.toString());
    }
}
