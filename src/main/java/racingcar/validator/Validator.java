package racingcar.validator;

public class Validator {

    public Boolean carNameLengthValidate(String car) {

        if(car.length() > 5) {
            return false;
        } else {
            return true;
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


}
