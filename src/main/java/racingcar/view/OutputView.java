package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class OutputView {

    public static void printRunMessage() {
        System.out.println("실행 결과");
    }

    public static void printDistance(List<Car> carList) {
        System.out.println(carList.toString());
    }

    public static void printWinner(List<Car> winnerList) {
        String result = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.print("최종 우승자 : " + result);
    }
}
