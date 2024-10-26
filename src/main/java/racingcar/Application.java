package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCars = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputAttemptCount = Console.readLine();

        Integer attemptCount = Integer.parseInt(inputAttemptCount);

        String[] carList = inputCars.split(",");

        List<Car> cars = new ArrayList<>();

        for (String s : carList) {
            cars.add(new Car(s, 0));
        }

    }
}
