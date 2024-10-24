package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceManager {
    public static final IOHandler IO_HANDLER = new IOHandler();

    public List<String> getRacerList() {
        return IO_HANDLER.setRacerList();
    }

    public void startRace(List<RacingCar> racingCars) {
        int cycle = IO_HANDLER.setRaceCycle();
        for (RacingCar racingCar : racingCars) {
            racingCar.run(cycle);
            IO_HANDLER.printRaceState(racingCar);
        }
        String winner = getWinner(racingCars);
        IO_HANDLER.printWinner(winner);
    }

    private static String getWinner(List<RacingCar> racingCars) {
        int maxScore = 0;
        List<String> winners = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            int score = racingCar.getStatus();
            if (score > maxScore) {
                maxScore = score;
                winners.clear();
                winners.add(racingCar.getName());
            } else if (score == maxScore) {
                winners.add(racingCar.getName());
            }
        }
        return String.join(",", winners);
    }
}