package racingcar;

public class Application {

    public static void main(String[] args) {
        View view = new View();
        String str = view.inputString();
        Racing racing = new Racing(new InputString(str));
        int tryCount = view.inputTryCount();
        racing.start(tryCount);
    }
}

