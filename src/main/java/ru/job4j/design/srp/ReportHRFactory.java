package ru.job4j.design.srp;

public class ReportHRFactory implements ReportFactory {
    @Override
    public Report createReport() {
        return new ReportHR();
    }
}
