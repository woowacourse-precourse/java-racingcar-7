package racingcar;

public class Input {
    public void validateBlank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("입력에 공백이 포함되어 있습니다.");
        }
    }
}