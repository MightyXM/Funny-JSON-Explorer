package com.SoftwareEngineering.visualizer;

import com.SoftwareEngineering.visitor.VisualizerVisitor;
import com.fasterxml.jackson.databind.JsonNode;

public interface VisualizerElement {
    void accept(VisualizerVisitor visitor, JsonNode rootNode);
}
