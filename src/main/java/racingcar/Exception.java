package racingcar;

public class Exception {
    public static void carNames(String carName) {
        // 공백이 있거나 자동차 이름이 6글자 이상이면 예외 발생
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 공백입니다.");
        } else if (carName.length() >= 6) {
            throw new IllegalArgumentException("자동차 이름이 6글자 이상입니다.");
        }
    }

    public static int tryNumber(String number) {
        int tryNum = 0;
        if (number.matches("^[0-9]+$")) {
            tryNum = Integer.parseInt(number);  // String을 숫자로 변경
            if (tryNum == 0) {
                throw new IllegalArgumentException("1 이상의 숫자를 입력하세요.");
            }
        } else {
            throw new IllegalArgumentException("숫자가 아닙니다. 다시 입력하세요.");
        }
        return tryNum;
    }
}
