package nl.tudelft.jpacman;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.game.GameFactory;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.points.PointCalculatorLoader;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.ui.*;
import nl.tudelft.jpacman.ui.MapSelector;

import static nl.tudelft.jpacman.ui.ThemeSelector.setTheme_;

/**
 * Creates and launches the JPacMan UI.
 * 
 * @author Jeroen Roosen
 */
@SuppressWarnings("PMD.TooManyMethods")
public class Launcher {


    private static final PacManSprites SPRITE_STORE = new PacManSprites();

    public static final String DEFAULT_MAP = "/board.txt";
    private String levelMap = DEFAULT_MAP;

    public static PacManUI pacManUI;
    private Game game;
    private PacManUI pacManThem1;
    private PacManUI pacManThem2;
    private PacManUI pacManThem3;

    public static void setVisible(boolean b) {

    }


    public static int getTheme(){
        return theme;
    }
    private static int theme;

    public static int getMap(){
        return map;
    }
    private static int map;

    /**
     * @return The game object this launcher will start when {@link #launch()}
     *         is called.
     */
    public Game getGame() {
        return game;
    }

    /**
     * The map file used to populate the level.
     *
     * @return The name of the map file.
     */
    protected String getLevelMap() {
        return levelMap;
    }

    /**
     * Set the name of the file containing this level's map.
     *
     * @param fileName
     *            Map to be used.
     * @return Level corresponding to the given map.
     */
    public Launcher withMapFile(String fileName) {
        levelMap = fileName;
        return this;
    }

    /**
     * Creates a new game using the level from {@link #makeLevel()}.
     *
     * @return a new Game.
     */
    public Game makeGame() {
        GameFactory gf = getGameFactory();
        Level level = makeLevel();
        game = gf.createSinglePlayerGame(level, loadPointCalculator());
        return game;
    }

    private PointCalculator loadPointCalculator() {
        return new PointCalculatorLoader().load();
    }

    /**
     * Creates a new level. By default this method will use the map parser to
     * parse the default board stored in the <code>board.txt</code> resource.
     *
     * @return A new level.
     */
    public Level makeLevel() {
        try {
            return getMapParser().parseMap(getLevelMap());
        } catch (IOException e) {
            throw new PacmanConfigurationException(
                    "Unable to create level, name = " + getLevelMap(), e);
        }
    }

    /**
     * @return A new map parser object using the factories from
     *         {@link #getLevelFactory()} and {@link #getBoardFactory()}.
     */
    protected MapParser getMapParser() {
        return new MapParser(getLevelFactory(), getBoardFactory());
    }

    /**
     * @return A new board factory using the sprite store from
     *         {@link #getSpriteStore()}.
     */
    protected BoardFactory getBoardFactory() {
        return new BoardFactory(getSpriteStore());
    }

    /**
     * @return The default {@link PacManSprites}.
     */
    protected PacManSprites getSpriteStore() {
        return SPRITE_STORE;
    }

    /**
     * @return A new factory using the sprites from {@link #getSpriteStore()}
     *         and the ghosts from {@link #getGhostFactory()}.
     */
    protected LevelFactory getLevelFactory() {
        return new LevelFactory(getSpriteStore(), getGhostFactory(), loadPointCalculator());
    }

    /**
     * @return A new factory using the sprites from {@link #getSpriteStore()}.
     */
    protected GhostFactory getGhostFactory() {
        return new GhostFactory(getSpriteStore());
    }

    /**
     * @return A new factory using the players from {@link #getPlayerFactory()}.
     */
    protected GameFactory getGameFactory() {
        return new GameFactory(getPlayerFactory());
    }

    /**
     * @return A new factory using the sprites from {@link #getSpriteStore()}.
     */
    protected PlayerFactory getPlayerFactory() {
        return new PlayerFactory(getSpriteStore());
    }

    /**
     * Adds key events UP, DOWN, LEFT and RIGHT to a game.
     *
     * @param builder
     *            The {@link PacManUiBuilder} that will provide the UI.
     */
    protected void addSinglePlayerKeys(final PacManUiBuilder builder) {
        builder.addKey(KeyEvent.VK_UP, moveTowardsDirection(Direction.NORTH))
                .addKey(KeyEvent.VK_DOWN, moveTowardsDirection(Direction.SOUTH))
                .addKey(KeyEvent.VK_LEFT, moveTowardsDirection(Direction.WEST))
                .addKey(KeyEvent.VK_RIGHT, moveTowardsDirection(Direction.EAST))
                .addKey(KeyEvent.VK_W, moveTowardsDirection(Direction.NORTH))
                .addKey(KeyEvent.VK_S, moveTowardsDirection(Direction.SOUTH))
                .addKey(KeyEvent.VK_A, moveTowardsDirection(Direction.WEST))
                .addKey(KeyEvent.VK_D, moveTowardsDirection(Direction.EAST));

    }

    private Action moveTowardsDirection(Direction direction) {
        return () -> {
            assert game != null;
            getGame().move(getSinglePlayer(getGame()), direction);
        };
    }

    private Player getSinglePlayer(final Game game) {
        List<Player> players = game.getPlayers();
        if (players.isEmpty()) {
            throw new IllegalArgumentException("Game has 0 players.");
        }
        return players.get(0);
    }

    /**
     * Creates and starts a JPac-Man game.
     */


    /**
     * Disposes of the UI. For more information see
     * {@link javax.swing.JFrame#dispose()}.
     *
     * Precondition: The game was launched first.
     */
    public static void dispose() {
        assert pacManUI != null;
        pacManUI.dispose();
    }

    /**
     * Main execution method for the Launcher.
     *
     * @param args
     *            The command line arguments - which are ignored.
     * @throws IOException
     *             When a resource could not be read.
     */
    public static void main(String[] args) throws IOException {
        new HomePage();
    }

    private Game makeGame_t() {
        GameFactory gf = getGameFactory();
        Level level = makeLevel_1();
        game = gf.createSinglePlayerGame(level, loadPointCalculator());
        return game;
    }


    private Level makeLevel_0() {
        try {
            return getMapParser().parseMap("/board.txt");
        } catch (IOException e) {
            throw new PacmanConfigurationException(
                "Unable to create level, name = " + "/board.txt", e);
        }
    }
    private Level makeLevel_1() {
        try {
            return getMapParser().parseMap("/board1.txt");
        } catch (IOException e) {
            throw new PacmanConfigurationException(
                "Unable to create level, name = " + "/board1.txt", e);
        }
    }
    private Level makeLevel_2() {
        try {
            return getMapParser().parseMap("/board2.txt");
        } catch (IOException e) {
            throw new PacmanConfigurationException(
                "Unable to create level, name = " + "/board2.txt", e);
        }
    }
    private Level makeLevel_3() {
        try {
            return getMapParser().parseMap("/board3.txt");
        } catch (IOException e) {
            throw new PacmanConfigurationException(
                "Unable to create level, name = " + "/board3.txt", e);
        }
    }
    private Level makeLevel_4() {
        try {
            return getMapParser().parseMap("/board4.txt");
        } catch (IOException e) {
            throw new PacmanConfigurationException(
                "Unable to create level, name = " + "/board4.txt", e);
        }
    }
    private Level makeLevel_5() {
        try {
            return getMapParser().parseMap("/board5.txt");
        } catch (IOException e) {
            throw new PacmanConfigurationException(
                "Unable to create level, name = " + "/board5.txt", e);
        }
    }

    private Game makeTheme_1() {
        GameFactory gf = getGameFactory();
        Level level = makeLevel_1();
        game = gf.createSinglePlayerGame(level, loadPointCalculator());
        return game;
    }
    private Game makeTheme_2() {
        GameFactory gf = getGameFactory();
        Level level = makeLevel_2();
        game = gf.createSinglePlayerGame(level, loadPointCalculator());
        return game;
    }
    private Game makeTheme_3() {
        GameFactory gf = getGameFactory();
        Level level = makeLevel_3();
        game = gf.createSinglePlayerGame(level, loadPointCalculator());
        return game;
    }
    private Game makeTheme_4() {
        GameFactory gf = getGameFactory();
        Level level = makeLevel_4();
        game = gf.createSinglePlayerGame(level, loadPointCalculator());
        return game;
    }
    private Game makeTheme_5() {
        GameFactory gf = getGameFactory();
        Level level = makeLevel_5();
        game = gf.createSinglePlayerGame(level, loadPointCalculator());
        return game;
    }
    private Game makeTheme_6() {
        GameFactory gf = getGameFactory();
        Level level = makeLevel_5();
        game = gf.createSinglePlayerGame(level, loadPointCalculator());
        return game;
    }

    /**Make Map**/
    private Game makeMap_0() {
        GameFactory gf = getGameFactory();
        Level level = makeLevel_0();
        game = gf.createSinglePlayerGame(level, loadPointCalculator());
        return game;
    }
    private Game makeMap_1() {
        GameFactory gf = getGameFactory();
        Level level = makeLevel_1();
        game = gf.createSinglePlayerGame(level, loadPointCalculator());
        return game;
    }

    private Game makeMap_2() {
        GameFactory gf = getGameFactory();
        Level level = makeLevel_2();
        game = gf.createSinglePlayerGame(level, loadPointCalculator());
        return game;
    }

    private Game makeMap_3() {
        GameFactory gf = getGameFactory();
        Level level = makeLevel_3();
        game = gf.createSinglePlayerGame(level, loadPointCalculator());
        return game;
    }

    private Game makeMap_4() {
        GameFactory gf = getGameFactory();
        Level level = makeLevel_4();
        game = gf.createSinglePlayerGame(level, loadPointCalculator());
        return game;
    }

    private Game makeMap_5() {
        GameFactory gf = getGameFactory();
        Level level = makeLevel_5();
        game = gf.createSinglePlayerGame(level, loadPointCalculator());
        return game;
    }

    public void launch() {
        makeGame();
        PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
        addSinglePlayerKeys(builder);
        pacManUI = builder.build(getGame(),0);
        pacManUI.start();
    }

    public void launch_theme1() {
        makeTheme_1();
        PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
        addSinglePlayerKeys(builder);
        pacManUI = builder.build(getGame(), 1);
        setTheme_(1);
        pacManUI.start();
    }

    public void launch_theme2() {
        makeTheme_2();
        PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
        addSinglePlayerKeys(builder);
        pacManUI = builder.build(getGame(), 2);
        setTheme_(2);
        pacManUI.start();
    }

    public void launch_theme3() {
        makeTheme_3();
        PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
        addSinglePlayerKeys(builder);
        pacManUI = builder.build(getGame(), 3);
        setTheme_(3);
        pacManUI.start();
    }

    public void launch_theme4() {
        makeTheme_4();
        PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
        addSinglePlayerKeys(builder);
        pacManUI = builder.build(getGame(), 4);
        setTheme_(4);
        pacManUI.start();
    }

    public void launch_theme5() {
        makeTheme_5();
        PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
        addSinglePlayerKeys(builder);
        pacManUI = builder.build(getGame(), 5);
        setTheme_(5);
        pacManUI.start();
    }

    /**Launch Map**/

    public void launch_map0(){
        makeMap_0();
        PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
        addSinglePlayerKeys(builder);
        pacManUI = builder.build(getGame(), 0);
        pacManUI.start();
    }

    public void launch_map1(){
        makeMap_1();
        PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
        addSinglePlayerKeys(builder);
        pacManUI = builder.build(getGame(), 1);
        pacManUI.start();
    }

    public void launch_map2(){
        makeMap_2();
        PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
        addSinglePlayerKeys(builder);
        pacManUI = builder.build(getGame(), 2);
        pacManUI.start();
    }

    public void launch_map3(){
        makeMap_3();
        PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
        addSinglePlayerKeys(builder);
        pacManUI = builder.build(getGame(), 3);
        pacManUI.start();
    }

    public void launch_map4(){
        makeMap_4();
        PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
        addSinglePlayerKeys(builder);
        pacManUI = builder.build(getGame(), 4);
        pacManUI.start();
    }

    public void launch_map5(){
        makeMap_5();
        PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
        addSinglePlayerKeys(builder);
        pacManUI = builder.build(getGame(), 5);
        pacManUI.start();
    }
}
