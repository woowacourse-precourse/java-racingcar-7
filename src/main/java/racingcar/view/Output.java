package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class Output {
    public void printIntermediateResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + getPositionOutPut(car.getPosition()));
        }
    }

    public void printMessage() {
        System.out.println();
        System.out.println("실행결과");
    }

    public void printWinner(List<Car> winners) {
        System.out.print("최종 우승자 : " + joinNames(winners));
    }

    private String getPositionOutPut(int carPosition) {
        String positionOutPut = "";
        for (int i = 0; i < carPosition; i++) {
            positionOutPut += "-";
        }
        return positionOutPut;
    }

    private String joinNames(List<Car> winnerList) {
        return winnerList.stream()
                .map(Car::getName)
                .reduce((name1, name2) -> name1 + ", " + name2)
                .orElse("");
    }
}
