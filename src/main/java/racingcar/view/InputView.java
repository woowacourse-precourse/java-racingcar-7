package racingcar.view;

import static racingcar.Exception.ErrorMessage.DUPLICATE_CAR_NAMES;
import static racingcar.Exception.ErrorMessage.EMPTY_CAR_NAME;
import static racingcar.Exception.ErrorMessage.EMPTY_MOVE_COUNT;
import static racingcar.Exception.ErrorMessage.INVALID_CAR_NAME;
import static racingcar.Exception.ErrorMessage.INVALID_MOVE_COUNT;
import static racingcar.Exception.ErrorMessage.NEGATIVE_MOVE_COUNT;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

/**
 * 사용자로부터 입력을 받고, 입력된 데이터를 검증하는 역할을 담당하는 클래스입니다. 자동차 이름과 이동 횟수를 입력받아 유효성을 검사한 후 반환합니다.
 */
public class InputView {

    /**
     * 사용자로부터 자동차 이름을 입력받아 반환합니다. 입력된 이름이 유효한지 검증한 후 반환하며, 유효하지 않은 경우 예외를 발생시킵니다.
     *
     * @return 유효한 자동차 이름 문자열
     * @throws IllegalArgumentException 입력된 자동차 이름이 유효하지 않을 경우 발생
     */
    public static String readCarNames() {
        return readAndValidateCarNames();
    }

    /**
     * 자동차 이름을 입력받고, 입력된 이름의 유효성을 검증하는 내부 메서드입니다.
     *
     * @return 유효한 자동차 이름 문자열
     * @throws IllegalArgumentException 입력된 자동차 이름이 유효하지 않을 경우 발생
     */
    private static String readAndValidateCarNames() {
        // 사용자로부터 자동차 이름 입력 받기
        String input = Console.readLine();

        // 입력이 null이거나 공백인 경우 예외 발생
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME);
        }

        // 자동차 이름의 유효성 검증
        validateCarNames(input);

        // 유효한 입력 반환
        return input;
    }

    /**
     * 입력된 자동차 이름 문자열을 쉼표(,)로 분리하여 각 이름의 유효성을 검증합니다. 이름의 길이가 1자 이상 5자 이하인지, 중복되는 이름이 없는지를 확인합니다.
     *
     * @param input 쉼표로 구분된 자동차 이름 문자열
     * @throws IllegalArgumentException 이름이 유효하지 않거나 중복될 경우 발생
     */
    private static void validateCarNames(String input) {
        // 쉼표로 이름 분리
        String[] names = input.split(",");

        // 중복 이름을 확인하기 위한 Set
        Set<String> nameSet = new HashSet<>();

        // 각 이름에 대해 검증 수행
        for (String name : names) {
            // 이름의 앞뒤 공백 제거
            String trimmedName = name.trim();

            // 이름이 비어있거나 5자를 초과하는지 확인
            if (trimmedName.isEmpty() || trimmedName.length() > 5) {
                throw new IllegalArgumentException(INVALID_CAR_NAME);
            }

            // 이름이 중복되는지 확인
            if (!nameSet.add(trimmedName)) {
                throw new IllegalArgumentException(DUPLICATE_CAR_NAMES);
            }
        }
    }

    /**
     * 사용자로부터 이동 횟수를 입력받아 반환합니다. 입력된 횟수가 유효한지 검증한 후 반환하며, 유효하지 않은 경우 예외를 발생시킵니다.
     *
     * @return 유효한 이동 횟수
     * @throws IllegalArgumentException 입력된 이동 횟수가 유효하지 않을 경우 발생
     */
    public static int readMoveCount() {
        return readAndValidateMoveCount();
    }

    /**
     * 이동 횟수를 입력받고, 입력된 횟수의 유효성을 검증하는 내부 메서드입니다.
     *
     * @return 유효한 이동 횟수
     * @throws IllegalArgumentException 입력된 이동 횟수가 유효하지 않을 경우 발생
     */
    private static int readAndValidateMoveCount() {
        // 사용자로부터 이동 횟수 입력 받기
        String input = Console.readLine();

        // 입력이 null이거나 공백인 경우 예외 발생
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_MOVE_COUNT);
        }

        try {
            // 입력된 문자열을 정수로 변환
            int count = Integer.parseInt(input.trim());

            // 이동 횟수가 음수인 경우 예외 발생
            if (count < 0) {
                throw new IllegalArgumentException(NEGATIVE_MOVE_COUNT);
            }

            // 유효한 이동 횟수 반환
            return count;
        } catch (NumberFormatException e) {
            // 입력된 문자열이 정수가 아닌 경우 예외 발생
            throw new IllegalArgumentException(INVALID_MOVE_COUNT);
        }
    }
}
