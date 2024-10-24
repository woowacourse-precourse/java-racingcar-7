package racingcar;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();  // 인스턴스 네이밍
        List<String> carNames = userInput.readCarNames();
    }
}
