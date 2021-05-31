package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportCounting implements Report {

    @Override
    public String generate(Predicate<Employee> filter, Store store) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary in dollars;").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(String.format("%.2f", employee.getSalary() / 75)).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
