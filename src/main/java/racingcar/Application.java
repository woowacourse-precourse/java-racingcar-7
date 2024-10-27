package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            List<Car> cars = initializeCars();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<Car> initializeCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            cars.add(new Car(name.trim()));
        }
        return cars;
    }
}

class Car {
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
