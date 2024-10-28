package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CarRace {
    // 자동차 객체 초기화
    public static List<Car> initializeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));//자동차를 자동차 객체로 만드는 과정
        }
        return cars;
    }

    // 레이싱 로직
    public static void race(List<Car> cars, int tryCount){
        System.out.println("실행결과 출력");
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    car.move();
                }
            }
            PrintResult.printRaceResult(cars);//레이싱 결과 출력
        }
    }


}
