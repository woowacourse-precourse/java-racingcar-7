package racingcar;

import java.util.List;

public class Game {
    private final View view;
    private final InputParser inputParser;
    private final Race race;
    private final Winner winner;
    private int attempts = 0;

    public Game(ApplicationContext applicationContext) {
        this.view = applicationContext.getView();
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
        view.printResultHeader();
        for (int i = 0; i < attempts; i++) {
            playSingleRound();
        }
    }

    private void end() {
        List<String> winners = winner.getBy(race.getResult());
        view.printFinalResult(winners);
    }

    private String[] getCarNames() {
        view.printCarNamePrompt();
        String input = view.readInput();
        return inputParser.executeCarNames(input);
    }

    private int getAttempts() {
        view.printAttemptsPrompt();
        String input = view.readInput();
        return inputParser.executeAttempts(input);
    }

    private void playSingleRound() {
        race.moveCarsIfQualified();
        view.print(race.getResult());
        view.printNewLine();
    }
}
