package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static String SPLIT_SIGN = ",";

    public void outputTrialResult(Cars cars) {
        List<Car> carGroup = cars.getCarGroup();
        for (Car car : carGroup) {
            System.out.println(car.getName() + " : " + car.getPosition());
        }
        System.out.println();
    }

    public void outputWinningCars(List<Car> winningCarGroup) {
        List<String> winningCarNames = new ArrayList<>();
        for (Car car : winningCarGroup) {
            winningCarNames.add(car.getName());
        }
        String printWinningGroup = String.join(SPLIT_SIGN+" ", winningCarNames);
        System.out.println("최종 우승자 : " + printWinningGroup);
    }
}
