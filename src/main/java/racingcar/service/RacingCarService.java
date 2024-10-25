package racingcar.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.car.RacingCar;
import racingcar.util.RandomPicker;

public class RacingCarService {

    private final RandomPicker randomPicker;

    public RacingCarService(RandomPicker randomPicker) {
        this.randomPicker = randomPicker;
    }

    public List<RacingCar> logic(List<String> carNames, int moveCount) {
        List<RacingCar> racingCars = carNames.stream().map(name -> new RacingCar(name, 0)).toList();

        repeatMethod(racingCars, moveCount);

        List<RacingCar> winnerRacingCars = getWinnerRacingCars(racingCars);

        return winnerRacingCars;
    }

    public void repeatMethod(List<RacingCar> racingCars, int moveCount) {
        IntStream.range(0, moveCount).forEach(i -> {
            process(racingCars);
            racingCars.forEach(RacingCar::printMoveStatus);
        });
        System.out.println();
    }


    public void process(List<RacingCar> racingCars) {
        racingCars.stream().filter(racingCar -> randomPicker.pickNumberInRange(0, 9) >= 4)
                .forEach(RacingCar::moveForwardOneStep);
    }


    public List<RacingCar> getWinnerRacingCars(List<RacingCar> racingCars) {
        racingCars.sort(Comparator.comparingInt(RacingCar::getDistance).reversed());

        int maxDistance = racingCars.getFirst().getDistance();
        List<RacingCar> winners = racingCars.stream().filter(car -> car.getDistance() == maxDistance).toList();

        return winners;
    }
}
