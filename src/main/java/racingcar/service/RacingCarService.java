package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import racingcar.car.RacingCar;

public class RacingCarService {

    private List<RacingCar> racingCars;

    public RacingCarService() {
    }

    public List<RacingCar> logic(List<String> carNames, int moveCount) {

        return racingCars;
    }


    public void process(List<RacingCar> racingCars) {
        racingCars.stream()
                .filter(racingCar -> Randoms.pickNumberInRange(0, 9) >= 4)
                .forEach(RacingCar::moveForwardOneStep);
    }


    public List<RacingCar> getWinnerRacingCars(List<RacingCar> racingCars) {
        racingCars.sort(Comparator.comparingInt(RacingCar::getDistance).reversed());

        int maxDistance = racingCars.getFirst().getDistance();
        List<RacingCar> winners = racingCars.stream().filter(car -> car.getDistance() == maxDistance).toList();

        return winners;
    }
}
