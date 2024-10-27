package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요,(,)로 구분됩니다");

        String carNamesInput = Console.readLine();
        // "a, b, c" > ["a", "b", "c"]
        List<String> carNames = Arrays.stream(carNamesInput.split(","))
                .toList();

        return carNames;
    }

    public int inputMaxRound() {

        System.out.println("시도할 횟수는 몇회인가요?");
        String maxRoundInput = Console.readLine();
        return Integer.parseInt(maxRoundInput);

    }

}
