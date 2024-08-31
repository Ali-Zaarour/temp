package dev.alizaarour.util.formater;

import java.util.ArrayList;
import java.util.List;

public class JsonLeaf<T> implements JsonComponent {

    private final String key;
    private List<T> values;

    public JsonLeaf(String key, T value) {
        this.key = key;
        this.values = new ArrayList<>();
        this.values.add(value);
    }

    public JsonLeaf(String key, List<T> values) {
        this.key = key;
        if (values.isEmpty()) this.values = new ArrayList<>();
        else this.values = values;
    }

    private String indent(int indentSize) {
        return "\t".repeat(Math.max(0, indentSize));
    }

    @Override
    public String toJson() {
        return toJson(0);
    }


    @Override
    public String toJson(int indentSize) {
        StringBuilder json = new StringBuilder();
        if (values.size() > 1) {
            json.append(indent(indentSize)).append("\"").append(key).append("\" : ").append("[");
            for (T value : values) {
                if (value instanceof String) {
                    json.append("\"").append(value).append("\"").append(",");
                } else {
                    json.append(value).append(",");
                }
            }
            json.deleteCharAt(json.length() - 1);
            json.append("]");
        } else {
            json.append(indent(indentSize)).append("\"").append(key).append("\" : ");
            if (values.isEmpty()) {
                json.append("null");
            } else if (values.size() == 1 && values.get(0) instanceof String) {
                json.append("\"").append(values.get(0)).append("\"");
            } else if (values.size() == 1) {
                json.append(values.get(0));
            }
        }
        return json.toString();
    }
}
