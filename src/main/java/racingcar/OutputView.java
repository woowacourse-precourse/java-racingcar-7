package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printWinners(List<Car> cars) {

        // [Car{name:"a", position : 1}, Car{name: "b" , position : 2}] -- > "a, b, c, d,"
        String winner = cars.stream()
                .map(Car::getName) // ["a","b"]
                .collect(Collectors.joining(", "));

        System.out.printf("최종 우승자 : %s\n", winner);

    }
}
