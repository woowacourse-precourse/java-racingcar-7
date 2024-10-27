package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            InputReader inputReader = new InputReader();
            List<String> carNames = inputReader.readCarNames();
            int tryCount = inputReader.readTryCount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
