package racingcar.service;

import java.util.*;

public class InputProcessor {

    public static final String REGEXP_PATTERN_CHAR = "^[a-z|A-Z]+(,[A-Za-z]+)*$";

    public boolean isValid(String input){

        if (input == null || input.isEmpty()){
            return false;
        }

        if (!input.matches(REGEXP_PATTERN_CHAR)) {
            return false;
        }

        // 자동차 이름 중복 검사
        String[] carNames = input.split(",");
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(carNames));
        if (carNames.length != uniqueNames.size()){
            return false;
        }

        // 각 자동차 이름의 길이가 5 이하인지 확인
        for (String name : carNames) {
            if (name.length() > 5) {
                return false;
            }
        }

        return true;
    }

    public void isValidRound(String input) {
        if (input == null || !input.matches("^[\\d]*$")) { // 숫자만 허용
            throw new IllegalArgumentException("잘못된 입력입니다.(라운드의 횟수는 정수입니다) " + input);
        }
    }

    public List<String> parseCarNames(String input){

        if(isValid(input)){
            return new ArrayList<>(Arrays.asList(input.split(",")));
        }
        throw new IllegalArgumentException("잘못된 입력입니다.(자동차의 중복은 허용하지 않습니다.) " + input);
    }
}