package com.SoftwareEngineering.iterator;

import com.SoftwareEngineering.visualizer.VisualizerElement;

import java.util.List;

public class ConcreteVisualizerIterator implements VisualizerIterator{
    private List<VisualizerElement> visualizers;
    private int position = 0;

    public ConcreteVisualizerIterator(List<VisualizerElement> visualizers) {
        this.visualizers = visualizers;
    }

    @Override
    public boolean hasNext() {
        return position < visualizers.size();
    }

    @Override
    public VisualizerElement next() {
        if (this.hasNext()) {
            return visualizers.get(position++);
        }
        return null;
    }
}
