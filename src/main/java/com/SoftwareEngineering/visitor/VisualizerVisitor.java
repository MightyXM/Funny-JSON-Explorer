package com.SoftwareEngineering.visitor;

import com.SoftwareEngineering.visualizer.RectangleVisualizer;
import com.SoftwareEngineering.visualizer.TreeVisualizer;
import com.fasterxml.jackson.databind.JsonNode;

public interface VisualizerVisitor {
    void visit(TreeVisualizer treeVisualizer, JsonNode jsonNode);
    void visit(RectangleVisualizer rectangleVisualizer, JsonNode jsonNode);
}
