package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

import static racingcar.view.CommonMessage.ERROR_MESSAGE_PREFIX;

/**
 * InputView 클래스는 사용자 입력을 처리하고, 유효성 검사를 수행한다.
 */
public class InputView {

    private static final String INPUT_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRIAL_COUNT = "시도할 회수는 몇회인가요?";

    /**
     * 경주할 차량 이름을 입력받는다.
     */
    public static String inputCars() {
        System.out.println(INPUT_CARS);   // 안내 메시지 출력
        String input = Console.readLine();
        validateCarNames(input); // 차량 이름 유효성 검사
        return input; // 유효성 검사 후 입력값 반환
    }

    /**
     * 자동차 이름의 유효성을 검사한다.
     */
    public static void validateCarNames(String carNames) {
        String[] names = carNames.split(",");
        Set<String> nameSet = new HashSet<>(); // Set을 사용하여 중복 검사

        for (String name : names) {
            name = name.trim(); // 공백 제거
            if (name.length() > 5) {
                throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + "자동차 이름은 5자 이하여야 합니다.");
            }
            // 중복 검사 추가
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + "자동차 이름이 중복되었습니다.");
            }
        }
    }


    /**
     * 시도 횟수를 입력받고, 유효성을 검증한다.
     */
    public static int inputTrialCount() {
        System.out.println(INPUT_TRIAL_COUNT);   // 안내 메시지 출력
        String input = Console.readLine();   // 사용자 입력값 가져오기
        validateIsNumber(input);   // 숫자인지 검증
        return Integer.parseInt(input);   // 입력값을 정수로 변환하여 반환
    }

    /**
     * 입력값이 숫자인지 확인하고, 숫자가 아닌 경우 예외를 발생시킨다.
     */
    public static void validateIsNumber(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + "시도 횟수는 숫자여야 한다.");
        }
    }

    /**
     * 숫자인지 여부를 확인하는 헬퍼 메서드
     */
    public static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);   // 숫자로 변환 가능하면 true 반환
            return true;
        } catch (NumberFormatException exception) {
            return false;   // 숫자 변환 불가능 시 false 반환
        }
    }
}
