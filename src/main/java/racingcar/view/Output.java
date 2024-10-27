package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class Output {
    public void printIntermediateResult(StringBuilder stringBuilder) {
        System.out.print(stringBuilder);
    }

    public void printMessage() {
        System.out.println();
        System.out.println("실행결과");
    }

    public void printWinner(List<Car> winners) {
        System.out.println("최종 우승자 : " + joinNames(winners));
    }

    private String joinNames(List<Car> winnerList) {
        return winnerList.stream()
                .map(Car::getName)
                .reduce((name1, name2) -> name1 + ", " + name2)
                .orElse("");
    }
}
