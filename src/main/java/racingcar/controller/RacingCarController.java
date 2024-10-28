package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.service.RacingCarService;
import racingcar.util.StringUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.LinkedList;
import java.util.List;

public class RacingCarController {
    private final static String DELIMITER = ",";

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    private final List<RacingCar> racingCarList;

    public RacingCarController(InputView inputView, OutputView outputView, RacingCarService racingCarService){
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
        this.racingCarList = new LinkedList<>();
    }

    public void run(){
        outputView.printCarNameRequest();
        racingCarService.registerRacingCars(racingCarList, StringUtil.splitNames(inputView.getLine(), DELIMITER));
        outputView.printRaceCountRequest();
        int tryCount = StringUtil.parsePositiveNumber(inputView.getLine());
        outputView.printRacingStartMessage();
        for(int i=0; i<tryCount;i++){
            racingCarService.racingGame(racingCarList);
            outputView.printRacingStatus(racingCarList);
        }


    }

}
