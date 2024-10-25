package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RaceManager {

    public void startRace(List<RacingCar> racingCars , int cycle) {
        IOHandler.printResult();
        for (int i = 0; i < cycle; i++) {
            updateRaceState(racingCars);
        }
        String winner = getWinner(racingCars);
        IOHandler.printWinner(winner);
    }

    private static void updateRaceState(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            racingCar.run(getRandomNum());
            IOHandler.printRaceState(racingCar);
        }
        IOHandler.printNewLine();
    }

    private static int getRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
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