package racingcar.model;

public class GameCountValidator {
    public static int validate(String gameCount) {
        int count;
        try {
            count = Integer.parseInt(gameCount);
            if (count <= 0) {
                throw new IllegalArgumentException("[ERROR] 시도할 횟수를 자연수(1~2,147,483,647)로 입력해 주세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수를 자연수(1~2,147,483,647)로 입력해 주세요.");
        }
        return count;
    }
}
