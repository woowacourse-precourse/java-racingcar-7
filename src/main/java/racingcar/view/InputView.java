package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(",", -1));

        validateCarNames(carNames);
        return carNames;
    }

    public int getNumberOfRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    private void validateCarNames(List<String> carNames) {
        if (carNames.stream().anyMatch(name -> name.trim().isEmpty())) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열이나 공백을 포함할 수 없습니다.");
        }

        if (carNames.stream().anyMatch(name -> name.matches(".*[\\s\\p{Cntrl}].*"))) {
            throw new IllegalArgumentException("자동차 이름에 공백이나 제어 문자는 포함될 수 없습니다.");
        }

        if (carNames.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }


}
