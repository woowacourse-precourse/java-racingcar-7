package racingcar.util;

import racingcar.config.GameConfig;

public class Validator {
    private Validator() {
        // 인스턴스화 방지
    }

    // 예외처리 사항
    // 자동차가 1대일 경우 콤마로 구분하지 않고
    // 여러대일 경우 콤마로 이름을 구분해야 한다.

    // 자동차 이름 유효성 검증
    public static void validateCarName(String name) {
        if (name == null || name.trim().isEmpty()) {
            // 텍스트를 enum으로 처리하기
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }
        if (name.length() > GameConfig.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + GameConfig.MAX_NAME_LENGTH + "자를 초과할 수 없습니다.");
        }
    }
}
