package ru.job4j.design.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.function.Predicate;

public class ReportXML implements Report {
    @Override
    public String generate(Predicate<Employee> filter, Store store) {
        StringBuilder xml = new StringBuilder();
        try (StringWriter writer = new StringWriter()) {
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            for (Employee employee : store.findBy(filter)) {
                marshaller.marshal(employee, writer);
            }
            xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
            xml.append(writer.getBuffer().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xml.toString();
    }
}
