package racingcar.util;

public class Validatior {

    public static void isInteger(int num){
        if (num <= 0) {
            throw new IllegalArgumentException("이동 횟수가 올바르지 않습니다.");
        }
    }

    public static void checkCarNames(String[] carNames){
        for (String carName : carNames) {
            checkLength(carName);
        }
    }

    private static void checkLength(String carName) {
        if(carName.length() > 5){
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하여야 합니다.");
        }
    }
}
