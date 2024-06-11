package com.SoftwareEngineering.factory;

import com.SoftwareEngineering.icon.DefaultIconFactory;
import com.SoftwareEngineering.icon.IconFactory;
import com.SoftwareEngineering.icon.cardFactory;
import com.SoftwareEngineering.icon.newIcon;
import com.SoftwareEngineering.visualizer.TreeVisualizer;
import com.SoftwareEngineering.visualizer.Visualizer;

public class TreeVisualizerFactory extends VisualizerFactory{
    private final IconFactory iconFactory;

    public TreeVisualizerFactory(String iconFamily) {
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
        return new TreeVisualizer(iconFactory);
    }
}
