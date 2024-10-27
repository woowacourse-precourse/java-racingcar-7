package racingcar;

import java.util.List;

public class Game {
    private final UserInteractionManager userInteractionManager;
    private final InputParser inputParser;
    private final Race race;
    private final Winner winner;
    private int attempts = 0;

    public Game(ApplicationContext applicationContext) {
        this.userInteractionManager = applicationContext.getView();
        this.inputParser = applicationContext.getInputParser();
        this.race = applicationContext.getRace();
        this.winner = applicationContext.getWinner();
    }

    public void run() {
        start();
        play();
        end();
    }

    private void start() {
        String[] carNames = getCarNames();
        attempts = getAttempts();
        race.register(carNames);
    }

    private void play() {
        userInteractionManager.printResultHeader();
        for (int i = 0; i < attempts; i++) {
            playSingleRound();
        }
    }

    private void end() {
        List<String> winners = winner.getBy(race.getResult());
        userInteractionManager.printFinalResult(winners);
    }

    private String[] getCarNames() {
        userInteractionManager.printCarNamePrompt();
        String input = userInteractionManager.readInput();
        return inputParser.executeCarNames(input);
    }

    private int getAttempts() {
        userInteractionManager.printAttemptsPrompt();
        String input = userInteractionManager.readInput();
        return inputParser.executeAttempts(input);
    }

    private void playSingleRound() {
        race.moveCarsIfQualified();
        userInteractionManager.print(race.getResult());
        userInteractionManager.printNewLine();
    }
}
