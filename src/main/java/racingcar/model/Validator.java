package racingcar.model;

public class Validator {
    public void validateCarName(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }
}
