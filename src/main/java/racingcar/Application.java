package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    private List<Car> cars = new ArrayList<>();
    private int tryCount;

    public void start() {
        inputCarNames();
        inputTryCount();
    }

    private void inputTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        tryCount = Integer.parseInt(Console.readLine());
        if (tryCount <= 0){
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }
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
