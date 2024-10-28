package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.Utils.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분");
        String[] carNames = getNamesFromString(readLine());

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = getTryCountFromString(readLine());

        List<Car> vehicles = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            vehicles.add(new Car(carName, 0));
        }

        System.out.println("실행 결과");
        for (int i = 0; i <tryCount; i++) {
            for (Car car : vehicles) {
                car.move();
                car.printLocation();
            }
        }
    }
}
