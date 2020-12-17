package task9_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main9_10 {
    public static void main(String[] args) {
        Company company = new Company();
        company.hireAll();
        company.setIncome();

        System.out.println("Top Salary Staff:");
        List<Employee> top = company.getTopSalaryStaff(10);
        for (int i = 0; i < 10; ++i)
            System.out.println(top.get(i).position.calcSalary(top.get(i).position.getBaseSalary()));
        System.out.println();

        System.out.println("Least Salary Staff:");
        List<Employee> least = company.getLowestSalaryStaff(30);
        for (int i = 0; i < 30; ++i)
            System.out.println(least.get(i).position.calcSalary(least.get(i).position.getBaseSalary()));
    }

    public static class Employee {
        String name, surname;
        static EmployeePosition position;
    }

    public interface EmployeePosition {
        String getJobTitle();
        void setIncome(int i);
        double calcSalary(double baseSalary);
        double getBaseSalary();
    }

    public static class Company {
        ArrayList<Employee> employeeList = new ArrayList<>();

        public void setIncome() {
            Random random = new Random();
            for (Employee empl : employeeList)
                if (empl.position.getJobTitle().equals(Manager.getJobName()))
                    empl.position.setIncome(random.nextInt(25000) + 115000);
        }

        public int getTotalCompanyIncome() {
            int sum = 0;
            for (Employee e : employeeList)
                if (e.position.getJobTitle().equals(Manager.getJobName()))
                sum += ((Manager) e.position).getIncome();
                return sum;
        }

        int getIncome(Employee e) {
            String job = e.position.getJobTitle();
            if (job.equals(Manager.getJobName()))
                return (int) e.position.calcSalary(Manager.getBaseConstSalary());
            else if (job.equals(TopManager.getJobName()))
                return (int) e.position.calcSalary(TopManager.getBaseConstSalary());
            else if (job.equals(Operator.getJobName()))
                return (int) e.position.calcSalary(Operator.getBaseConstSalary());
            else return 0;
        }

        void hire(int kind){
            Employee person = new Employee();
            switch (kind) {
                case 0: person.position = new Operator();
                break;
                case 1: person.position = new Manager();
                break;
                case 2: person.position = new TopManager();
                break;
            }
            employeeList.add(person);
        }

        public void hireAll() {
            for (int i = 0; i < 180; ++i) hire(0);
            for (int i = 0; i < 80; ++i) hire(1);
            for (int i = 0; i < 10; ++i) hire(2);
        }

        void fire(Employee e) {
            employeeList.remove(e);
        }

        List<Employee> getTopSalaryStaff(int count) {
            for (int i = employeeList.size() - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (employeeList.get(j).position.calcSalary(employeeList.get(j).position.getBaseSalary()) <
                            employeeList.get(j + 1).position.calcSalary(employeeList.get(j + 1).position.getBaseSalary())) {
                        Employee tmp = employeeList.get(j);
                        employeeList.set(j, employeeList.get(j + 1));
                        employeeList.set(j + 1, tmp);
                    }
                }
            }
            ArrayList<Employee> res = new ArrayList<>();
            for (int i = 0; i < count; ++i)
                res.add(employeeList.get(i));
            return res;
        }

        List<Employee> getLowestSalaryStaff(int count) {
            for (int i = employeeList.size() - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (employeeList.get(j).position.calcSalary(employeeList.get(j).position.getBaseSalary()) >
                            employeeList.get(j + 1).position.calcSalary(employeeList.get(j + 1).position.getBaseSalary())) {
                        Employee tmp = employeeList.get(j);
                        employeeList.set(j, employeeList.get(j + 1));
                        employeeList.set(j + 1, tmp);
                    }
                }
            }
            ArrayList<Employee> res = new ArrayList<>();
            for (int i = 0; i < count; ++i)
                res.add(employeeList.get(i));
            return res;
        }
    }
}
