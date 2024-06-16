package com.SoftwareEngineering;

import com.SoftwareEngineering.aggregate.VisualizerCollection;
import com.SoftwareEngineering.factory.VisualizerFactory;
import com.SoftwareEngineering.iterator.VisualizerIterator;
import com.SoftwareEngineering.visitor.ConcreteVisualizerVisitor;
import com.SoftwareEngineering.visualizer.Visualizer;
import com.SoftwareEngineering.visualizer.VisualizerElement;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.cli.*;

import java.io.IOException;

public class FunnyJsonExplorer2 {
    public static void main(String[] args) {
        // 定义命令行选项
        Options options = new Options();

        Option fileOption = new Option("f", "file", true, "JSON file path");
        fileOption.setRequired(true);
        options.addOption(fileOption);

        Option styleOption = new Option("s", "style", true, "Visualizer style (tree/rectangle)");
        styleOption.setRequired(true);
        options.addOption(styleOption);

        Option iconOption = new Option("i", "icon", true, "Icon family (default/rectangle)");
        iconOption.setRequired(true);
        options.addOption(iconOption);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("fje", options);
            System.exit(1);
            return;
        }

        String filePath = cmd.getOptionValue("file");
        String style = cmd.getOptionValue("style");
        String iconFamily = cmd.getOptionValue("icon");

        try {
            JsonNode jsonNode = JsonUtils.readJsonFile(filePath);
            VisualizerFactory factory = VisualizerFactory.getFactory(style, iconFamily);
            Visualizer visualizer = factory.createVisualizer();

            // 创建可视化器集合
            VisualizerCollection visualizerCollection = new VisualizerCollection();
            visualizerCollection.addVisualizer((VisualizerElement) visualizer);

            // 创建迭代器
            VisualizerIterator iterator = visualizerCollection.createIterator();

            // 创建访问者
            ConcreteVisualizerVisitor visitor = new ConcreteVisualizerVisitor();

            // 迭代并接受访问者
            while (iterator.hasNext()) {
                VisualizerElement visualizerElement = iterator.next();
                visualizerElement.accept(visitor, jsonNode);
            }
        } catch (IOException e) {
            System.err.println("Failed to read JSON file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
