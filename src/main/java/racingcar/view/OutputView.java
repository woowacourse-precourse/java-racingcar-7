package racingcar.view;

import java.util.stream.Collectors;
import racingcar.car.Car;

import java.util.List;

public class OutputView {
    public static void carNameOutView() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void tryNumberOutView() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void excuteResult() {
        System.out.println("\n실행 결과");
    }

    public static void resultPerTry(List<Car> racingCar) {
        String tryResult = racingCar.stream()
                .map(car -> car.getCarName() + " : " + "-".repeat(car.getPosition()))
                .collect(Collectors.joining("\n"));
        System.out.println(tryResult + "\n");
    }

    public static void outputWinner(List<Car> winners) {
        String winnerResult = "최종 우승자 : " +
                winners.stream()
                        .map(Car::getCarName)
                        .collect(Collectors.joining(", "));
        System.out.println(winnerResult);
    }
}
