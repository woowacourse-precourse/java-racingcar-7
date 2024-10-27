package racingcar;

import java.util.List;

public class Game {
    private final View view;
    private final InputParser inputParser;
    private final GameLogic gameLogic;

    public Game(ApplicationContext applicationContext) {
        this.view = applicationContext.getView();
        this.inputParser = applicationContext.getInputParser();
        this.gameLogic = applicationContext.getGameLogic();
    }

    public void run() {
        int attempts = start();
        play(attempts);
        end();
    }

    private int start() {
        String[] carNames = getCarNames();
        int attempts = getAttempts();
        gameLogic.initialize(carNames);
        return attempts;
    }

    private void play(int attempts) {
        view.printResultHeader();
        for (int i = 0; i < attempts; i++) {
            playSingleRound();
        }
    }

    private void end() {
        List<String> winners = gameLogic.getWinners();
        view.printWinners(winners);
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
        gameLogic.moveCarsIfQualified();
        view.printStatus(gameLogic.getResult());
        System.out.println();
    }
}
