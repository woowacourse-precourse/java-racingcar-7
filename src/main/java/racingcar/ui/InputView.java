package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> showGetCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return parsingCarNames(Console.readLine());
    }

    private List<String> parsingCarNames(String carNamesInput) {
        return Arrays.stream(carNamesInput.split(","))
                .toList();
    }

    public int showGetFinalRoundInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
