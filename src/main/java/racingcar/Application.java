package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        // Car 라는 클래스를 만들어 List<Car>로 처리할까 -> 확장성 고려해서(나중에 후진 같은 것이 생길지도)
        // Map<String, Integer>로 처리할까

        List<Car> cars = new ArrayList<>();
        for (String carName : input.split(",")) {
            if(carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            Car car = new Car(carName, 0);
            cars.add(car);
        }


    }

}
