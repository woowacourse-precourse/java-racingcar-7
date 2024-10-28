package racingcar;

public class Separator {
    private static final String TOKEN = ",";

    public String[] separate(String inputNames) {
        String[] names = inputNames.split(TOKEN);

        for (int i = 0; i < names.length; i++) {
            names[i] = checkNameLength(names[i].trim());
        }

        return names;
    }

    private String checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자를 넘길 수 없습니다");
        }

        return name;
    }
}
