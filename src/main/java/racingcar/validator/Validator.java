package racingcar.validator;

public class Validator {

    public void carNameLengthValidate(String car) {

        if(car.length() > 5) {
            throw new IllegalArgumentException("레이싱카 이름의 길이는 5글자가 넘을 수 없습니다.");
        }
    }

    public void carNameAllBlankValidate(String car) {
        if (car.isBlank()) {
            throw new IllegalArgumentException("레이싱카 이름은 공백일 수 없습니다.");
        }
    }

    public void carNameWhiteSpaceValidate(String car) {
        for(char c : car.toCharArray()) {
            if(Character.isWhitespace(c)) {
                throw new IllegalArgumentException("레이싱카 이름에 공백이 포함될 수 없습니다.");
            }
        }
    }

    // ','가 아닌 다른 것으로 구분되어 있을 경우
    public void delimiterValidate(String car) {
        for (char c : car.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                throw new IllegalArgumentException("',' 이외의 구분자를 사용할 수 없습니다.");
            }
        }
    }

    public void attemptValidate(int attempt) {
        if (attempt <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 0 이하가 될 수 없습니다.");
        }
    }
}
