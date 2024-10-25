package racingcar.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarName {

    private final String name;
    private final int NAME_LIMIT_LENGTH = 5;
    private final String regex = "[^a-zA-Z]";

    public CarName(String name) {
        this.name = name;
        validateName();
    }

    private void validateName() {
        validateNameSize();
        validateNameNonEnglish();
    }

    private void validateNameSize() {
        if (name.length() > NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다!");
        }
    }

    private void validateNameNonEnglish() {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        if (matcher.find()) {
            throw new IllegalArgumentException("이름에는 영어를 제외한 다른 문자가 들어갈 수 없습니다!");
        }
    }

    public String getName() {
        return name;
    }
}
