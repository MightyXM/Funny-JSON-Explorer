package com.SoftwareEngineering.visitor;

import com.SoftwareEngineering.visualizer.RectangleVisualizer;
import com.SoftwareEngineering.visualizer.TreeVisualizer;
import com.fasterxml.jackson.databind.JsonNode;

public class ConcreteVisualizerVisitor implements VisualizerVisitor{
    @Override
    public void visit(TreeVisualizer treeVisualizer, JsonNode jsonNode) {
        System.out.println("Visiting Tree Visualizer");
        System.out.println(treeVisualizer.visualize(jsonNode));
    }

    @Override
    public void visit(RectangleVisualizer rectangleVisualizer, JsonNode jsonNode) {
        System.out.println("Visiting Rectangle Visualizer");
        System.out.println(rectangleVisualizer.visualize(jsonNode));
    }
}
