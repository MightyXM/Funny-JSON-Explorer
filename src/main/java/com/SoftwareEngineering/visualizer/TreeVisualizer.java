package com.SoftwareEngineering.visualizer;

import com.fasterxml.jackson.databind.JsonNode;
import com.SoftwareEngineering.icon.IconFactory;

public class TreeVisualizer implements Visualizer {
    private final IconFactory iconFactory;

    public TreeVisualizer(IconFactory iconFactory) {
        this.iconFactory = iconFactory;
    }

    @Override
    public String visualize(JsonNode jsonNode) {
        StringBuilder sb = new StringBuilder();
        visualizeNode(jsonNode, sb, "", true);
        return sb.toString();
    }

    private void visualizeNode(JsonNode node, StringBuilder sb, String prefix, boolean isTail) {
        if (node.isObject()) {
            var iter = node.fields();
            while (iter.hasNext()) {
                var entry = iter.next();
                boolean last = !iter.hasNext();
                sb.append(prefix)
                        .append(last ? iconFactory.getTailIcon() : iconFactory.getBranchIcon())
                        .append(entry.getKey())
                        .append("\n");
                visualizeNode(entry.getValue(), sb, prefix + (last ? "     " : iconFactory.getPipeIcon()), last);
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                boolean last = i == node.size() - 1;
                visualizeNode(node.get(i), sb, prefix, last);
            }
        } else {
            sb.append(prefix)
                    .append(isTail ? iconFactory.getTailIcon() : iconFactory.getBranchIcon())
                    .append(node.isTextual() ? node.asText() : node.toString())
                    .append("\n");
        }
    }
}