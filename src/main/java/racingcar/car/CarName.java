package racingcar.car;

import static racingcar.car.policy.CarNamePolicy.*;
import racingcar.car.exception.CarNameException.NameLengthExceededException;
import racingcar.car.exception.CarNameException.NameLengthShortException;

public class CarName {
    private final String value;

    public CarName(String name) {
       validateLength(name);
       this.value = name;
    }

    public static CarName createCarName(String name) {
        return new CarName(name);
    }

    public String getValue() {
        return this.value;
    }

    private void validateLength(String name){
        validateMinLength(name);
        validateMaxLength(name);
    }

    private void validateMinLength(String name){
        if(name.length()<MIN_LENGTH){
            throw new NameLengthShortException();
        }
    }

    private void validateMaxLength(String name){
        if(name.length()> MAX_LENGTH){
            throw new NameLengthExceededException();
        }
    }
}
