package racingcar;

public class Application {
    private UserInput userInput;

    public Application() {
        this.userInput = new UserInput();
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        this.userInput.run();
    }


}
