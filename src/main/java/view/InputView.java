package view;

import camp.nextstep.edu.missionutils.Console;
import exception.CustomException;
import java.util.ArrayList;
import java.util.List;
import racingcar.Car;

public class InputView {

    public List<Car> inputCarNames() {
        OutputView.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return makeCars(Console.readLine().trim());
    }

    public List<Car> makeCars(String inputCarNames) {
        List<Car> cars = new ArrayList<>();
        String[] carNames = inputCarNames.split(",");
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public int inputAttemptCount() {
        OutputView.println("시도할 회수는 몇회인가요? (최대 10억까지 가능)");
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
            CustomException.throwException("숫자만 입력해야 합니다.");
        } catch (IllegalArgumentException e) {
            CustomException.throwException(e.getMessage());
        }
        return 0; // 필요없는 줄
    }


}
