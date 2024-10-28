package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RaceManager {

    private final List<RacingCar> racerList = new ArrayList<>();

    public RaceManager(List<String> carNames) {
        for (String carName : carNames) {
            racerList.add(CarFactory.createRacingCars(carName));
        }
    }

    public void startRace(int cycle) {
        IOHandler.printResult();
        for (int i = 0; i < cycle; i++) {
            updateRaceState(racerList);
        }
        String winner = getWinner(racerList);
        IOHandler.printRacer(winner);
    }

    private void updateRaceState(List<RacingCar> racerList) {
        for (RacingCar racer : racerList) {
            racer.run(getRandomNum());
            IOHandler.printRacer(racer);
        }
        IOHandler.printNewLine();
    }

    private int getRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private String getWinner(List<RacingCar> racerList) {
        int maxScore = 0;
        List<String> winners = new ArrayList<>();
        for (RacingCar racer : racerList) {
            int score = racer.getStatus();
            if (score > maxScore) {
                maxScore = score;
                winners.clear();
                winners.add(racer.getName());
            } else if (score == maxScore) {
                winners.add(racer.getName());
            }
        }
        return String.join(",", winners);
    }
}