package ru.job4j.design.srp;

public class ReportHTMLFactory implements ReportFactory {
    @Override
    public Report createReport() {
        return new ReportHTML();
    }
}
