package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private static final int MOVE_CONDITION_4 = 4;
    private final List<Car> cars;
    private final int tryNumber;
    private final RandomNumber randomNumberGenerator = new RandomNumber();
    private final Judgement judgement = new Judgement();

    public Racing(GameSet gameSet) {
        this.cars = gameSet.getCarList();
        this.tryNumber = gameSet.getTryNumber();
    }

    public void startRace() {
        for (int i = 0; i < tryNumber; i++) {
            raceOnRound();
        }
        announceWinners();
    }

    public void raceOnRound() {
        for (Car car : cars) {
            if (randomNumberGenerator.makeNumber() >= MOVE_CONDITION_4) {
                car.movement();
            }
        }
        announceRaceStatus();
    }

    public void announceRaceStatus() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getMoveCount()));
        }
        System.out.println();
    }

    public void announceWinners() {
        List<String> winners = judgement.getWinners(cars);
        judgement.announceWinner(winners);

    }

}
