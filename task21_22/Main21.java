package task21_22;

public class Main21 {
    public static void main(String[] args) {
    ComplexNumber a = new ComplexNumber(1, 2);
    ComplexNumber b = new ComplexNumber(3, -4);
    System.out.println(a.add(a, b));
    }

    public static class ComplexNumber{
        double Re;
        double Im;
        String sign;

        public ComplexNumber(double Re, double Im){
            this.Re = Re;
            this.Im = Im;
            if (Im > 0) this.sign = "+";
        }

        public double getRe() {
            return Re;
        }

        public double getIm() {
            return Im;
        }

        public void Print(){
            System.out.println(this.toString());
        }

        @Override
        public String toString() {
            return (Re + (sign == "+" ? sign : "") + Im + "i");
        }

        public ComplexNumber add(ComplexNumber a, ComplexNumber b){
            return new ComplexNumber(a.getRe() + b.getRe(), a.getIm() + b.getIm());
        }

        public ComplexNumber sub(ComplexNumber a, ComplexNumber b){
            return new ComplexNumber(a.getRe() - b.getRe(), a.getIm() - b.getIm());
        }

        public ComplexNumber mul(ComplexNumber a, ComplexNumber b){
            return new ComplexNumber(a.getRe() * b.getRe() - a.getIm() * b.getIm(),
                    a.getIm() * b.getRe() + a.getRe() * b.getIm());
        }

        public ComplexNumber div(ComplexNumber a, ComplexNumber b) {
            int cd = (int) (Math.pow(b.getIm(), 2) + Math.pow(b.getIm(), 2));
            return new ComplexNumber(
                    (a.getRe() * b.getRe() + a.getIm() * b.getIm()) / cd,
                    (a.getIm() * b.getRe() - a.getRe() * b.getIm()) / cd);
        }
    }
}
