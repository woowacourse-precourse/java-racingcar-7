package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름을 쉼표(,) 기준으로 구분");

        List<String> carNameList = List.of(readLine().split(","));
        List<Car> carList = new ArrayList<>();

        for (String name : carNameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            } else {
                Car car = new Car(name);
                carList.add(car);
            }
        }
    }
}
