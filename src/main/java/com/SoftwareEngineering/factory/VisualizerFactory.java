package com.SoftwareEngineering.factory;

import com.SoftwareEngineering.visualizer.Visualizer;

public abstract class VisualizerFactory {
    public abstract Visualizer createVisualizer();

    public static VisualizerFactory getFactory(String style, String iconFamily) {
        switch (style.toLowerCase()) {
            case "tree":
                return new TreeVisualizerFactory(iconFamily);
            case "rec":
                return new RectangleVisualizerFactory(iconFamily);
            default:
                throw new IllegalArgumentException("Unknown style: " + style);
        }
    }
}
