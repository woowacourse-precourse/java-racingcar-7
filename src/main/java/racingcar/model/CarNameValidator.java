package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarNameValidator {
    public void validate(String[] carNames){
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
