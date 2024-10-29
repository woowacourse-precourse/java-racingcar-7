package racingcar.view;

import racingcar.dto.CarDTO;
import racingcar.model.Car;

import java.util.List;

public class ResultView {

    private final StringBuilder stringBuilder = new StringBuilder();

    public void printDescription() {
        System.out.println("실행 결과");
    }

    public void addTurnView(final List<Car> carList) {
        for (final Car car : carList) {
            CarDTO dto = car.getCarDTO();
            stringBuilder.append(dto.getName()).append(" : ").append("-".repeat(dto.getPosition())).append("\n");
        }
        stringBuilder.append("\n");
    }

    public void print() {
        System.out.print(stringBuilder);
    }
}
