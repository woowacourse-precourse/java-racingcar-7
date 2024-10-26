package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class RuntimeView implements View {

    @Override
    public void print() {
        System.out.println("실행 결과");
    }

    public void printCarAdvances(List<Car> carList) {
        for (Car car : carList) {
            String advancedCount = convertAdvanceCount(car.getAdvanceCount());
            System.out.println(car.getName() + " : " + advancedCount);
        }
        System.out.println();
    }

    private String convertAdvanceCount(int advanceCount) {
        StringBuilder advancedCount = new StringBuilder();
        for (int i = 0; i < advanceCount; i++) {
            advancedCount.append("-");
        }

        return advancedCount.toString();
    }
}
