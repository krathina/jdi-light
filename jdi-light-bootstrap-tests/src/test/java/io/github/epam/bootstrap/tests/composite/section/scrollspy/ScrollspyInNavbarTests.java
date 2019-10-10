package io.github.epam.bootstrap.tests.composite.section.scrollspy;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navbarWithDropdown;
import static io.github.com.pages.BootstrapPage.scrollspyInNavbar;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.bootstrap.tests.composite.section.navs.ClickVerification.newWindowTitleCheck;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ScrollspyInNavbarTests extends TestsInit {
    public static final String ATTR_NAME_HREF = "href";
    public static final String ATTR_NAME_ID = "id";
    public static final String ATTR_NAME_DATA_SPY = "data-spy";
    public static final String ATTR_NAME_DATA_TARGET = "data-target";
    public static final String ATTR_NAME_DATA_OFFSET = "data-offset";
    public static final String ATTR_NAME_ROLE = "role";
    public static final String CLASS_NAME_DROPDOWN_ITEM_ACTIVE = "dropdown-item active";
    public static final String CLASS_NAME_NAV_ITEM = "nav-item";
    public static final String CLASS_NAME_DROPDOWN_DIVIDER = "dropdown-divider";
    public static final String CLASS_NAME_NAVBAR_BRAND = "navbar-brand";
    public static final String CLASS_NAME_NAV_LINK_ACTIVE = "nav-link active";
    public static final String CLASS_NAME_SCROLLSPY_EXAMPLE = "scrollspy-example";
    public static final String ATTR_VALUE_SCROLL = "scroll";
    public static final String ATTR_VALUE_0 = "0";
    public static final String ATTR_VALUE_NAVBAR_EXAMPLE_2 = "#navbar-example2";
    public static final String ATTR_VALUE_SEPARATOR = "separator";

    private String itemLink = "https://jdi-testing.github.io/jdi-light/bootstrap.html#";
    private String navbarLink = "https://getbootstrap.com/docs/4.3/components/scrollspy/#example-in-navbar";
    private String navbarText = "Navbar";
    private String pageTitle = "Scrollspy · Bootstrap";

    private String paragraphFat = "fat";
    private String paragraphMdo = "mdo";
    private String dropdown = "Dropdown";

    private String paragraphOne = "one";
    private String paragraphTwo = "two";
    private String paragraphThree = "three";

    private String mainTextFat = "Ad leggings keytar, brunch id art party dolor labore. Pitchfork yr enim lo-fi before they sold out qui. Tumblr farm-to-table bicycle rights whatever. Anim keffiyeh carles cardigan. Velit seitan mcsweeney's photo booth 3 wolf moon irure. Cosby sweater lomo jean shorts, williamsburg hoodie minim qui you probably haven't heard of them et cardigan trust fund culpa biodiesel wes anderson aesthetic. Nihil tattooed accusamus, cred irony biodiesel keffiyeh artisan ullamco consequat.";
    private String mainTextMdo = "Veniam marfa mustache skateboard, adipisicing fugiat velit pitchfork beard. Freegan beard aliqua cupidatat mcsweeney's vero. Cupidatat four loko nisi, ea helvetica nulla carles. Tattooed cosby sweater food truck, mcsweeney's quis non freegan vinyl. Lo-fi wes anderson +1 sartorial. Carles non aesthetic exercitation quis gentrify. Brooklyn adipisicing craft beer vice keytar deserunt.";
    private String mainTextOne = "Occaecat commodo aliqua delectus. Fap craft beer deserunt skateboard ea. Lomo bicycle rights adipisicing banh mi, velit ea sunt next level locavore single-origin coffee in magna veniam. High life id vinyl, echo park consequat quis aliquip banh mi pitchfork. Vero VHS est adipisicing. Consectetur nisi DIY minim messenger bag. Cred ex in, sustainable delectus consectetur fanny pack iphone.";
    private String mainTextTwo = "In incididunt echo park, officia deserunt mcsweeney's proident master cleanse thundercats sapiente veniam. Excepteur VHS elit, proident shoreditch +1 biodiesel laborum craft beer. Single-origin coffee wayfarers irure four loko, cupidatat terry richardson master cleanse. Assumenda you probably haven't heard of them art party fanny pack, tattooed nulla cardigan tempor ad. Proident wolf nesciunt sartorial keffiyeh eu banh mi sustainable. Elit wolf voluptate, lo-fi ea portland before they sold out four loko. Locavore enim nostrud mlkshk brooklyn nesciunt.";
    private String mainTextThree = "Ad leggings keytar, brunch id art party dolor labore. Pitchfork yr enim lo-fi before they sold out qui. Tumblr farm-to-table bicycle rights whatever. Anim keffiyeh carles cardigan. Velit seitan mcsweeney's photo booth 3 wolf moon irure. Cosby sweater lomo jean shorts, williamsburg hoodie minim qui you probably haven't heard of them et cardigan trust fund culpa biodiesel wes anderson aesthetic. Nihil tattooed accusamus, cred irony biodiesel keffiyeh artisan ullamco consequat. Keytar twee blog, culpa messenger bag marfa whatever delectus food truck. Sapiente synth id assumenda. Locavore sed helvetica cliche irony, thundercats you probably haven't heard of them consequat hoodie gluten-free lo-fi fap aliquip. Labore elit placeat before they sold out, terry richardson proident brunch nesciunt quis cosby sweater pariatur keffiyeh ut helvetica artisan. Cardigan craft beer seitan readymade velit. VHS chambray laboris tempor veniam. Anim mollit minim commodo ullamco thundercats.";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        refresh();
    }

    @DataProvider
    public Object[][] navMenu() {
        return new Object[][]{
                {1, itemLink + paragraphFat, "@" + paragraphFat, paragraphFat, mainTextFat},
                {2, itemLink + paragraphMdo, "@" + paragraphMdo, paragraphMdo, mainTextMdo},
                {3, itemLink + paragraphOne, paragraphOne, paragraphOne, mainTextOne},
                {4, itemLink + paragraphTwo, paragraphTwo, paragraphTwo, mainTextTwo},
                {5, itemLink + paragraphThree, paragraphThree, paragraphThree, mainTextThree}
        };
    }

    @DataProvider
    public Object[][] itemsCheck() {
        return new Object[][]{
                {1, paragraphFat}, {2, paragraphMdo}, {3, paragraphOne}, {4, paragraphTwo}, {5, paragraphThree}
        };
    }

    @Test(dataProvider = "navMenu", priority = 1)
    public void mainContentTests(int index, String link, String header, String paragraph, String mainText) {
        if (index < 3) {
            navbarWithDropdown.navItemLink.get(index).is()
                    .core()
                    .displayed()
                    .enabled()
                    .text(is(header))
                    .value(is(header))
                    .attr(ATTR_NAME_HREF, is(link));
        } else {
            navbarWithDropdown.dropdownMenu.expand();
            navbarWithDropdown.dropdownMenu.list().get(header).is()
                    .core()
                    .displayed()
                    .enabled()
                    .text(is(header))
                    .value(is(header))
                    .attr(ATTR_NAME_HREF, is(link));
        }
        scrollspyInNavbar.header.get(index).is()
                .core()
                .displayed()
                .enabled()
                .text(is(header.toUpperCase()))
                .value(is(header.toUpperCase()))
                .attr(ATTR_NAME_ID, is(paragraph));

        scrollspyInNavbar.mainText.get(index).is()
                .core()
                .displayed()
                .enabled()
                .text(is(mainText))
                .value(is(mainText));
    }

    @Test
    public void isValidationTests() {
        navbarWithDropdown.navItemLink.get(3).is().text(dropdown);
        navbarWithDropdown.navItemLink.get(3).is().value(dropdown);
        navbarWithDropdown.navItemLink.is().size(3);
        navbarWithDropdown.navGroup.is().size(3);

        navbarWithDropdown.dropdownMenu.expand();
        navbarWithDropdown.dropdownMenu.is().size(3);

        navbarWithDropdown.find(By.className(CLASS_NAME_DROPDOWN_DIVIDER)).is()
                .core()
                .displayed()
                .enabled()
                .attr(ATTR_NAME_ROLE, ATTR_VALUE_SEPARATOR);

        scrollspyInNavbar.mainText.is().size(5);
        scrollspyInNavbar.header.is().size(5);

        navbarWithDropdown.navbarLink.is()
                .core()
                .displayed()
                .enabled()
                .attr(ATTR_NAME_HREF, is(navbarLink))
                .value(is(navbarText))
                .text(is(navbarText))
                .cssClass(CLASS_NAME_NAVBAR_BRAND);

        for (UIElement element : navbarWithDropdown.navGroup.list()) {
            element.is()
                    .core()
                    .displayed()
                    .enabled()
                    .hasClass(CLASS_NAME_NAV_ITEM);
        }

        scrollspyInNavbar.is()
                .core()
                .displayed()
                .enabled()
                .attr(ATTR_NAME_DATA_SPY, is(ATTR_VALUE_SCROLL))
                .attr(ATTR_NAME_DATA_TARGET, is(ATTR_VALUE_NAVBAR_EXAMPLE_2))
                .attr(ATTR_NAME_DATA_OFFSET, is(ATTR_VALUE_0))
                .cssClass(CLASS_NAME_SCROLLSPY_EXAMPLE);
    }

    @Test(dataProvider = "itemsCheck")
    public void linkClickableFocusTests(int index, String header) {
        navbarWithDropdown.navItemLink.get(1).click();
        navbarWithDropdown.dropdownMenu.expand();

        int y_header_start = scrollspyInNavbar.header.get(1).core().getRect().y;
        if (index < 3)
            navbarWithDropdown.navItemLink.get(index).click();
        else
            navbarWithDropdown.dropdownMenu.list().get(header).click();

        int y_header_current = scrollspyInNavbar.header.get(index).core().getRect().y;
        assertThat(y_header_start, is(y_header_current));
    }

    @Test(dataProvider = "itemsCheck")
    public void paragraphScrollableTests(int index, String header) {
        navbarWithDropdown.dropdownMenu.expand();
        scrollspyInNavbar.mainText.get(index).highlight();
        scrollspyInNavbar.mainText.get(index).show();

        if (index < 3)
            navbarWithDropdown.navItemLink.get(index).is()
                    .core()
                    .displayed()
                    .enabled()
                    .cssClass(CLASS_NAME_NAV_LINK_ACTIVE);
        else
            navbarWithDropdown.dropdownMenu.list().get(header).is()
                    .core()
                    .displayed()
                    .enabled()
                    .cssClass(CLASS_NAME_DROPDOWN_ITEM_ACTIVE);

        scrollspyInNavbar.mainText.get(index).unhighlight();
    }

    @Test
    public void navbarLinkClickableTests() {
        navbarWithDropdown.navbarLink.click();
        newWindowTitleCheck(pageTitle);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(scrollspyInNavbar);
        baseValidation(navbarWithDropdown);
    }
}
