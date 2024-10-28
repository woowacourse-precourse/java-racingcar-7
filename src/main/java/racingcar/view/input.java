package racingcar.view;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class input {
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        return splitCarNames(carNames);
    }

    public List<String> splitCarNames(String carNames) {
        return Arrays.asList(carNames.split(","));
    }

    public String getCarNamesAsString(List<String> carNames) {
        return String.join(",", carNames);
    }
    
    public int getAttemptCount() {
        System.out.println("시도할 횟수를 입력하세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
        }
    }
}