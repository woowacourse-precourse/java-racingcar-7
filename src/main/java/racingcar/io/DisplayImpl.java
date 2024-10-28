package racingcar.io;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.game.Display;

public class DisplayImpl implements Display {

    private boolean isFirst = true;

    @Override
    public void progress(List<Car> cars) {
        ifFirstFloatLabel();
        cars.forEach(System.out::println);
        System.out.println();
    }

    private void ifFirstFloatLabel() {
        if (isFirst) {
            System.out.println("\n실행 결과");
            isFirst = false;
        }
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
