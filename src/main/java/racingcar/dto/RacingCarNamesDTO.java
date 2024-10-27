package racingcar.dto;

import java.util.Arrays;
import java.util.List;

public class RacingCarNamesDTO {
    private List<String> carNames;

    public RacingCarNamesDTO(String carNamesInput){
        validateCarNamesInputString(carNamesInput);
        this.carNames = Arrays.asList(carNamesInput.split(","));
        validateNonEmptyCarNames();
        validateMinimumCarCount();
    }

    private void validateCarNamesInputString(String carNamesInput){
        if(isBlank(carNamesInput))
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다");
    }

    private void validateNonEmptyCarNames(){
        for(String carName : carNames){
            if(isBlank(carName))
                throw new IllegalArgumentException("자동차 이름은 비어 있거나 공백일 수 없습니다.");
        }
    }

    private void validateMinimumCarCount(){
        if(carNames.size() < 2)
            throw new IllegalArgumentException("경주할 자동차는 두 대 이상 입력해야 합니다.");
    }

    private boolean isBlank(String inputString){
        return inputString == null || inputString.trim().isEmpty();
    }

    public List<String> getCarNames() {
        return carNames;
    }
}