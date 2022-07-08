package ru.job4j.ood.isp;

public class User1 implements GenerateReport {
    @Override
    public String generateToTXT() {
        System.out.println("Generate TXT Report");
        return "TXT Report";
    }

    @Override
    public String generateToHTML() {
        return null;
    }

    @Override
    public String generateToXML() {
        return null;
    }
}
