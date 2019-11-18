package io.github.com.sections;

import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Image;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.composite.MediaObject;

public class MediaObjectSample extends MediaObject {

    @UI("img")
    public Image imageOfMediaObject;

    @Title
    @UI("h5")
    public Text headingOfMediaObject;

    @UI(".media-body")
    public Text bodyOfMediaObject;

}