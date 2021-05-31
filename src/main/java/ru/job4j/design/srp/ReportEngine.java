package ru.job4j.design.srp;

public class ReportEngine {
    static ReportFactory createReportFactoryBySpeciality(String speciality) {
        if (speciality.equalsIgnoreCase("html")) {
            return new ReportHTMLFactory();
        } else if (speciality.equalsIgnoreCase("hr")) {
            return new ReportHRFactory();
        } else if (speciality.equalsIgnoreCase("old")) {
            return new ReportOldFactory();
        } else if (speciality.equalsIgnoreCase("counting")) {
            return new ReportCountingFactory();
        } else {
            throw new RuntimeException(speciality + " is unknown speciality");
        }
    }
}