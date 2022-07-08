package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportHTML implements Report {

    @Override
    public String generate(Predicate<Employee> filter, Store store) {
        StringBuilder text = new StringBuilder();
        text.append("<!DOCTYPE html>");
        text.append("<html><head><title></title></head><body>");
        text.append("<table><tr><th>Name</th><th>Hired</th><th>Fired</th><th>Salary</th></tr>");
        for (Employee employee : store.findBy(filter)) {
            text.append("<tr><td>").append(employee.getName()).append("</td>")
                    .append("<td>").append(employee.getHired()).append("</td>")
                    .append("<td>").append(employee.getFired()).append("</td>")
                    .append("<td>").append(employee.getSalary()).append("</td></tr>");
        }
        text.append("</table></body></html>");
        return text.toString();
    }
}
