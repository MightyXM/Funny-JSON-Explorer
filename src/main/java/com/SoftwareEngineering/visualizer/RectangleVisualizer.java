package com.SoftwareEngineering.visualizer;

import com.fasterxml.jackson.databind.JsonNode;
import com.SoftwareEngineering.icon.IconFactory;

public class RectangleVisualizer implements Visualizer {
    private final IconFactory iconFactory;
    int maxLineLength = 55;
    public RectangleVisualizer(IconFactory iconFactory) {
        this.iconFactory = iconFactory;
    }

    @Override
    public String visualize(JsonNode jsonNode) {
        StringBuilder sb = new StringBuilder();
        String str_head = "┌" + "─".repeat(maxLineLength - 1) + "┐\n";
        sb.append(str_head);
        visualizeNode(jsonNode, sb, "", true,0);
        String str_foot = "└" + "─".repeat(maxLineLength-1) + "┘\n";
        sb.append(str_foot);
        return sb.toString();
    }

    private void visualizeNode(JsonNode node, StringBuilder sb, String prefix, boolean isTail,int depth) {
         // Adjust as needed
//        int lineLength = maxLineLength - depth * 4; // Decrease line length by 4 for each depth
//        if (lineLength < 0) lineLength = 0; // Ensure non-negative length
//        String line = "─".repeat(lineLength);
        if (node.isObject()) {
            var iter = node.fields();
            while (iter.hasNext()) {
                StringBuilder sbtmp = new StringBuilder();
                var entry = iter.next();
                boolean last = !iter.hasNext();
                sbtmp.append(prefix)
//                            .append(last ? iconFactory.getTailIcon() : iconFactory.getBranchIcon())
                        .append(iconFactory.getBranchIcon())
                        .append(entry.getKey());
                String line = "─".repeat(maxLineLength-sbtmp.length());
//                if(depth==0){
////                    sb.append(sbtmp).append(line).append("┐").append("\n");
//                    sb.append(sbtmp).append(line).append("│").append("\n");
//                }else
//                    sb.append(sbtmp).append(line).append("│").append("\n");
                sb.append(sbtmp).append(line).append("│").append("\n");
                visualizeNode(entry.getValue(), sb, prefix + (last ? "│    " : iconFactory.getPipeIcon()), last, depth+1);
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                boolean last = i == node.size() - 1;
                visualizeNode(node.get(i), sb, prefix + (last ? "│    " : iconFactory.getPipeIcon()), last, depth+1);
            }
        } else {
            StringBuilder sbtmp = new StringBuilder();
            sbtmp.append(prefix)
                    .append(isTail ? iconFactory.getTailIcon() : iconFactory.getBranchIcon())
                    .append(node.isTextual() ? node.asText() : node.toString());
            String line = "─".repeat(maxLineLength-sbtmp.length());
            sb.append(sbtmp).append(line).append("│").append("\n");
        }
    }
}
