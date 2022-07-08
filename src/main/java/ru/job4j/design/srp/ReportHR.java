package ru.job4j.design.srp;

import java.util.List;
import java.util.function.Predicate;

public class ReportHR implements Report {

    @Override
    public String generate(Predicate<Employee> filter, Store store) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;").append(System.lineSeparator());
        List<Employee> rsl = store.findBy(filter);
        rsl.sort((e1, e2) -> (int) (e2.getSalary() - e1.getSalary()));
        for (Employee employee : rsl) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
