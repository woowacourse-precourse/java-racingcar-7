package racingcar;

import java.util.List;

public class OutputUtil {

    public static void printResult(List<Car> winners) {
        StringBuilder result = new StringBuilder("최종 우승자 : ");
        result.append(String.join(", ", winners.stream().map(Car::getName).toList()));
        System.out.print(result);
    }
}
