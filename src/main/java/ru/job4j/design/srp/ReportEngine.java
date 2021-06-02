package ru.job4j.design.srp;

public class ReportEngine {
    static Report createReportFactoryBySpeciality(String speciality) {
        if (speciality.equalsIgnoreCase("html")) {
            return new ReportHTML();
        } else if (speciality.equalsIgnoreCase("hr")) {
            return new ReportHR();
        } else if (speciality.equalsIgnoreCase("old")) {
            return new ReportOld();
        } else if (speciality.equalsIgnoreCase("counting")) {
            return new ReportCounting();
        } else if (speciality.equalsIgnoreCase("json")) {
            return new ReportJSON();
        } else if (speciality.equalsIgnoreCase("xml")) {
            return new ReportXML();
        } else {
            throw new RuntimeException(speciality + " is unknown speciality");
        }
    }
}