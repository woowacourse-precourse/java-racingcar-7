package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarNameValidator;
import racingcar.validator.RaceValidator;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static List<String> getCarNames() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String input = Console.readLine();
            List<String> carNames = Arrays.asList(input.split(","));
            CarNameValidator.validateNames(carNames);
            return carNames; 
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 자동차 이름 입력입니다.");
        }
    }

    public static int getNumberOfRounds() {
        try {
            System.out.println("시도할 횟수는 몇 회인가요?");
            String input = Console.readLine();
            RaceValidator.validateRoundsInput(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 시도 횟수 입력입니다.");
        }
    }
}
