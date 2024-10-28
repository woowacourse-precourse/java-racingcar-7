package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import static racingcar.validator.InputValidator.validateAttemptsInput;
import static racingcar.validator.InputValidator.validateCars;

public class InputView {
    // 자동차 이름 입력 메소드
    public static String inputCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String text = Console.readLine();
        return text;
    }

    public static String[] parseCars(String text) {
        text = text.replaceAll("^,+|,+$", ""); // 앞뒤 , 오는경우 제거
        String[] cars = text.split(",");
        cars = Arrays.stream(cars)
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .toArray(String[]::new);
        validateCars(cars);
        return cars;
    }


    // 시도 횟수 입력 메소드
    public static String inputAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return input;
    }

    public static int parseAttempts(String input) {
        int attempts = validateAttemptsInput(input);
        return attempts;
    }
}