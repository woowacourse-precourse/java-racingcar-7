package racingcar.io;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.util.Validator.validateCarGameInput;
import static racingcar.util.Validator.validateTrialCount;

import java.util.List;
import racingcar.Car;

public class InputHandler {

    public List<Car> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        List<String> names = validateCarGameInput(input);
        return names.stream()
                .map(Car::new)
                .toList();
    }

    public int getTrialCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return validateTrialCount(readLine());
    }
}
