package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        List<String> racingCarNames = userInput.readCarNames();
        int raceCount = userInput.readRaceCount();

        RaceOutput raceOutput = new RaceOutput();
        RaceManager raceManager = new RaceManager(racingCarNames, raceOutput);

        raceManager.startRace(raceCount);
    }
}
