package com.SoftwareEngineering.icon;

public class DefaultIconFactory implements IconFactory{
    @Override
    public String getBranchIcon() {
        return "├─  ";
    }

    @Override
    public String getTailIcon() {
        return "└─  ";
    }

    @Override
    public String getPipeIcon() {
        return "│    ";
    }
}
