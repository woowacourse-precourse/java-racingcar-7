package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class RacingGame {
    public void start() {
        List<String> carNames = getCarNames();
        int attempts = getAttempts();

        Race race = new Race(carNames);
        race.run(attempts);
    }

    private List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validateCarNamesInput(input);
        List<String> carNames = Arrays.asList(input.split(","));
        return carNames;
    }

    private void validateCarNamesInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요.");
        }
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException("이름을 제대로 입력해 주세요.");
        }
        if (input.contains(",,")) {
            throw new IllegalArgumentException("연속된 쉼표는 허용되지 않습니다.");
        }
        String[] names = input.split(",");
        for (String name : names) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("빈 이름은 허용되지 않습니다.");
            }
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int attempts = Integer.parseInt(Console.readLine());
            if (attempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력해 주세요.");
        }
    }
}