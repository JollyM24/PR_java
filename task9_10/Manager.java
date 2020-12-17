package task9_10;

public class Manager implements Main9_10.EmployeePosition {
    private int income;

    public static String getJobName() {
        return "Manager";
    }

    @Override
    public String getJobTitle() {
        return getJobName();
    }

    public int getIncome(){
        return income;
    }

    public static double getBaseConstSalary() {
    return 100000;
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
