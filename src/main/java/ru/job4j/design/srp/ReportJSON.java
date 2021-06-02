package ru.job4j.design.srp;

import org.json.JSONObject;

import java.util.function.Predicate;

public class ReportJSON implements Report {
        @Override
        public String generate(Predicate<Employee> filter, Store store) {
            StringBuilder text = new StringBuilder();
            JSONObject jsonObject;
            for (Employee employee : store.findBy(filter)) {
                jsonObject = new JSONObject();
                jsonObject.put("name", employee.getName());
                jsonObject.put("hired", employee.getHired().getTime());
                jsonObject.put("fired", employee.getFired().getTime());
                jsonObject.put("salary", employee.getSalary());
                text.append(jsonObject);
            }
            return text.toString();
        }
    }