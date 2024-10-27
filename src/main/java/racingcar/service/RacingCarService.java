package racingcar.service;

import racingcar.model.RacingCarModel;
import racingcar.util.RandomNumber;
import racingcar.validator.RacingCarValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarService {
    private final RacingCarModel racingCarModel;
    private String carNameString;
    private int racingAttemptCount;
    private String winnerResultString;


    public RacingCarService(RacingCarModel racingCarModel){
        this.racingCarModel = racingCarModel;
    }


    public void inputRacingCarName(){
        carNameString = InputView.inputCarNameString();
    }


    public void inputRacingAttemptsCount(){
        String racingAttemptCountString = InputView.inputRacingAttempts();
        setRacingAttemptCount(racingAttemptCountString);
    }


    private void setRacingAttemptCount(String racingAttemptCountString){
        racingAttemptCount = RacingCarValidator.validateRacingAttemptCount(racingAttemptCountString);
    }


    public void passCarNameStringToModel(){
        racingCarModel.setCarNameList(carNameString);
    }


    public int getRacingAttemptsCount(){
        return racingAttemptCount;
    }


    public void startRacing(){
        List<String> carNameList = racingCarModel.getCarNameList();
        racingCarModel.setCarHashMap();
        carNameList.stream()
                .filter(carName -> RacingCarValidator.canForward(RandomNumber.createRandomNumber()))
                .forEach(racingCarModel::updateCarMap);

        printRacingResult();
    }


    public void printWinnerResult(){
        setWinnerResultString();
        OutputView.printWinner(winnerResultString);
    }


    public void setWinnerResultString(){
        List<String> winnerList = racingCarModel.getWinnerList();
        winnerResultString = String.join(", ", winnerList);
    }


    public void printRacingResult(){
        List<String> carNameList = racingCarModel.getCarNameList();
        carNameList.stream()
                .map(carName ->{
                    int forwardCount = racingCarModel.getForwardCount(carName);
                    String forwardExpression = "-".repeat(forwardCount);
                    return carName + " : " + forwardExpression + "\n";
                })
                .forEach(OutputView::printRacingResult);

        System.out.println();
    }


}
