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

    private List<String> splitCarNames(String carNames) {
        return Arrays.asList(carNames.split(","));
    }

    public String getCarNamesAsString(List<String> carNames) {
        return String.join(",", carNames);
    }
}