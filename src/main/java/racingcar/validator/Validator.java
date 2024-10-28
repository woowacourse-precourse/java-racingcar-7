package racingcar.validator;

public class Validator {

    public Boolean carNameLengthValidate(String car) {

        if(car.length() > 5) {
            return false;
        } else {
            return true;
        }
    }

    public void carNameEmptyValidate(String car) {
        if (car.isBlank()) {
            throw new IllegalArgumentException("레이싱카 이름은 공백일 수 없습니다.");
        }
    }

    // ','가 아닌 다른 것으로 구분되어 있을 경우
    public Boolean delimiterValidate(String car) {
        for (char c : car.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public Boolean attemptValidate(int attempt) {
        return attempt >= 1;
    }
}
