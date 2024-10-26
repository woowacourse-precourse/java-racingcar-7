package racingcar.controller.io;

import java.util.HashMap;
import java.util.List;
import racingcar.view.ConsoleView;

public class ConsoleOutputHandler implements OutputHandler {
    private final ConsoleView consoleView = new ConsoleView();

    @Override
    public void displayResultMessage() {
        consoleView.displayResult();
    }

    @Override
    public void printRaceResult(HashMap<String, Integer> raceResults) {
        raceResults.forEach(consoleView::printRaceDetails);
        System.out.println();
    }

    @Override
    public void printRaceWinner(List<String> winnersName) {
        consoleView.printRaceWinner(winnersName);
    }
}
