package racingcar.model.car;

import racingcar.model.util.Parser;

import java.util.Arrays;
import java.util.List;

public class CarNameParser implements Parser<String, List<String>> {

    @Override
    public List<String> parse(String givenInput){
        String[] carNames = givenInput.split(",");
        return Arrays.stream(carNames).map(name -> validate(name.trim())).toList();
    }

    private String validate(String given){
        if (given.length() < 1 || given.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 1자 이상, 5자 이하로 구성되어야 합니다. 현재 값: " + given);
        }
        return given;
    }
}
