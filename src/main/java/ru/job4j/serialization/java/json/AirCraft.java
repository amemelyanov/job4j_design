package ru.job4j.serialization.java.json;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "aircraft")
@XmlAccessorType(XmlAccessType.FIELD)
public class AirCraft {
    @XmlAttribute
    private boolean isPassenger;

    @XmlAttribute
    private int rangeOfFlight;

    @XmlAttribute
    private String modelName;

    @XmlElement(name = "engine")
    private Engine engine;

    @XmlElementWrapper(name = "subModels")
    @XmlElement(name = "subModel")
    private String[] subModels;

    public AirCraft() { }

    public AirCraft(boolean isPassenger, int rangeOfFlight, String modelName, Engine engine, String[] subModels) {
        this.isPassenger = isPassenger;
        this.rangeOfFlight = rangeOfFlight;
        this.modelName = modelName;
        this.engine = engine;
        this.subModels = subModels;
    }

    @Override
    public String toString() {
        return "AirCraft{"
                + "isPassenger=" + isPassenger
                + ", rangeOfFlight=" + rangeOfFlight
                + ", modelName='" + modelName + '\''
                + ", engine=" + engine
                + ", subModels=" + Arrays.toString(subModels)
                + '}';
    }

    public static class Engine {
        @XmlAttribute
        private String name;

        @XmlAttribute
        private int horsePower;

        public Engine() { }

        public Engine(String name, int horsePower) {
            this.name = name;
            this.horsePower = horsePower;
        }

        @Override
        public String toString() {
            return "Engine{"
                    + "name='"
                    + name + '\''
                    + ", horsePower=" + horsePower
                    + '}';
        }
    }

    public static void main(String[] args) throws JAXBException {
        String[] subModels = {"A318", "A319", "A321"};
        AirCraft airCraft = new AirCraft(true, 6000,
                "A320", new Engine("CFM", 105900), subModels);

        JAXBContext context = JAXBContext.newInstance(AirCraft.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String result = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(airCraft, writer);
            result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(result)) {
            AirCraft xmlAirCraft = (AirCraft) unmarshaller.unmarshal(reader);
            System.out.println(xmlAirCraft);
        }
    }
}
