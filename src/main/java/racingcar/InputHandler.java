package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputHandler {
    public static List<Car> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();

        // 입력된 자동차 이름 검증
        if (names == null || names.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }

        List<Car> cars = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(names, ",");

        while (tokenizer.hasMoreTokens()) {
            String name = tokenizer.nextToken().trim();
            if (name.isEmpty() || isNumeric(name)) {
                throw new IllegalArgumentException("유효하지 않은 자동차 이름이 포함되어 있습니다.");
            }
            cars.add(new Car(name));
        }

        return cars;
    }

    public static int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptsInput = Console.readLine();

        // 시도 횟수 입력 검증
        try {
            int attempts = Integer.parseInt(attemptsInput);
            if (attempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.", e);
        }
    }

    // 모든 문자가 숫자인지 확인하는 메서드
    private static boolean isNumeric(String name) {
        for (char c : name.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false; // 하나라도 숫자가 아닐 경우 false 반환
            }
        }
        return true; // 모든 문자가 숫자일 경우 true 반환
    }
}
