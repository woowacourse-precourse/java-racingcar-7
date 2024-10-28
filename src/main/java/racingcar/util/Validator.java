package racingcar.util;

import java.util.regex.Pattern;

public class Validator {

    public void checkNameFormat(String input) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9,\\s가-힣ㄱ-ㅎㅏ-ㅣ]*$");
        if(!input.matches(pattern.pattern())) {
            throw new IllegalArgumentException("입력에 올 수 없는 문자가 포함되었습니다");
        }
    }
}
