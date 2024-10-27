package racingcar.domain;

import java.util.Objects;
import java.util.regex.Pattern;

import static racingcar.exception.ExceptionMessage.NAME_OUT_OF_RANGE;
import static racingcar.exception.ExceptionMessage.WRONG_NAME_FORMAT;

public class CarName {

    public static final int MAXIMUM = 5;
    public static final Pattern SPECIAL_CHARACTER = Pattern.compile("[^a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]");

    private final String name;

    public CarName(String name) {
        validateCarsName(name);
        validateLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateLength(String name) {
        if (name.isBlank() || name.length() > MAXIMUM) {
            throw new IllegalArgumentException(NAME_OUT_OF_RANGE.formatMessage(MAXIMUM));
        }
    }

    private void validateCarsName(String name) {
        if (SPECIAL_CHARACTER.matcher(name).find()) {
            throw new IllegalArgumentException(WRONG_NAME_FORMAT.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
