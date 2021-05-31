package ru.job4j.design.srp;

public class ReportOldFactory implements ReportFactory {

    @Override
    public Report createReport() {
        return new ReportOld();
    }
}
