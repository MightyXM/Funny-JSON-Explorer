package com.SoftwareEngineering.aggregate;

import com.SoftwareEngineering.iterator.ConcreteVisualizerIterator;
import com.SoftwareEngineering.iterator.VisualizerIterator;
import com.SoftwareEngineering.visualizer.VisualizerElement;

import java.util.ArrayList;
import java.util.List;

public class VisualizerCollection implements VisualizerAggregate{
    private List<VisualizerElement> visualizers = new ArrayList<>();

    public void addVisualizer(VisualizerElement visualizer) {
        visualizers.add(visualizer);
    }

    @Override
    public VisualizerIterator createIterator() {
        return new ConcreteVisualizerIterator(visualizers);
    }
}
