package racingcar.service;

import racingcar.model.RacingCarModel;
import racingcar.util.RandomNumber;
import racingcar.validator.RacingCarValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarService {
    private final RacingCarModel racingCarModel;
    private final ResultGeneratorService resultGeneratorService;

    private int racingAttemptCount;
    private List<String> carNameList;
    private List<String> winnerList;


    public RacingCarService(RacingCarModel racingCarModel, ResultGeneratorService resultGeneratorService){
        this.racingCarModel = racingCarModel;
        this.resultGeneratorService = resultGeneratorService;
    }


    public void startRacing(){
        carNameList.stream()
                .filter(carName -> RacingCarValidator.canForward(getRandomNumber()))
                .forEach(racingCarModel::updateCarMap);

        String racingResult = getRacingResult();
        printRacingResult(racingResult);
    }


    private int getRandomNumber(){
        return RandomNumber.createRandomNumber();
    }


    public void initializeCarHashMap(){
        racingCarModel.setCarHashMap();
    }


    public String inputRacingCarName(){
        return InputView.inputCarNameString();
    }


    public void inputRacingAttemptsCount(){
        String racingAttemptCountString = InputView.inputRacingAttempts();
        setRacingAttemptCount(racingAttemptCountString);
    }


    private void setRacingAttemptCount(String racingAttemptCountString){
        racingAttemptCount = RacingCarValidator.validateRacingAttemptCount(racingAttemptCountString);
    }


    public void updateCarNameListInModel(String carNameString){
        racingCarModel.setCarNameList(carNameString);
        setCarNameList();
    }


    public void setCarNameList(){
        carNameList = racingCarModel.getCarNameList();
    }


    public int getRacingAttemptsCount(){
        return racingAttemptCount;
    }


    public void printWinnerResult(){
        setWinnerList();
        String winnerResultString = resultGeneratorService.generateWinnerResult(winnerList);
        OutputView.printWinner(winnerResultString);
    }


    private void setWinnerList(){
        winnerList = racingCarModel.getWinnerList();
    }


    public String getRacingResult() {
        return carNameList.stream()
                .map(carName -> {
                    int forwardCount = racingCarModel.getForwardCount(carName);
                    return resultGeneratorService.generateRacingResult(carName, forwardCount);
                })
                .collect(Collectors.joining("\n"));
    }


    public void printRacingResult(String racingResult){
        OutputView.printRacingResult(racingResult);
        System.out.println();
    }


}
