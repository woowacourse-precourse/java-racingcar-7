package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public void roundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("%s : %s\n", car.getName(), "-".repeat(car.getScore()));
        }
        System.out.println();
    }
    
}
