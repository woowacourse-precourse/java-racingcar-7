package racingcar.domain;

import java.util.List;

public class Cars {

    public Cars(List<String> carNames) {
        validateProcess(carNames);
    }

    private void validateProcess(List<String> carNames) {
        validateCarNameLength(carNames);
    }

    private void validateCarNameLength(List<String> carNames) {
        for(String carName : carNames) {
            if(carName.isBlank()) {
                throw new IllegalArgumentException();
            }
            if(carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
