package task9_10;

public class Operator implements Main9_10.EmployeePosition {
    private int income;

    public static String getJobName() {
        return "Operator";
    }

    @Override
    public String getJobTitle() {
        return getJobName();
    }

    public static double getBaseConstSalary() {
        return 50000;
    }

    @Override
    public double getBaseSalary() {
        return getBaseConstSalary();
    }

    @Override
    public void setIncome(int i) {
        income = i;
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary + income * 0.05;
    }

}
