package racingcar;

public class Validation {
    boolean isRightInputName(String inputName) {
        String regexInputName = "[^,]{1,5}(,[^,]{1,5})*";
        return (inputName.matches(regexInputName) && !inputName.isEmpty());
    }

    boolean isRightCount(String inputCount) {
        String regexCount = "[0-9]+";
        return (inputCount.matches(regexCount) && !inputCount.isEmpty());
    }
}