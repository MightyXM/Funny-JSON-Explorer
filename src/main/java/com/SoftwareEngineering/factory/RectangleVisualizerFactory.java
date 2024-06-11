package com.SoftwareEngineering.factory;

import com.SoftwareEngineering.icon.*;
import com.SoftwareEngineering.visualizer.RectangleVisualizer;
import com.SoftwareEngineering.visualizer.Visualizer;

public class RectangleVisualizerFactory extends VisualizerFactory{
    private final IconFactory iconFactory;

    public RectangleVisualizerFactory(String iconFamily) {
        switch (iconFamily.toLowerCase()) {
            case "default":
                this.iconFactory = new DefaultIconFactory();
                break;
            case "card":
                this.iconFactory = new cardFactory();
                break;
            case "new":
                this.iconFactory = new newIcon();
                break;
            default:
                throw new IllegalArgumentException("Unknown icon family: " + iconFamily);
        }
    }

    @Override
    public Visualizer createVisualizer() {
        return new RectangleVisualizer(iconFactory);
    }
}
