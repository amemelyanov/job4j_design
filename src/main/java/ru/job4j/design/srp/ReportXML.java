package ru.job4j.design.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.function.Predicate;

public class ReportXML implements Report {
    @Override
    public String generate(Predicate<Employee> filter, Store store) {
        Employees employees = new Employees(store.findBy(filter));
        StringBuilder xml = new StringBuilder();
        try (StringWriter writer = new StringWriter()) {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(employees, writer);
            xml.append(writer.getBuffer().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xml.toString();
    }
}
