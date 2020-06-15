package io.github.epam.html.tests.issue.issue73;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class StageItem extends Section {

    private TextField stageTitle;

    public void addBefore(){
        stageTitle.hover();
    }
}