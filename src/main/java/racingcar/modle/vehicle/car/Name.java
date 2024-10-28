package racingcar.modle.vehicle.car;

public class Name {
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final String NUMBER = "^(0|(([-][0]\\.\\d+)|([0]+\\.\\d+)|([-]?[1-9]\\d*(\\.\\d+)?)))$";

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        validateNameForm(name);
        validateNameLength(name);
        validateNumberName(name);
    }

    private void validateNameForm(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름을 null 또는 공백으로 잘못 입력하셨습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름 길이를 5자 이하로 입력해주세요");
        }
    }

    private void validateNumberName(String name) {
        if (name.matches(NUMBER)) {
            throw new IllegalArgumentException("이름을 숫자로 잘못입력하셨습니다.");
        }
    }
}
