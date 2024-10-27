package racingcar.controller;

import java.util.List;
import racingcar.dto.RacingCarInfoDto;
import racingcar.model.RaceStadium;
import racingcar.model.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class RacingController {

    private RaceStadium raceStadium;
    private InputView inputView;
    private OutputView outputView;


    // Private constructor to enforce controlled instantiation
    private RacingController(RaceStadium raceStadium,
                             InputView inputView, OutputView outputView) {
        this.raceStadium = raceStadium;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    // Static factory method
    public static RacingController of(RaceStadium raceStadium, InputView inputView, OutputView outputView) {
        return new RacingController(raceStadium , inputView, outputView);
    }

    public void startRacing(){
        List<String> carNameList = inputView.getNameList();
        int round = inputView.getRound();
        List<RacingCar> racingCarList = carNameList
                .stream()
                .map(RacingCar::new)
                .toList();
        raceStadium.addRacingCars(racingCarList);

        System.out.println("\n실행 결과");
        for(int i=0; i<round; i++){
            raceStadium.moveRacingCars();

            List<RacingCarInfoDto> racingCarPresentInfo = racingCarList
                    .stream()
                    .map(racingCar -> RacingCarInfoDto.of(racingCar.name, racingCar.getMovedDistance()))
                    .toList();
            outputView.printRoundResult(racingCarPresentInfo);
        }

        outputView.printWinners(raceStadium.getWinnerList());
    }

}
