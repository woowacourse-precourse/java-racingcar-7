package racingcar.Controller;

import java.util.List;
import racingcar.Car;
import racingcar.service.MoveService;
import racingcar.view.GameView;
import racingcar.view.GetInputView;
import racingcar.view.GetOutputView;

public class MoveProcessController {

    private final MoveService moveService = new MoveService();
    private final GetInputView getInputView = new GetInputView();
    private final GetOutputView getOutputView = new GetOutputView();
    private final GameView gameView = new GameView();

    public void raceStart(){
        List<Car> cars = getInputView.getCars();
        int count = getInputView.getAttemptCount();
        moveProcess(count, cars);
        int maxmimudistance = moveService.checkMaximumMove(cars);

        List<String> winners =moveService.winnerSave(cars, maxmimudistance);

        getOutputView.getOutput(winners);
    }


    public void moveProcess(int count, List<Car> cars){
        for(int i=0; i<count; i++){
            moveControl(cars);
            gameView.LiveScore(cars);
        }
    }

    private void moveControl(List<Car> cars) {
        for (Car car : cars) {
            moveService.possibleMoveCheck(car);
        }
    }

}
