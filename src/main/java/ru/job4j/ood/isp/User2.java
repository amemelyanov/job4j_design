package ru.job4j.ood.isp;

public class User2 implements GenerateReport {
    @Override
    public String generateToTXT() {
        return null;
    }

    @Override
    public String generateToHTML() {
        System.out.println("Generate HTML Report");
        return "HTML Report";
    }

    @Override
    public String generateToXML() {
        System.out.println("Generate XML Report");
        return "XML Report";
    }
}
