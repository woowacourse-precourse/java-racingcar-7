package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Race {
    // 자동차 객체 초기화
    public static List<Car> initializeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    // 레이싱 로직
    public static void race(List<Car> cars, int tryCount) {
        System.out.println("실행결과 출력");
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars);
            Output.printRaceResult(cars);
        }
    }
    private static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (isMovable()) {
                car.move();
            }
        }
    }

    // 이동 조건 체크
    private static boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
