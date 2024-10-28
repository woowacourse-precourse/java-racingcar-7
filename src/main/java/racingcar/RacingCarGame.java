package racingcar;

import java.util.Arrays;
import java.util.List;

public class RacingCarGame {

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }

        return carNames;
    }
}