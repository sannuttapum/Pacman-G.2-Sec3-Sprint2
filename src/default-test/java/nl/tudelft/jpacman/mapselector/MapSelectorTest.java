package nl.tudelft.jpacman.mapselector;

import nl.tudelft.jpacman.ui.MapSelector;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MapSelectorTest {
    MapSelector mapSelector = new MapSelector();

    @Test
    public void TestMapSelectorPage() {
        assertNotNull(mapSelector);
        assertEquals("JPacman", mapSelector.getTitle());
        assertEquals(600, mapSelector.getWidth());
        assertEquals(800, mapSelector.getHeight());
        assertTrue(mapSelector.isResizable());
        assertFalse(mapSelector.isUndecorated());
    }


}
