package nl.tudelft.jpacman.game;

import java.util.List;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Level.LevelObserver;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.ui.*;

import static nl.tudelft.jpacman.Launcher.pacManUI;

/**
 * A basic implementation of a Pac-Man game.
 *
 * @author Jeroen Roosen 
 */
public abstract class Game implements LevelObserver {


    /**
     * <code>true</code> if the game is in progress.
     */
    private boolean inProgress;

    /**
     * Object that locks the start and stop methods.
     */

    private final Object progressLock = new Object();

    /**
     * The algorithm used to calculate the points that
     * they player gets whenever some action happens.
     */
    private PointCalculator pointCalculator;

    /**
     * Creates a new game.
     *
     * @param pointCalculator
     *             The way to calculate points upon collisions.
     */


    protected Game(PointCalculator pointCalculator) {
        this.pointCalculator = pointCalculator;
        inProgress = false;
    }

    /**
     * Starts or resumes the game.
     */
    public void start() {
        synchronized (progressLock) {
            if (isInProgress()) {
                return;
            }
            if (getLevel().isAnyPlayerAlive() && getLevel().remainingPellets() > 0) {
                inProgress = true;
                getLevel().addObserver(this);
                getLevel().start();
            }
        }
    }

    /**
     * Pauses the game.
     */
    public void stop() {
        synchronized (progressLock) {
            if (!isInProgress()) {
                return;
            }
            inProgress = false;
            getLevel().stop();
        }
    }

    public void restart() {
        if (pacManUI != null) {
            Launcher.setVisible(false);
        }
        Launcher.dispose();
        Launcher.setVisible(false);

        /**Restart Map Basic**/
        if (Launcher.getMap() == 0) {
            if (Launcher.getTheme() == 1){
                new Launcher().launch_theme1();
            } else if (Launcher.getTheme() == 2) {
                new Launcher().launch_theme2();
            }else if (Launcher.getTheme() == 3) {
                new Launcher().launch_theme3();
            }else if (Launcher.getTheme() == 4) {
                new Launcher().launch_theme4();
            }else if (Launcher.getTheme() == 5) {
                new Launcher().launch_theme5();
            }
            new MapSelector().setVisible(true);
        }


        /**Restart Map 1**/
        if (Launcher.getMap() == 1) {
            if (Launcher.getTheme() == 1){
                new Launcher().launch_theme1();
            } else if (Launcher.getTheme() == 2) {
                new Launcher().launch_theme2();
            }else if (Launcher.getTheme() == 3) {
                new Launcher().launch_theme3();
            }else if (Launcher.getTheme() == 4) {
                new Launcher().launch_theme4();
            }else if (Launcher.getTheme() == 5) {
                new Launcher().launch_theme5();
            }

            new MapSelector().setVisible(true);
        }

        /**Restart Map 2**/
        if (Launcher.getMap() == 2) {
            if (Launcher.getTheme() == 1){
                new Launcher().launch_theme1();
            } else if (Launcher.getTheme() == 2) {
                new Launcher().launch_theme2();
            }else if (Launcher.getTheme() == 3) {
                new Launcher().launch_theme3();
            }else if (Launcher.getTheme() == 4) {
                new Launcher().launch_theme4();
            }else if (Launcher.getTheme() == 5) {
                new Launcher().launch_theme5();
            }


            new MapSelector().setVisible(true);
        }

        /**Restart Map 3**/
        if (Launcher.getMap() == 3) {
            if (Launcher.getTheme() == 1){
                new Launcher().launch_theme1();
            } else if (Launcher.getTheme() == 2) {
                new Launcher().launch_theme2();
            }else if (Launcher.getTheme() == 3) {
                new Launcher().launch_theme3();
            }else if (Launcher.getTheme() == 4) {
                new Launcher().launch_theme4();
            }else if (Launcher.getTheme() == 5) {
                new Launcher().launch_theme5();
            }

            new MapSelector().setVisible(true);
        }

        /**Restart Map 4**/
        if (Launcher.getMap() == 4) {
            if (Launcher.getTheme() == 1){
                new Launcher().launch_theme1();
            } else if (Launcher.getTheme() == 2) {
                new Launcher().launch_theme2();
            }else if (Launcher.getTheme() == 3) {
                new Launcher().launch_theme3();
            }else if (Launcher.getTheme() == 4) {
                new Launcher().launch_theme4();
            }else if (Launcher.getTheme() == 5) {
                new Launcher().launch_theme5();
            }

            new MapSelector().setVisible(true);
        }
        /**Restart Map 5**/
        if (Launcher.getMap() == 5) {
            if (Launcher.getTheme() == 1){
                new Launcher().launch_theme1();
            } else if (Launcher.getTheme() == 2) {
                new Launcher().launch_theme2();
            }else if (Launcher.getTheme() == 3) {
                new Launcher().launch_theme3();
            }else if (Launcher.getTheme() == 4) {
                new Launcher().launch_theme4();
            }else if (Launcher.getTheme() == 5) {
                new Launcher().launch_theme5();
            }

            new MapSelector().setVisible(true);
        }
    }

    public void home() {
       {
           Launcher.dispose();
           new HomePage().setVisible(true);
        }
    }
    public void exit() {
        synchronized (progressLock) {

            System.exit(0);
        }
    }

    /**
     * @return <code>true</code> iff the game is started and in progress.
     */
    public boolean isInProgress() {
        return inProgress;
    }

    /**
     * @return An immutable list of the participants of this game.
     */
    public abstract List<Player> getPlayers();

    /**
     * @return The level currently being played.
     */
    public abstract Level getLevel();

    /**
     * Moves the specified player one square in the given direction.a
     *
     * @param player
     *            The player to move.
     * @param direction
     *            The direction to move in.
     */
    public void move(Player player, Direction direction) {
        if (isInProgress()) {
            // execute player move.
            getLevel().move(player, direction);
            pointCalculator.pacmanMoved(player, direction);
        }
    }


    @Override
    public void levelWon() {
        stop();
        Launcher.dispose();
        new GameWin();
    }

    @Override
    public void levelLost() {
        stop();
        Launcher.dispose();
        new GameOver();
    }
}
