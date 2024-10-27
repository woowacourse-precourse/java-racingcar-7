package racingcar.input;

import java.util.List;

/**
 * 사용자 입력의 유효성 검사
 */
public class CheckValidInput {

    public static void isValidInput(final InputDTO inputDTO) {
        List<String> carNames = inputDTO.carNames();
        int round = inputDTO.round();

        // 1. 자동차 이름 리스트가 비어있거나 null 인 경우
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("유효한 입력이 아닙니다."); // 예외 메시지
        }

        // 2. 자동차 이름이 비어있거나 5자 이상인 경우
        carNames.forEach(carName -> {
            if (carName.isBlank()) {
                throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이내이어야 합니다.");
            }
        });

        // 3. 시도 횟수가 0회 이하인 경우
        if (round <= 0) {
            throw new IllegalArgumentException("시도횟수는 최소 1회 이어야 합니다."); // 예외 메시지
        }
    }
}
