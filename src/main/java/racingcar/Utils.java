package racingcar;

public class Utils {
    static String[] getNamesFromString(String names) {
        names = names.replaceAll(" ", "");
        String[] nameArray = names.split(",");

        if (nameArray.length <= 1) {
            throw new IllegalArgumentException("유효하지 않은 자동차 이름입니다.");
        }

        for (String name : nameArray) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("유효하지 않은 자동차 이름입니다.");
            }
        }
        return nameArray;
    }
}
