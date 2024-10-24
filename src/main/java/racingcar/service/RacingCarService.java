package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import racingcar.car.RacingCar;
import racingcar.util.RandomPicker;

public class RacingCarService {

    private List<RacingCar> racingCars;
    private final RandomPicker randomPicker;

    public RacingCarService(RandomPicker randomPicker) {
        this.randomPicker = randomPicker;
    }

    public List<RacingCar> logic(List<String> carNames, int moveCount) {

        return racingCars;
    }


    public void process(List<RacingCar> racingCars) {
        racingCars.stream()
                .filter(racingCar -> randomPicker.pickNumberInRange(0, 9) >= 4)
                .forEach(RacingCar::moveForwardOneStep);
    }


    public List<RacingCar> getWinnerRacingCars(List<RacingCar> racingCars) {
        racingCars.sort(Comparator.comparingInt(RacingCar::getDistance).reversed());

        int maxDistance = racingCars.getFirst().getDistance();
        List<RacingCar> winners = racingCars.stream().filter(car -> car.getDistance() == maxDistance).toList();

        return winners;
    }
}
