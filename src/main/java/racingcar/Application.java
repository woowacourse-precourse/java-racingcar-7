package racingcar;

public class Application {
    public static void main(String[] args) {
        try {
            String[] carNames = CarInput.inputCarNames();
            int moveCount = CarInput.inputMoveCount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
