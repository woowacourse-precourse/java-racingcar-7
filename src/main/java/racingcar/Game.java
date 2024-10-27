package racingcar;

import java.util.List;

public class Game {
    private final View view;
    private final InputParser inputParser;
    private final Race race;
    private final Winner winner;

    public Game(ApplicationContext applicationContext) {
        this.view = applicationContext.getView();
        this.inputParser = applicationContext.getInputParser();
        this.race = applicationContext.getRace();
        this.winner = applicationContext.getWinner();
    }

    public void run() {
        String[] carNames = getCarNames();
        int attempts = getAttempts();
        race.initialize(carNames);

        view.printResultHeader();
        for (int i = 0; i < attempts; i++) {
            playSingleRound();
        }
        List<String> winners = winner.getBy(race.getResult());
        view.print(winners);
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
