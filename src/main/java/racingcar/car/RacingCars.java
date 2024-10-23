package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> cars;
    private static final StringBuilder stringBuilder = new StringBuilder();

    private RacingCars(List<RacingCar> cars) {
        this.cars = cars;
    }

    public static RacingCars fromNames(List<String> carNames) {
        List<RacingCar> cars = carNames.stream()
                .map(carName -> new RacingCar(carName, 0))
                .toList();
        return new RacingCars(cars);
    }

    public void playOneRound() {
        cars.forEach(car -> {
            int pickedNumber = Randoms.pickNumberInRange(0, 9);
            if (pickedNumber >= 4) {
                car.increaseMoveCount();
            }
        });
    }

    public String getRacingCarsProgress() {
        cars.forEach(car -> stringBuilder.append(String.format("%s : %s%n",car.getName(), car.getProgress())));
        String racingCarsProgress = stringBuilder.toString();
        stringBuilder.setLength(0);
        return racingCarsProgress;
    }

    public List<String> getWinnersName() {
        return new ArrayList<>(cars.stream()
                .filter(racingCar -> racingCar.isWinner(getMaxMoveCount()))
                .map(RacingCar::getName)
                .toList());
    }

    private int getMaxMoveCount() {
        return cars.stream()
                .mapToInt(RacingCar::getMoveCount)
                .max().orElseThrow(() -> new RuntimeException("최대값을 찾을 수 없습니다."));

    }
}
