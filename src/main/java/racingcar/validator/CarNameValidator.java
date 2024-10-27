package racingcar.validator;

public class CarNameValidator {

    public boolean validate(String carName) {
        if (carName == null) {
            return false;
        }
        if (carName.trim().isEmpty()){
            return false;
        }
        if (carName.length() > 5) {
            return false;
        }
        return true;

    }
}
