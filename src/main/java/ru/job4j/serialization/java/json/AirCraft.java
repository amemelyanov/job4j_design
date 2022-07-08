package ru.job4j.serialization.java.json;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public boolean isPassenger() {
        return isPassenger;
    }

    public int getRangeOfFlight() {
        return rangeOfFlight;
    }

    public String getModelName() {
        return modelName;
    }

    public Engine getEngine() {
        return engine;
    }

    public String[] getSubModels() {
        return subModels;
    }

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

        public String getName() {
            return name;
        }

        public int getHorsePower() {
            return horsePower;
        }

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
        final AirCraft airCraft = new AirCraft(true, 6000,
                "A320", new Engine("CFM", 105900), subModels);

        JSONObject jsonEngine = new JSONObject("{\"name\":\"CFM\", \"horsePower\":\"105900\"}");

        List<String> list = new ArrayList<>();
        list.add("A318");
        list.add("A319");
        list.add("A321");
        JSONArray jsonSubmodels = new JSONArray(list);
        
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isPassenger", airCraft.isPassenger());
        jsonObject.put("rangeOfFlight", airCraft.getRangeOfFlight());
        jsonObject.put("modelName", airCraft.getModelName());
        jsonObject.put("engine", jsonEngine);
        jsonObject.put("subModels", jsonSubmodels);

        System.out.println(jsonObject);

        System.out.println(new JSONObject(airCraft).toString());
    }
}
