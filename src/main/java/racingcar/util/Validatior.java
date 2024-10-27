package racingcar.util;

public class Validatior {

    public static void isInteger(int num){
        if (num <= 0) {
            throw new IllegalArgumentException("이동 횟수가 올바르지 않습니다.");
        }
    }
}
