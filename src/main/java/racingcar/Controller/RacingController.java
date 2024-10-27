package racingcar.Controller;

import racingcar.Model.Racing;
import racingcar.Validation.TurnCountValidator;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class RacingController {
    private Racing racing;

    public void startGame(){
        String carsName = InputView.readCarsName();
        int turnCount = TurnCountValidator.validateTurnCount(InputView.readTurnCount());
        OutputView.printGameResult(); //* 메서드 이름 수정 필요 */
        startRacing(carsName, turnCount);
        printWinner();
    }

    private void startRacing(String carsName, int turnCount){
        this.racing = Racing.startRacing(carsName);
        for (int i = 0; i < turnCount; i++){
            racing.runRound();
            OutputView.printResultOfTurn(racing.resultOfRound());
        } 
    }

    private void printWinner(){
        OutputView.printWinner(racing.pickWinner());
    }








}
