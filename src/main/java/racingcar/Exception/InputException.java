package racingcar.Exception;

public class InputException {

    public static void (int round) {
        if (round < 0) {
            throw new IllegalArgumentException("실행 횟수는 양수만 가능합니다..");
        }
    }

    public static void checkCarNames(String carNames) {
        String[] names = carNames.split(",");
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 다섯 자 이하만 가능합니다.");
            }
        }
    }
}
