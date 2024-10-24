package racingcar.car;

import racingcar.car.exception.CarNameException.EmptyNameException;
import racingcar.car.exception.CarNameException.NameLengthExceededException;

public class CarName {
    private final String value;

    public CarName(String name) {
        if(name.length()>10){
                throw new NameLengthExceededException();
        }
        if(name.length()<1){
                throw new EmptyNameException();
        }
        this.value = name;
    }

    public static CarName createCarName(String name) {
        return new CarName(name);
    }


    public String getValue() {
        return this.value;
    }
}
