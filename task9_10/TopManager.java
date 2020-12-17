package task9_10;

public class TopManager implements Main9_10.EmployeePosition {
    private int income;

    public static double getBaseConstSalary() {
        return 200000;
    }

    public static String getJobName() {
        return "TopManager";
    }

    @Override
    public String getJobTitle() {
        return getJobName();
    }

    @Override
    public void setIncome(int i) {
        income = i;
    }

    @Override
    public double calcSalary(double baseSalary) {
        if (income > 10000000)
            return baseSalary + baseSalary*1.5;
        else return baseSalary;
    }

    @Override
    public double getBaseSalary() {
        return getBaseConstSalary();
    }
}
