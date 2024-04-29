package org.example.task3;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
public class Task3 {
    public static void main(String[] args) {

//        String valuesPath = "/Users/egorprozorov/Java/PerfomanceLabTestTask/src/main/java/org/example/task3/values.json";
//        String testsPath = "/Users/egorprozorov/Java/PerfomanceLabTestTask/src/main/java/org/example/task3/tests.json";
//        String reportPath = "/Users/egorprozorov/Java/PerfomanceLabTestTask/src/main/java/org/example/task3/report.json";

        String valuesPath = args[0];
        String testsPath = args[1];
        String reportPath = args[2];

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode valuesNode = mapper.readTree(new File(valuesPath));
            JsonNode testsNode = mapper.readTree(new File(testsPath));

            Map<Integer, String> valueMap = buildValueMap(valuesNode.get("values"));
            updateValues(testsNode.get("tests"), valueMap);

            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(reportPath), testsNode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Map<Integer, String> buildValueMap(JsonNode values) {
        Map<Integer, String> valueMap = new HashMap<>();
        for (JsonNode value : values) {
            Integer id = value.get("id").intValue();
            String val = value.get("value").textValue();
            valueMap.put(id, val);
        }
        return valueMap;
    }

    private static void updateValues(JsonNode tests, Map<Integer, String> valueMap) {
        if (tests.isArray()) {
            for (JsonNode test : tests) {
                updateValues(test, valueMap);
            }
        } else if (tests.isObject()) {
            int id = tests.get("id").intValue();
            if (valueMap.containsKey(id)) {
                ((ObjectNode) tests).put("value", valueMap.get(id));
            }
            if (tests.has("values")) {
                updateValues(tests.get("values"), valueMap);
            }
        }
    }
}
