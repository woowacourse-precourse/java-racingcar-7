package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private static final String STEP = "-";

    public void printRacingCarNameFormat() {
        System.out.println("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRacingRoundRequest() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printMovingCarsWithPositions(List<Car> cars) {
        cars.forEach(car -> {
            String result = String.format("%s : %s", car.getName(), STEP.repeat(car.getPosition()));
            System.out.println(result);
        });
        System.out.println();
    }

    public void printRacingWinners(List<String> carNames) {
        String winners = String.join(", ", carNames);
        System.out.println("최종 우승자 : " + winners);
    }
}
