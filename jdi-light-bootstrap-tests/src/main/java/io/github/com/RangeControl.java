package io.github.com;

import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Range;

public class RangeControl extends Range {
    private Button increaseRange, decreaseRange;
    public void increase(int count) {
        for (int i = 0; i < count; i++)
            increaseRange.click();
    }
    public void decrease(int count) {
        for (int i = 0; i < count; i++)
            decreaseRange.click();
    }
}
