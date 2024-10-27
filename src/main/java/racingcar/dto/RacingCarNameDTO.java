package racingcar.dto;

import java.util.Arrays;
import java.util.List;

public class RacingCarNameDTO {
    private List<String> carNames;

    public RacingCarNameDTO(String carNamesInput){
        validateString(carNamesInput);
        this.carNames = Arrays.asList(carNamesInput.split(","));
    }

    private void validateString(String carNamesInput){
        if(carNamesInput == null || carNamesInput.trim().isEmpty())
            throw new IllegalArgumentException("자동차 이름을 입력해주세요");
    }

    private void validateCarNames(){

    }

    private void checkEmptyCarNames(){

    }
}