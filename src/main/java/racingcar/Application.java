package racingcar;

public class Application {
    public static void main(String[] args) {
        OperationManager operationManager = new OperationManager();
        operationManager.initProgram();
        operationManager.execute();
    }
}
