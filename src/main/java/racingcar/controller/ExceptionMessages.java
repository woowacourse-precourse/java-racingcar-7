package racingcar.controller;

public class ExceptionMessages {
    public class Default {
        public static final String EMPTY_CAR_NAME = "자동차의 이름은 빈 문자열이어서는 안됩니다.";
        public static final String CAR_NAME_ONLY_DELIMITER = "자동차의 이름은 구분자인 쉼표(,)로만 이루어질 수 없습니다.";
        public static final String CAR_NAME_ENDS_WITH_DELIMITER = "자동차의 이름은 구분자인 쉼표(,)로 끝나서는 안됩니다.";
        public static final String INVALID_CAR_NAME_CHARACTERS = "자동차의 이름은 숫자, 알파벳, 한글만 가능합니다.";
        public static final String EMPTY_TOTAL_ROUNDS = "총 라운드는 빈 값을 입력하실 수 없습니다.";
        public static final String TOTAL_ROUNDS_NOT_INTEGER = "총 라운드는 정수 형태로 입력하셔야 합니다.";
    }
}

