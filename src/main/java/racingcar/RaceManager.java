package racingcar;

import racingcar.policy.MovementPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceManager {

    private final List<RacingCar> racerList = new ArrayList<>();
    private final MovementPolicy randomNumGenerator;

    public RaceManager(List<String> carNames, MovementPolicy randomNumGenerator) {
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
        int bestScore = getBestScore(racerList);

        List<String> winners = racerList.stream()
                .filter(racer -> racer.getStatus() == bestScore)
                .map(RacingCar::getName)
                .collect(Collectors.toList());

        return String.join(",", winners);
    }

    private static int getBestScore(List<RacingCar> racerList) {
        return racerList.stream()
                .mapToInt(RacingCar::getStatus)
                .max()
                .getAsInt();
    }
}