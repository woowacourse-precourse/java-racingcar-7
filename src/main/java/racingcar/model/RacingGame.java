package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RacingGame {

    private final List<RacingCar> cars;
    private final int loopCount;

    public RacingGame(List<RacingCar> cars, int loopCount) {
        this.cars = cars;
        this.loopCount = loopCount;
    }

    public void playRound() {
        cars.forEach(car -> {
            int random = Randoms.pickNumberInRange(0, 9);
            if (random > 3) {
                car.move();
            }
        });
    }

    public List<RacingCar> findWinners() {
        int maxPosition = cars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .getAsInt();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public int getLoopCount() {
        return loopCount;
    }
}
