package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {
    private static final String DELIMITER = ",";

    // 경주할 자동차 이름을 입력받고 유효성을 검사하여 반환
    public List<String> getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carName = splitCarName(input);

        if (!isValidCarName(carName)) {
            throw new IllegalArgumentException("자동차 이름이 유효하지 않습니다.");
        }

        return carName;
    }

    // 시도할 회수를 입력받고 유효성을 검사하여 반환
    public int getRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        int input;

        try {
            input = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }

        if (!isValidRound(input)) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 숫자여야 합니다.");
        }

        return input;
    }

    // 자동차 이름을 쉼표로 구분하여 리스트로 반환
    private List<String> splitCarName(String carInput) {
        return Arrays.asList(carInput.split(DELIMITER));
    }

    // 자동차 이름의 유효성 검사 (각 이름이 5자 이하인지 확인)
    private boolean isValidCarName(List<String> carName) {
        for (String name : carName) {
            if (name.length() > 5) {
                System.out.println("자동차 이름은 5자 이하만 가능합니다.");
                return false;
            }
        }
        return true;
    }

    // 시도 횟수가 1 이상인지 검사
    private boolean isValidRound(int round) {
        if (round < 1) {
            System.out.println("시도 횟수는 1 이상의 숫자여야 합니다.");
            return false;
        }
        return true;
    }
}
