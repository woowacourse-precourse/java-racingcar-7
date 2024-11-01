package racingcar.model;

import java.util.Optional;
import java.util.function.Predicate;

import racingcar.message.CarConstant;
import racingcar.message.ErrorMessage;
import racingcar.exception.CarNameException;
import racingcar.message.PatternMessage;
import racingcar.message.SeparatorPattern;

public class Car {
    private final String name;
    int position = CarConstant.INITIAL_POSITION.getValue();


    public Car(String name) {
        this.name = validateCarName(name);
    }

    public void moveForward() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private String validateCarName(String name) {
        validateCondition(name, isEmpty(), ErrorMessage.CAR_NAME_IS_EMPTY.getMessage());
        validateCondition(name, isOnlyWhitespace(), ErrorMessage.CAR_NAME_IS_SPACE.getMessage());
        validateCondition(name, exceedsMaxLength(), ErrorMessage.CAR_NAME_IS_TOO_LONG.getMessage());
        validateCondition(name, containsComma(), ErrorMessage.INVALID_COMMA_INPUT.getMessage());
        validateCondition(name, containsInvalidCharacters(), ErrorMessage.INVALID_NAME_CHARACTER.getMessage());
        return name;
    }

    private void validateCondition(String name, Predicate<String> condition, String errorMessage) {
        Optional.of(name)
                .filter(condition.negate())
                .orElseThrow(() -> new CarNameException(errorMessage));
    }

    private Predicate<String> isEmpty() {
        return String::isEmpty;
    }

    private Predicate<String> isOnlyWhitespace() {
        return String::isBlank;
    }

    private Predicate<String> exceedsMaxLength() {
        return n -> n.length() > CarConstant.MAX_NAME_LENGTH.getValue();
    }

    private Predicate<String> containsComma() {
        return n -> n.contains(SeparatorPattern.COMMA.getPattern());
    }

    private Predicate<String> containsInvalidCharacters() {
        return n -> !PatternMessage.INVALID_CHARACTERS.matches(n);
    }

}
