package nl.tudelft.jpacman.themeselector;

import nl.tudelft.jpacman.ui.ThemeSelector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ThemeTest {
    ThemeSelector themeSelector = new ThemeSelector();

    @Test
    public  void TestThemeSelectorPage(){
        assertNotNull(themeSelector);
        assertEquals("JPacman", themeSelector.getTitle());
        assertEquals(600, themeSelector.getWidth());
        assertEquals(800, themeSelector.getHeight());
        assertTrue(themeSelector.isResizable());
        assertFalse(themeSelector.isUndecorated());
    }






}
