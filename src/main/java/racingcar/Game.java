package racingcar;

import java.util.List;
import java.util.Map;

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
        int count = start();
        play(count);
        end();
    }

    private int start() {
        String[] carNames = getCarNames();
        int count = getCount();
        gameLogic.initialize(carNames);
        return count;
    }

    private void play(int count) {
        view.printResultPrompt();
        for (int i = 0; i < count; i++) {
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

    private int getCount() {
        view.printCountPrompt();
        String input = view.readInput();
        return inputParser.executeAttempts(input);
    }

    private void playSingleRound() {
        Map<String, StringBuilder> roundResult = gameLogic.moveCarsIfQualified();
        view.printStatus(roundResult);
        System.out.println();
    }
}
