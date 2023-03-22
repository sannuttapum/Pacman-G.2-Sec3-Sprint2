package nl.tudelft.jpacman.mainmenu;

import nl.tudelft.jpacman.ui.HomePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HomePageTest {
    HomePage mainMenu = new HomePage();

    // Check the size of the frame
    @Test
    public void testHomePage() {
        HomePage homePage = new HomePage();
        assertNotNull(homePage);
        assertEquals("JPacman", homePage.getTitle());
        assertEquals(600, homePage.getWidth());
        assertEquals(800, homePage.getHeight());
        assertTrue(homePage.isResizable());
        assertFalse(homePage.isUndecorated());
    }

    @Test
    void testStartButton() {
        assertNotNull(mainMenu.getStartButton());
    }

    @Test
    public void testOpenTheme() {
        HomePage homePage = new HomePage();
        homePage.openTheme();
        assertNotNull(homePage.getThemeSelector());
        assertTrue(homePage.getThemeSelector().isVisible());
    }

    @Test
    void testExitButton(){
        assertNotNull(mainMenu.getExitButton());
    }


}

