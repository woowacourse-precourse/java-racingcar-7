package view;

import static racingcar.Car.createDefaultCar;

import camp.nextstep.edu.missionutils.Console;
import exception.CustomIllegalArgException;
import java.util.ArrayList;
import java.util.List;
import racingcar.Car;
import util.RandomGenerator;

public class InputView {

    public List<Car> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return makeCars(Console.readLine().trim());
    }

    public List<Car> makeCars(String inputCarNames) {
        List<Car> cars = new ArrayList<>();
        String[] carNames = inputCarNames.split(",");
        for (String carName : carNames) {
            cars.add(createDefaultCar(carName, new RandomGenerator()));
        }
        return cars;
    }

    public int inputAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요? (최대 10억까지 가능)");
        return validCount(Console.readLine().trim());
    }

    public int validCount(String inputCount) {
        try {
            int attemptCount = Integer.parseInt(inputCount);
            if (attemptCount < 1 || attemptCount > 1_000_000_000) {
                throw new IllegalArgumentException("시도 횟수는 1 이상 1,000,000,000 이하의 숫자여야 합니다.");
            }
            return attemptCount;
        } catch (NumberFormatException e) {
            throw new CustomIllegalArgException("숫자만 입력해야 합니다.");
        } catch (IllegalArgumentException e) {
            throw new CustomIllegalArgException(e.getMessage());
        }
    }
    
}
