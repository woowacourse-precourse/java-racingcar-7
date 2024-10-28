package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.model.car.Car;

public class OutputView {

    public void printResultTitleView() {
        System.out.println("실행 결과");
    }

    public void printUnitResult(Map<Car, Integer> resultInfo) {
        for (Map.Entry<Car, Integer> entry : resultInfo.entrySet()) {
            Car car = entry.getKey();
            Integer moves = entry.getValue();
            System.out.println(car.getName() + " : " + "-".repeat(moves));
        }
        System.out.println();
    }

}
