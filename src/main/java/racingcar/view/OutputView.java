package racingcar.view;

import java.util.List;
import racingcar.Car;

public class OutputView {

    public final void printRacingCarNameFormat() {
        System.out.println("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
    }

    public final void printRacingRoundRequest() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public final void printMovingCarsWithPositions(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.getNameWithPosition()));
        System.out.println();
    }

    public final void printRacingWinners(List<String> carNames) {
        String winners = String.join(", ", carNames);
        System.out.println(winners);
    }
}
