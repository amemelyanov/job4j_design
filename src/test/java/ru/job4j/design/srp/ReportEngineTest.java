package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report report = ReportEngine.createReportFactoryBySpeciality("old");
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(report.generate(em -> true, store), is(expect.toString()));
    }

    @Test
    public void whenHtmlGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report report = ReportEngine.createReportFactoryBySpeciality("html");
        StringBuilder expect = new StringBuilder()
            .append("<!DOCTYPE html>")
            .append("<html><head><title></title></head><body>")
            .append("<table><tr><th>Name</th><th>Hired</th><th>Fired</th><th>Salary</th></tr>")
            .append("<tr><td>").append(worker.getName()).append("</td>")
            .append("<td>").append(worker.getHired()).append("</td>")
            .append("<td>").append(worker.getFired()).append("</td>")
            .append("<td>").append(worker.getSalary()).append("</td></tr>")
            .append("</table></body></html>");
        assertThat(report.generate(em -> true, store), is(expect.toString()));
    }

    @Test
    public void whenHRGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Petr", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        Report report = ReportEngine.createReportFactoryBySpeciality("hr");
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getHired()).append(";")
                .append(worker2.getFired()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator());
                expect.append(worker1.getName()).append(";")
                .append(worker1.getHired()).append(";")
                .append(worker1.getFired()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(report.generate(em -> true, store), is(expect.toString()));
    }

    @Test
    public void whenCountingGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report report = ReportEngine.createReportFactoryBySpeciality("counting");
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary in dollars;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(String.format("%.2f", worker.getSalary() / 75)).append(";")
                .append(System.lineSeparator());
        assertThat(report.generate(em -> true, store), is(expect.toString()));
    }
}