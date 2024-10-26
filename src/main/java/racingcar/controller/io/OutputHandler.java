package racingcar.controller.io;

import java.util.HashMap;
import java.util.List;

public interface OutputHandler {
    void displayResultMessage();

    void printRaceResult(HashMap<String, Integer> raceResults);

    void printRaceWinner(List<String> winnersName);
}