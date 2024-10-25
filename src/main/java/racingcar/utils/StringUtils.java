package racingcar.utils;

public class StringUtils {
    public String[] separateName(String nameString) {
        try {
            return nameString.split(",");
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }
}
