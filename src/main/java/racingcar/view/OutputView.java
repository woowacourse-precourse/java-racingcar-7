package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public static void printTryResult(List<Car> cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            String carResult = car.getName() + " : " +"-".repeat(car.getPosition());
            System.out.println(carResult);
        }
    }
    public static void printWinnerResult(List<String> winners) {
        String winnerResult = "최종 우승자" + " : " + String.join(", ", winners);
        System.out.println(winnerResult);
    }
}
