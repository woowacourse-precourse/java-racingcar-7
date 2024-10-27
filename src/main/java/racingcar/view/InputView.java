package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class InputView {
    // 자동차 이름 입력 메소드
    public static String[] inputCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String text = Console.readLine();
        String[] cars = text.split(",");
        validateCars(cars);
        return cars;
    }

    // 시도 횟수 입력 메소드
    public static int inputAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        int attempts = validateAttemptsInput(input);
        return attempts;
    }

    // 자동차 이름 유효성 검사
    public static void testValidateCars(String[] cars) {
        validateCars(cars);
    }
    // 시도 횟수 유효성 검사
    public static int testValidateAttemptsInput(String input) {
        return validateAttemptsInput(input);
    }

    private static void validateCars(String[] cars) {
        Set<String> cheakUnique = new HashSet<>();
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
        if (cars.length <2 ) throw new IllegalArgumentException("자동차는 최소 2대 이상 입력해야 합니다.");
        for (String name : cars) {
            if (name.isEmpty())
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            if (name.length() > 5)
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            if (!pattern.matcher(name).matches())
                throw new IllegalArgumentException("자동차 이름은 영문자와 숫자만 포함해야 합니다.");
            if (!cheakUnique.add(name))
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private static int validateAttemptsInput(String input) {
        try {
            int attempts = Integer.parseInt(input);
            validateAttempts(attempts);
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자로 입력해야 합니다.");
        }
    }
     public static void validateAttempts(int attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 양수를 입력해주세요");
        }
    }

}
