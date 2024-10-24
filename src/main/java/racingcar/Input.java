package racingcar;

public class Input {

    public void checkValidation(String name) {
        checkIsEmpty(name);
    }

    public void checkIsEmpty(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("이름은 한 글자 이상 입력해야 합니다.");
    }

}
