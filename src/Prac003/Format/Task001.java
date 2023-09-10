package Prac003.Format;

import java.util.ArrayList;

public class Task001 {
    public static void main(String[] args) {
        System.out.println(Converter.roublesToDollar(324234.342));
        System.out.println(Shop.buyItem("computer", "usd"));
        Report.generateTestEmployees();
        System.out.println(Report.generateReport());
    }
}

class Converter {
    public static double roublesToEuro(double roubles) {
        return roubles / 105.20;
    }

    public static double roublesToDollar(double roubles) {
        return roubles / 97.75;
    }

    public static double euroToRoubles(double euro) {
        return euro * 105.20;
    }

    public static double dollarToRoubles(double dollar) {
        return dollar * 97.75;
    }
}

class Shop {
    public static double buyItem(String item, String currency) {
        switch (item) {
            case "computer":
                switch (currency) {
                    case "rub":
                        return HPComputer.rPrice;
                    case "usd":
                        return HPComputer.dlrPrice;
                    case "eur":
                        return HPComputer.euPrice;
                }
            case "phone":
                switch (currency) {
                    case "rub":
                        return AppleIPhone.rPrice;
                    case "usd":
                        return AppleIPhone.dlrPrice;
                    case "eur":
                        return AppleIPhone.euPrice;
                }
            case "watch":
                switch (currency) {
                    case "rub":
                        return SmartWatch.rPrice;
                    case "usd":
                        return SmartWatch.dlrPrice;
                    case "eur":
                        return SmartWatch.euPrice;
                }
            case "case":
                switch (currency) {
                    case "rub":
                        return PhoneCase.rPrice;
                    case "usd":
                        return PhoneCase.dlrPrice;
                    case "eur":
                        return PhoneCase.euPrice;
                }
        }
        return 0.0;
    }
}

interface HPComputer {
    double rPrice = 59990;
    double euPrice = Converter.roublesToEuro(rPrice);
    double dlrPrice = Converter.roublesToDollar(rPrice);
}

interface AppleIPhone {
    double rPrice = 63990;
    double euPrice = Converter.roublesToEuro(rPrice);
    double dlrPrice = Converter.roublesToDollar(rPrice);
}

interface SmartWatch {
    double rPrice = 21490;
    double euPrice = Converter.roublesToEuro(rPrice);
    double dlrPrice = Converter.roublesToDollar(rPrice);
}

interface PhoneCase {
    double rPrice = 1399;
    double euPrice = Converter.roublesToEuro(rPrice);
    double dlrPrice = Converter.roublesToDollar(rPrice);
}

class Employee {
    private String fullname;
    private double salary;

    Employee(String fullname, double salary) {
        this.fullname = fullname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %30.2f", fullname, salary);
    }
}

class Report {
    static ArrayList<Employee> employees = new ArrayList<>(16);

    static void addEmployee(Employee empl) {
        employees.add(empl);
    }

    static void generateTestEmployees() {
        for (int i = 0; i < 16; i++) {
            addEmployee(new Employee("Nikolay S. " + (i + 1), 42342.23 * (i + 1) / 3));
        }
    }

    static String generateReport() {
        StringBuilder sb = new StringBuilder();
        for (Employee empl : employees) {
            sb.append(empl).append("\n");
        }
        return sb.toString();
    }
}
