package racingcar.view;

import racingcar.model.Car;
import racingcar.message.ViewMessage;

import java.util.List;

public class OutputView {

    // 시도 횟수별 결과 출력
    public static void printRunResult(List<Car> cars) {
        System.out.println(ViewMessage.RUN_RESULT_MESSAGE);
        for (Car car : cars) {
            printCarRunResult(car);
        }
    }

    // 차량별 중간 결과 출력
    public static void printCarRunResult(Car car) {
        System.out.print(car.getName() + " : " + "-".repeat(car.getMove()));
        System.out.println();
    }

    // 우승자 출력
    public static void printWinner(List<String> cars) {
        System.out.print(ViewMessage.GET_WINNER_MESSAGE);
        System.out.println(String.join(",", cars));
    }
}