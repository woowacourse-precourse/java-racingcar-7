package controller;

import view.OutputView;
import view.InputView;
import model.RaceInput;
import model.Race;
import model.Car;

import java.util.ArrayList;

/**
 * Controller class for managing the car racing game.
 * This class coordinates between the view and model components,
 * handling the game flow from start to finish.
 */
public class RaceController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private Race race;
    private RaceInput raceInput;

    /**
     * Executes the complete flow of the racing game.
     * This includes creating the race, running it, and determining the winners.
     */
    public void run() {
        createRace();
        startRace();
        endRace();
    }

    /**
     * Creates a new race instance based on user input.
     * Collects car names from the user and initializes the race.
     */
    private void createRace() {
        raceInput = inputView.getInput();
        race = new Race(raceInput.names());
    }

    /**
     * Executes the race for the specified number of rounds.
     * In each round, cars move according to the game rules and
     * the current state is displayed.
     */
    private void startRace() {
        for (int i = 0; i < raceInput.times(); i++) {
            race.moveCars();
            outputView.printRaceInfo(race.getCars());
        }
    }

    /**
     * Concludes the race by determining and displaying the winners.
     * Multiple cars can be winners if they have moved the same distance.
     */
    private void endRace() {
        ArrayList<Car> winners = race.getWinners();
        outputView.printRaceResult(winners);
    }
}