package racingcar.validator;

public class Validator {

    public Boolean carNameLengthValidate(String carName) {

        if(carName.length() >= 5) {
            return false;
        } else {
            return true;
        }
    }
}
