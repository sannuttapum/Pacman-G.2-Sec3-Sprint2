package nl.tudelft.jpacman.sprite;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import nl.tudelft.jpacman.PacmanConfigurationException;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.npc.ghost.GhostColor;
import nl.tudelft.jpacman.ui.ThemeSelector;
/**
 * Sprite Store containing the classic Pac-Man sprites.
 *
 * @author Jeroen Roosen 
 */
public class PacManSprites extends SpriteStore {


    ThemeSelector themeSelector;

    /**
     * The sprite files are vertically stacked series for each direction, this
     * array denotes the order.
     */
    private static final Direction[] DIRECTIONS = {
        Direction.NORTH,
        Direction.EAST,
        Direction.SOUTH,
        Direction.WEST
    };

    /**
     * The image size in pixels.
     */
    private static final int SPRITE_SIZE = 16;

    /**
     * The amount of frames in the pacman animation.
     */
    private static final int PACMAN_ANIMATION_FRAMES = 4;

    /**
     * The amount of frames in the pacman dying animation.
     */
    private static final int PACMAN_DEATH_FRAMES = 11;

    /**
     * The amount of frames in the ghost animation.
     */
    private static final int GHOST_ANIMATION_FRAMES = 2;

    /**
     * The delay between frames.
     */
    private static final int ANIMATION_DELAY = 200;

    /**
     * @return A map of animated Pac-Man sprites for all directions.
     */
    public Map<Direction, Sprite> getPacmanSprites() {
        if(themeSelector.getTheme_() == 1){
            return directionSprite("/theme1/pacman.png", PACMAN_ANIMATION_FRAMES);
        }
        if(themeSelector.getTheme_() == 2){
            return directionSprite("/theme2/pacman.png", PACMAN_ANIMATION_FRAMES);
        }
        if(themeSelector.getTheme_() == 3){
            return directionSprite("/theme3/pacman.png", PACMAN_ANIMATION_FRAMES);
        }
        if(themeSelector.getTheme_() == 4){
            return directionSprite("/theme4/pacman.png", PACMAN_ANIMATION_FRAMES);
        }
        if(themeSelector.getTheme_() == 5){
            return directionSprite("/theme5/pacman.png", PACMAN_ANIMATION_FRAMES);
        }
        else {
            return directionSprite("/sprite/pacman.png", PACMAN_ANIMATION_FRAMES);
        }

    }

    /**
     * @return The animation of a dying Pac-Man.
     */
    public AnimatedSprite getPacManDeathAnimation() {
        String resource = "/theme1/dead.png";

        Sprite baseImage = loadSprite(resource);
        AnimatedSprite animation = createAnimatedSprite(baseImage, PACMAN_DEATH_FRAMES,
            ANIMATION_DELAY, false);
        animation.setAnimating(false);

        return animation;
    }

    /**
     * Returns a new map with animations for all directions.
     *
     * @param resource
     *            The resource name of the sprite.
     * @param frames
     *            The number of frames in this sprite.
     * @return The animated sprite facing the given direction.
     */
    private Map<Direction, Sprite> directionSprite(String resource, int frames) {
        Map<Direction, Sprite> sprite = new HashMap<>();

        Sprite baseImage = loadSprite(resource);
        for (int i = 0; i < DIRECTIONS.length; i++) {
            Sprite directionSprite = baseImage.split(0, i * SPRITE_SIZE, frames
                * SPRITE_SIZE, SPRITE_SIZE);
            AnimatedSprite animation = createAnimatedSprite(directionSprite,
                frames, ANIMATION_DELAY, true);
            animation.setAnimating(true);
            sprite.put(DIRECTIONS[i], animation);
        }

        return sprite;
    }

    /**
     * Returns a map of animated ghost sprites for all directions.
     *
     * @param color
     *            The colour of the ghost.
     * @return The Sprite for the ghost.
     */
    public Map<Direction, Sprite> getGhostSprite(GhostColor color) {
        assert color != null;

        if (themeSelector.getTheme_() == 1) {
            String resource = "/theme1/ghost_" + color.name().toLowerCase()
                + ".png";
            return directionSprite(resource, GHOST_ANIMATION_FRAMES);
        }

        if (themeSelector.getTheme_() == 2) {
            String resource = "/theme2/ghost_" + color.name().toLowerCase()
                + ".png";
            return directionSprite(resource, GHOST_ANIMATION_FRAMES);
        }

        if (themeSelector.getTheme_() == 3) {
            String resource = "/theme3/ghost_" + color.name().toLowerCase()
                + ".png";
            return directionSprite(resource, GHOST_ANIMATION_FRAMES);
        }

        if (themeSelector.getTheme_() == 4) {
            String resource = "/theme4/ghost_" + color.name().toLowerCase()
                + ".png";
            return directionSprite(resource, GHOST_ANIMATION_FRAMES);
        }

        if (themeSelector.getTheme_() == 5) {
            String resource = "/theme5/ghost_" + color.name().toLowerCase()
                + ".png";
            return directionSprite(resource, GHOST_ANIMATION_FRAMES);
        }

        else {
            String resource = "/sprite/ghost_" + color.name().toLowerCase()
                + ".png";
            return directionSprite(resource, GHOST_ANIMATION_FRAMES);
        }
    }

    /**
     * @return The sprite for the wall.
     */
    public Sprite getWallSprite() {

        if (themeSelector.getTheme_() == 1) {
            return loadSprite("/theme1/wall.png");
        }

        if (themeSelector.getTheme_() == 2) {
            return loadSprite("/theme2/wall.png");
        }

        if (themeSelector.getTheme_() == 3) {
            return loadSprite("/theme3/wall.png");
        }

        if (themeSelector.getTheme_() == 4) {
            return loadSprite("/theme4/wall.png");
        }

        if (themeSelector.getTheme_() == 5) {
            return loadSprite("/theme5/wall.png");
        }
        else {
            return loadSprite("/sprite/wall.png");
        }
    }

    /**
     * @return The sprite for the ground.
     */
    public Sprite getGroundSprite() {
        if (themeSelector.getTheme_() == 1) {
            return loadSprite("/theme1/floor.png");
        }
        if (themeSelector.getTheme_() == 2) {
            return loadSprite("/theme2/floor.png");
        }
        if (themeSelector.getTheme_() == 3) {
            return loadSprite("/theme3/floor.png");
        }
        if (themeSelector.getTheme_() == 4) {
            return loadSprite("/theme4/floor.png");
        }
        if (themeSelector.getTheme_() == 5) {
            return loadSprite("/theme5/floor.png");
        }
        else {
            return loadSprite("/sprite/floor.png");
        }
    }

    /**
     * @return The sprite for the
     */
    public Sprite getPelletSprite() {

        if (themeSelector.getTheme_() == 1) {
            return loadSprite("/theme1/pellet.png");
        }
        if (themeSelector.getTheme_() == 2) {
            return loadSprite("/theme2/cc.png");
        }
        if (themeSelector.getTheme_() == 3) {
            return loadSprite("/theme3/pellet.png");
        }
        if (themeSelector.getTheme_() == 4) {
            return loadSprite("/theme4/pellet.png");
        }
        if (themeSelector.getTheme_() == 5) {
            return loadSprite("/theme5/pellet.png");
        }
        else {
            return loadSprite("/sprite/pellet.png");
        }
    }

    /**
     * Overloads the default sprite loading, ignoring the exception. This class
     * assumes all sprites are provided, hence the exception will be thrown as a
     * {@link RuntimeException}.
     *
     * {@inheritDoc}
     */
    @Override
    public Sprite loadSprite(String resource) {
        try {
            return super.loadSprite(resource);
        } catch (IOException e) {
            throw new PacmanConfigurationException("Unable to load sprite: " + resource, e);
        }
    }
}
