package racingcar;

import java.util.List;

public class OutputView {

    public void displayResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() + " : ");
        }
    }

    public void displayWinner(List<String> result) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i != result.size() - 1) {
                System.out.print(",");
            }
        }
    }
}
