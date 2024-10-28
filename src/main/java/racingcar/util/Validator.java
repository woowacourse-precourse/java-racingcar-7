package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {

    public void checkInput(String input) {
        checkInputFormat(input);
        checkDuplicateName(input);
        checkNullName(input);
        checkNameLength(input);
        checkCarNum(input);
    }
    public void checkInputFormat(String input) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9,\\s가-힣ㄱ-ㅎㅏ-ㅣ]*$");
        if(!input.matches(pattern.pattern())) {
            throw new IllegalArgumentException("입력에 올 수 없는 문자가 포함되었습니다");
        }
    }

    public void checkDuplicateName(String input) {
        List<String> nameList = Arrays.stream(input.split(",")).map(String::strip).toList();
        Set<String> nameSet = new HashSet<>(nameList);
        if(nameList.size() != nameSet.size()) {
            throw new IllegalArgumentException("중복된 이름이 포함되었습니다.");
        }
    }

    public void checkNameLength(String input) {
        List<String> nameList = Arrays.stream(input.split(",")).map(String::strip).toList();
        for(String name : nameList) {
            if(name.length() > 5) {
                throw new IllegalArgumentException("이름의 길이가 5 초과입니다.");
            }
        }
    }

    public void checkNullName(String input) {
        List<String> nameList = Arrays.stream(input.split(",")).map(String::strip).toList();
        for(String name : nameList) {
            if(name.length() == 5) {
                throw new IllegalArgumentException("이름은 공백이 될 수 없습니다.");
            }
        }
    }

    public void checkCarNum(String input) {
        List<String> nameList = Arrays.stream(input.split(",")).map(String::strip).toList();
        if(nameList.size() < 2) {
            throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
        }
    }

    public void checkNumber(String input) {
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수에는 숫자만 올 수 있습니다.");
        }
    }

    public void checkPositiveNumber(String input) {
        if(Integer.parseInt(input) < 1) {
            throw new IllegalArgumentException("시도 횟수는 양수만 입력이 가능합니다.");
        }
    }

}
