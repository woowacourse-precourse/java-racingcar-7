package racingcar;

public class Input {

    public void checkValidation(String name) {
        checkIsEmpty(name);
        checkNameLength(name);
    }

    public void checkNameLength(String name) {
        if (name.length() > 5) throw new IllegalArgumentException("이름은 5글자를 넘을 수 없습니다.");
    }

    public void checkIsEmpty(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("이름은 한 글자 이상 입력해야 합니다.");
    }

}
