package task15;

public class main2 {
    public static void main(String[] args) {
        new Robot();
    }

    public static class Robot{
        Object Legs = new Object();
        RightLeg Right = new RightLeg(Legs);
        LeftLeg Left = new LeftLeg(Legs);

        Robot(){
            Right.start();
            Left.start();
        }
    }

    public static class RightLeg extends Thread{
        Object Legs;

        public RightLeg(Object Legs) {
            this.Legs = Legs;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    synchronized(Legs) {
                        Legs.wait();
                    }
                } catch (InterruptedException e) {}
                System.out.println("RIGHT");
                try {
                    sleep(1000);
                } catch (InterruptedException e1) {}
                synchronized(Legs) {
                    Legs.notify();
                }
            }
        }
    }

    public static class LeftLeg extends Thread{
        Object Legs;

        public LeftLeg(Object Legs) {
            this.Legs = Legs;
        }

        @Override
        public void run() {
            while(true) {
                System.out.println("LEFT");
                try {
                    sleep(1000);
                } catch (InterruptedException e1) {}
                synchronized(Legs) {
                    Legs.notify();
                }
                try {
                    synchronized(Legs) {
                        Legs.wait();
                    }
                } catch (InterruptedException e) {}
            }
        }
    }
}
