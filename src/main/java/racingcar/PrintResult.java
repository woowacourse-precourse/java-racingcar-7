package racingcar;

import java.util.List;

public class PrintResult {

    // 현재 각 자동차의 위치를 출력
    public static void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

}
