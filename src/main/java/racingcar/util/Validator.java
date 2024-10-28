package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {

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
}
