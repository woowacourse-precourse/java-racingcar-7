package racingcar;

public class RacingNum {
    public static int numValid (String inputNumber){
        try {
            int racingNumber = Integer.parseInt(inputNumber);
            if (racingNumber <= 0) {
                throw new IllegalArgumentException("시도할 횟수는 0보다 큰 정수이어야 합니다.");
            }
            return racingNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 정수로 입력되어야 합니다.");
        }
    }
}
