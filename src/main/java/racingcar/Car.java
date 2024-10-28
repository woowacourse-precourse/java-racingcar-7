package racingcar;

import java.util.StringJoiner;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.internal.ErrorMessages;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Car {
    public enum Error {
        NAME_OVER("자동차 이름이 너무 길어요");
        private final String message;

        Error(final String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
    private final String name;
    public Car(final String name) {
        final String trimmedName = name.trim();
        validateNameLength(trimmedName);
        this.name = trimmedName;
    }
    private void validateNameLength(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(Error.NAME_OVER.getMessage());
        }
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return new StringJoiner(",", Car.class.getSimpleName()+"[","]")
                .add("name="+name+"'")
                .toString();
    }
}

