package racingcar;

import racingcar.policy.RandomNumGenerator;
import java.util.ArrayList;
import java.util.List;

public class RaceManager {

    private final List<RacingCar> racerList = new ArrayList<>();
    private final RandomNumGenerator randomNumGenerator;
    public RaceManager(List<String> carNames, RandomNumGenerator randomNumGenerator) {
        this.randomNumGenerator = randomNumGenerator;
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
            racer.run(randomNumGenerator.moveOrStop());
            IOHandler.printRacer(racer);
        }
        IOHandler.printNewLine();
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