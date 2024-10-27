package racingcar;

public class Application {
    public static void main(String[] args) {

        IOController ioController = new IOController();
        Parser parser = new Parser();
        Validator validator = new Validator();
        Racing racing = new Racing();

        Executor executor = new Executor(ioController, parser, validator, racing);

        executor.run();
    }
}
