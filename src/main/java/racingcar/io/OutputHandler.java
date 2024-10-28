package racingcar.io;

import java.util.List;
import racingcar.Car;

public class OutputHandler {
    // TODO: 차수별 실행 결과를 출력할 때 자동차 이름을 같이 출력한다.

    public void printTrialResult(List<Car> cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
