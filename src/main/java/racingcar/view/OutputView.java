package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class OutputView {

    public void printCarNameProvideMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryCountProvideMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printExecutionResult() {
        System.out.println("실행 결과");
    }

    public void printCarNameAndMovingStatus() {
        System.out.println(car.getName() + " : " + car.getMoveStatus());
    }

    public void printWinningPeople(List<Car> winningCars) {
        System.out.print("최종 우승자 : ");
        final String delimiter = ",";
        final String listToStringWithDelimiter = winningCars.stream().map(Car::getName)
                .collect(Collectors.joining(delimiter));
        System.out.println(listToStringWithDelimiter);
    }

}
