package racingcar.observer;

import java.util.List;
import racingcar.model.Car;
import racingcar.view.View;

public class RuntimeView implements View, Observer {

    private static final String RUNTIME_MESSAGE = "실행 결과";

    @Override
    public void print() {
        System.out.println(RUNTIME_MESSAGE);
    }

    @Override
    public void update(List<Car> carList) {
        printCurrentRacingStatus(carList);
    }

    private void printCurrentRacingStatus(List<Car> carList) {
        StringBuilder currentRacingStatus = new StringBuilder();
        for (Car car : carList) {
            String advanceStatus = convertAdvanceCount(car.getAdvanceCount());
            appendCarRacingStatus(currentRacingStatus, car, advanceStatus);
        }
        System.out.println(currentRacingStatus);
    }

    private String convertAdvanceCount(int advanceCount) {
        return "-".repeat(advanceCount);
    }

    private void appendCarRacingStatus(StringBuilder currentRacingStatus, Car car, String advanceStatus) {
        currentRacingStatus.append(car.getName()).append(" : ").append(advanceStatus).append("\n");
    }
}
