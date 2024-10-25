package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    private List<Car> cars = new ArrayList<>();

    public void start() {
        inputCarNames();
    }

    private void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        validateNames(names);
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private void validateNames(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new Application().start();
    }
}
