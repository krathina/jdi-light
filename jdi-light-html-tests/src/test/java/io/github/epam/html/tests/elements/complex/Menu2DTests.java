package io.github.epam.html.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.contactFormPage;
import static io.github.com.StaticSite.datesPage;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.StaticSite.leftMenu2D;
import static io.github.com.StaticSite.menu2D;
import static io.github.com.StaticSite.metalAndColorsPage;
import static io.github.com.enums.Navigation.Dates;
import static io.github.com.enums.Navigation.MetalsColors;
import static io.github.com.enums.Navigation.Service;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;

public class Menu2DTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }
    @Test
    public void selectTest() {
        leftMenu2D.select("Contact form");
        contactFormPage.checkOpened();
    }
    @Test
    public void selectEnumTest() {
        leftMenu2D.select(MetalsColors);
        metalAndColorsPage.checkOpened();
    }
    @Test
    public void selectListTest() {
        leftMenu2D.select("Service", "Dates");
        datesPage.checkOpened();
    }
    @Test
    public void selectEnumListTest() {
        leftMenu2D.select(Service, Dates);
        datesPage.checkOpened();
    }
    @Test
    public void selectIndexTest() {
        menu2D.select(4);
        metalAndColorsPage.checkOpened();
    }
    @Test
    public void selectIndexListTest() {
        menu2D.select(3, 2);
        datesPage.checkOpened();
    }
}