package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class ResultView {

    private final StringBuilder stringBuilder = new StringBuilder();

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void addTurnView(final List<Car> carList) {
        for (final Car car : carList) {
            stringBuilder.append(car.getName()).append(" : ").append("-".repeat(car.getDistance())).append("\n");
        }
        stringBuilder.append("\n");
    }

    public void printResultView() {
        System.out.print(stringBuilder);
    }
}
