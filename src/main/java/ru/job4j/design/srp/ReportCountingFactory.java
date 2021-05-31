package ru.job4j.design.srp;

public class ReportCountingFactory implements ReportFactory {
    @Override
    public Report createReport() {
        return new ReportCounting();
    }
}
