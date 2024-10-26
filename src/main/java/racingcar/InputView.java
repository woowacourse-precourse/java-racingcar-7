package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();
        List<String> carNames = Arrays.stream(carNameInput.split(",")).map(String::trim).toList();
        validateCarNames(carNames);

        return carNames;
    }

    public int readNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
