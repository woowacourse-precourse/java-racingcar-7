package racingcar.domain.refree;

import racingcar.domain.car.Car;
import racingcar.domain.car.value.Distance;
import racingcar.domain.refree.value.SingleResult;
import racingcar.domain.refree.value.WinnerNames;

import java.util.List;
import java.util.stream.IntStream;

public class Referee {

    public List<SingleResult> startGame(List<Car> cars, int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> race(cars))
                .toList();
    }

    private SingleResult race(List<Car> cars) {
        SingleResult singleResult = new SingleResult();

        cars.forEach(car -> {
            car.go();
            singleResult.insert(car);
        });
        return singleResult;
    }

    public WinnerNames decideWinners(SingleResult finalResult) {

        int max = finalResult.getDistanceValues().stream()
                .mapToInt(Distance::getValue)
                .max().orElseThrow(IllegalArgumentException::new);

        return WinnerNames.from(finalResult.findByValue(max));
    }
}
