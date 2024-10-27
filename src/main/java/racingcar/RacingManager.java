package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingManager {

    private final List<Car> cars;
    private final int rounds;
    private final List<RoundResult> results;

    public RacingManager(List<String> carNames, int round) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.rounds = round;
        this.results = new ArrayList<>(round);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getRounds() {
        return rounds;
    }

    public List<RoundResult> startRace() {
        for (int i = 0; i < rounds; i++) {
            cars.forEach(car -> {
                int number = Randoms.pickNumberInRange(0, 9);
                car.attemptMove(number);
            });
            results.add(new RoundResult(cars));
        }
        return results;
    }

    public void printResult() {
        for (RoundResult result : results) {
            result.print();
        }
        System.out.println();
    }
}
