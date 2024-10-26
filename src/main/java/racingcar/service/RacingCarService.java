package racingcar.service;

import racingcar.model.RacingCarModel;
import racingcar.util.RandomNumber;
import racingcar.validator.RacingCarValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarService {

    private final RacingCarModel racingCarModel; // 여기를 default로 바꿔서 서비스 분리?
    private String carNameString;
    private int racingAttemptCount;


    public RacingCarService(RacingCarModel racingCarModel){
        this.racingCarModel = racingCarModel;
    }

    public void inputRacingCarName(){
        carNameString = InputView.inputCarNameString();
    }

    public void passCarNameStringToModel(){
        racingCarModel.splitCarNameString(carNameString);
    }

    public void inputRacingAttemptsCount(){
        String racingAttemptCountString = InputView.inputRacingAttempts();
        racingAttemptCount = RacingCarValidator.canStringToInt(racingAttemptCountString);
    }

    public int getRacingAttemptsCount(){
        return racingAttemptCount;
    }


    public void startRacing(){
        List<String> carNameList = racingCarModel.getCarNameList();
        for (String car : carNameList) {
            int randomNumber = RandomNumber.createRandomNumber();
            if (RacingCarValidator.canForward(randomNumber)){
                racingCarModel.updateCarMap(car);
            }
        }
        printRacingResult();
        //printRacingResult(racingResult);
        //printRacingResult(racingResult);
    }

//    private void printRacingResult(String racingResult){
//        OutputView.printRacingResult(racingResult);
//    }

    public void printWinnerResult(){
        String winnerResult = createWinnerResult();
        OutputView.printWinner(winnerResult);
    }


    public void printRacingResult(){
        List<String> carNameList = racingCarModel.getCarNameList();

        for (String carName : carNameList) {
            Integer forwardCount = racingCarModel.getForwardCount(carName);
            String forwardExpression = "-".repeat(forwardCount);
            String racingResult = carName + " : " + forwardExpression + "\n";
            //printRacingResult(racingResult);
            OutputView.printRacingResult(racingResult);
        }
    }


    public String createWinnerResult(){
        List<String> winnerList = racingCarModel.getWinnerList();
        return String.join(", ", winnerList);
    }
}
