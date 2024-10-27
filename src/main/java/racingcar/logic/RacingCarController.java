package racingcar.logic;

import java.util.HashMap;
import java.util.List;
import racingcar.io.Input;
import racingcar.io.Output;
import racingcar.message.Message;

public class RacingCarController {

    Input input = new Input();
    Output output = new Output();
    RacingCarService racingCarService = new RacingCarService();

    String carList;
    Integer attemptCount;
    HashMap<String, Integer> result;

    public void run() {
        start();
        progress();
        end();
    }

    private void start() {

        carList = input.getCarList();
        attemptCount = input.getAttemptCount();
    }

    private void progress() {

        result = racingCarService.saveCars(carList);

        System.out.println(String.format(Message.OUTPUT_ATTEMPT_RESULT.getMessage()));
        for (int i = 0; i < attemptCount; i++) {
            result = racingCarService.saveResult(result);
            output.printResult(result);
        }
    }

    private void end() {

        List<String> winners = racingCarService.findWinner(result);
        winners = racingCarService.postWinnerProcess(winners); // 이렇게 덮어씌워도 괜찮을까?
        output.printWinner(winners);
    }
}
