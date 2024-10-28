package racingcar.model;

import racingcar.util.RandomNumberGenerator;

public class RaceRound {
    private final Race race;

    public RaceRound(Race race) {
        this.race = race;
    }

    public void playRound() {
        for (Car car : race.getCars()) {
            int randomValue = RandomNumberGenerator.generate();
            if (randomValue >= 4) {
                car.move(1);
            }
        }
    }
}
