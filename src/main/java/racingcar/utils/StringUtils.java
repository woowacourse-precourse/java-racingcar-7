package racingcar.utils;

public class StringUtils {
    public String[] separateName(String nameString) {
        try {
            String[] nameList = nameString.split(",");
            for (String name : nameList) {
                nameValidation(name);
            }
            return nameList;
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }

    private void nameValidation(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("name is too long. ");
        }
    }
}
