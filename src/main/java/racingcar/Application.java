package racingcar;

import racingcar.util.InputHandler;
import racingcar.util.OutputHandler;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        try{
            String names = inputHandler.getCarsName();
            String count = inputHandler.getTryCount();
            String[] results = {"cobi", "yuna"}; // 임의로 설정을 해두기
            outputHandler.printResult(results);

        }catch(IllegalArgumentException e){
            outputHandler.printError(e.getMessage());
            throw e;
        }
    }
}
