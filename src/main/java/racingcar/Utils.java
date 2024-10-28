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

    static int getTryCountFromString(String count) {
        if (count == null || count.isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 시도 횟수 입니다.");
        }
        try {
            return Integer.parseInt(count); // 정수와 실수 모두 처리
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자 형태의 입력만 가능합니다. ");
        }
    }
}
