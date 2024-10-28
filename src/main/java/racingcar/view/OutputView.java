package racingcar.view;

import racingcar.enums.StringPattern;
import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public void requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void requestTrialCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRacing(List<Car> racingCars) {
        StringBuilder currentPosition = new StringBuilder();
        for (Car car : racingCars) {
            currentPosition.append(car.getName()).append(StringPattern.NAME_VIEWPOINT.getValue())
                    .append(createMovePattern(car))
                    .append("\n");
        }
        System.out.println(currentPosition.toString());
    }

    private String createMovePattern(Car car) {
        return StringPattern.MOVE_FORWARD.getValue()
                .repeat(car.getPosition());
    }

    public void printWinner(List<String> winners) {
        StringBuilder result = new StringBuilder();
        result.append("최종 우승자 : ")
                .append(joinWinner(winners));
        System.out.println(result);
    }

    private String joinWinner(List<String> winners) {
        return String.join(StringPattern.JOIN_SYMBOL.getValue(), winners);
    }
}
