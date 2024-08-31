package dev.alizaarour.util.formater;

import java.util.ArrayList;
import java.util.List;

public class JsonComposite implements JsonComponent {
    private final String key;
    private List<JsonComponent> children;

    public JsonComposite(String key) {
        this.key = key;
        this.children = new ArrayList<>();
    }

    public void addChild(JsonComponent child) {
        children.add(child);
    }

    @Override
    public String toJson() {
        return toJson(0);
    }

    @Override
    public String toJson(int indentSize) {
        StringBuilder json = new StringBuilder();
        json.append(indent(indentSize)).append("\"").append(key).append("\" : ").append("\n").append(indent(indentSize)).append("{").append("\n");

        for (JsonComponent child : children) {
            //if child of type JsonLeaf then use the same indentSize
            if (child instanceof JsonLeaf) {
                json.append(child.toJson(indentSize + 1)).append(",").append("\n");
            }
            //if child of type JsonComposite then increase the indentSize by 1
            else if (child instanceof JsonComposite) {
                json.append(child.toJson(indentSize + 1)).append(",").append("\n");
            }
        }
        json.deleteCharAt(json.length() - 2);
        json.append(indent(indentSize)).append("}");
        return json.toString();
    }

    private String indent(int indentSize) {
        return "\t".repeat(Math.max(0, indentSize));
    }
}
