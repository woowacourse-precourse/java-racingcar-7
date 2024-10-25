package racingcar;

public class InvalidException {
    public static void checkNamelength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("5글자 이하의 이름을 입력하세요.");
        }
    }

    public static void checkRound(String strRound) {
        int check;
        try {
            check = Integer.parseInt(strRound);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }

        if (check <= 0) {
            throw new IllegalArgumentException("0보다 큰 정수를 입력하세요");
        }

        if (((check * 10) % 10) != 0) {
            throw new IllegalArgumentException("소수 말고 정수를 입력해야 합니다.");
        }
    }
}

