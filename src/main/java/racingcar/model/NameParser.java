package racingcar.model;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameParser {

    private final List<String> names;
    private final String regex = "[^a-zA-Z,]";

    public NameParser(String inputName) {
        this.names = splitName(inputName);
    }

    private List<String> splitName(String inputName) {
        validateSeparator(inputName);
        return List.of(inputName.split(","));
    }

    private void validateSeparator(String inputName) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputName);
        if (matcher.find()) {
            throw new IllegalArgumentException("알파벳과 구분자 , 를 제외한 문자가 들어가있습니다!");
        }
    }

    public List<String> getNames() {
        return names;
    }
}
