package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<RacingCar> cars;

    public RacingGame(List<String> carNames) {
        this.cars = carNames.stream()
            .map(RacingCar::new)
            .collect(Collectors.toList());
    }

    public void playOneTurn(){
        cars.forEach(car -> car.move(Randoms.pickNumberInRange(0,9)));
    }

    public List<RacingCar> getCarNames(){
        return cars;
    }

    public List<String> getWinnerNames(){
        int maxPosition = cars.stream()
            .mapToInt(RacingCar::getPosition)
            .max()
            .orElse(0);

        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(RacingCar::getName)
            .collect(Collectors.toList());
    }

}
