package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RaceManager {
    private static IOHandler IO_HANDLER;
    public RaceManager(IOHandler ioHandler) {
        IO_HANDLER = ioHandler;
    }

    public void startRace(List<RacingCar> racingCars , int cycle) {
        IO_HANDLER.printResult();
        for (int i = 0; i < cycle; i++) {
            updateRaceState(racingCars);
        }
        String winner = getWinner(racingCars);
        IO_HANDLER.printWinner(winner);
    }

    private static void updateRaceState(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            racingCar.run(getRandomNum());
            IO_HANDLER.printRaceState(racingCar);
        }
        IO_HANDLER.printNewLine();
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