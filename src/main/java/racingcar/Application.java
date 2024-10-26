package racingcar;

public class Application {
    public static void main(String[] args) {

        IOController ioController = new IOController();
        Parser parser = new Parser();
        Validator validator = new Validator();

        Executor executor = new Executor(ioController, parser, validator);

        executor.run();
    }
}
