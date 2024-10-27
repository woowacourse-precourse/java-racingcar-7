package racingcar.io;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.game.Display;

public class DisplayImpl implements Display {

    @Override
    public void progress(List<Car> cars) {
        List<String> carNames = cars.stream()
            .map(Car::toString)
            .toList();

        String progress = String.join("\n", carNames);
        System.out.println(progress);
        System.out.println();
    }

    @Override
    public void winners(List<Car> winners) {
        List<String> names = winners.stream()
            .map(Car::getName)
            .toList();
        String winnerNames = String.join(", ", names);

        System.out.println("최종 우승자 : " + winnerNames);
    }
}
