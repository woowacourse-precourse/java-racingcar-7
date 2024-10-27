package racingcar;

public class Application {

    public static void main(String[] args) {
        Input input = new Input();

        Racing racing = new Racing(input);
        racing.ready();
    }
}
