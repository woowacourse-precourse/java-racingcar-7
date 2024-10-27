package racingcar.vo;

import static racingcar.constant.ExceptionMessage.INVALID_CAR_NAME_LENGTH;

/**
 * 자동차 이름을 나타내는 Value Object 입니다. 주의: 이 클래스는 일반적인 VO와 달리 참조 동등성(reference equality)을 사용합니다. 이는 동일한 이름의 서로 다른 자동차를 구분하기
 * 위한 의도적인 설계입니다.
 *
 * @implSpec 이 클래스는 의도적으로 equals와 hashCode를 구현하지 않아 Object 클래스의 참조 기반 동등성 검사를 사용합니다.
 */
public class Name {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String value;

    private Name(String value) {
        validateLength(value);
        this.value = value;
    }

    public static Name from(String value) {
        return new Name(value);
    }

    private static void validateLength(String value) {
        int length = value.length();

        if (length < MIN_LENGTH || length > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH.format(MIN_LENGTH, MAX_LENGTH));
        }
    }

    public String getValue() {
        return value;
    }
}
