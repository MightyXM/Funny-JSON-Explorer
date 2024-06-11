package com.SoftwareEngineering.visualizer;

import com.fasterxml.jackson.databind.JsonNode;

public interface Visualizer {
    String visualize(JsonNode jsonNode);
}
