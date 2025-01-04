package view;

import camp.nextstep.edu.missionutils.Console;
import exception.CustomException;
import java.util.ArrayList;
import java.util.List;
import racingcar.Car;

public class InputView {

    public List<Car> makeCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> cars = new ArrayList<>();
        String[] carNames = Console.readLine().trim().split(",");
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public int inputAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요? (최대 10억까지 가능)");
        try {
            int attemptCount = Integer.parseInt(Console.readLine().trim());
            if (attemptCount < 1 || attemptCount > 1_000_000_000) {
                throw new IllegalArgumentException();
            }
            return attemptCount;
        } catch (IllegalArgumentException e) {
            CustomException.throwException("시도 횟수를 정확히 입력해주세요(숫자만 입력)");
        }
        return 0;
    }


}
