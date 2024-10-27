package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printWinner(List<Car> winnerList) {
        String result = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.print("최종 우승자 : " + result);
    }
}
