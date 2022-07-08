package ru.job4j.design.srp;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.List;
import java.util.function.Predicate;

public class ReportJSON implements Report {
        @Override
        public String generate(Predicate<Employee> filter, Store store) {
            List<Employee> employees = store.findBy(filter);
            JSONArray jsonArray = new JSONArray();
            for (Employee employee : employees) {
                JSONObject jsonField = new JSONObject();
                jsonField.put("name", employee.getName());
                jsonField.put("hired", employee.getHired().getTime());
                jsonField.put("fired", employee.getFired().getTime());
                jsonField.put("salary", employee.getSalary());
                jsonArray.put(jsonField);
            }
            return jsonArray.toString();
        }
    }