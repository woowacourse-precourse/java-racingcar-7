package racingcar.service;

import java.util.*;

public class CarNameProcessor {

    public static final String REGEXP_PATTERN_CHAR = "^[a-z|A-Z]+(,[A-Za-z]+)*$";

    public boolean isValid(String input){

        if (input == null || input.isEmpty()){
            return false;
        }

        if (!input.matches(REGEXP_PATTERN_CHAR)) {
            return false;
        }

        String[] carNames = input.split(",");
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(carNames));
        if (carNames.length != uniqueNames.size()){
            return false;
        }

        return true;
    }

    public List<String> parseCarNames(String input){

        if(isValid(input)){
            return new ArrayList<>(Arrays.asList(input.split(",")));
        }
        throw new IllegalArgumentException("잘못된 입력입니다.(자동차의 중복은 허용하지 않습니다.) " + input);
    }
}