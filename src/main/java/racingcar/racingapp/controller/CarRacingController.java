package racingcar.racingapp.controller;

import racingcar.racingapp.business.CarRacingService;
import racingcar.racingapp.model.value.vo.CarNames;
import racingcar.racingapp.model.value.vo.CarRacingResult;
import racingcar.racingapp.model.value.vo.TotalLapCount;
import racingcar.racingapp.view.RacingInput;
import racingcar.racingapp.view.RacingOutput;

public class CarRacingController {

    private final CarRacingService carRacingService;

    public CarRacingController(CarRacingService carRacingService) {
        this.carRacingService = carRacingService;
    }

    public void doHandleCarRacing() {
        RaceInputData raceInputData = prepareRaceData();

        CarRacingResult carRacingResult = carRacingService.performCarRacing(
                raceInputData.carNamesForParticipants(),
                raceInputData.lapCountForRace());

        followUpForRace(carRacingResult);
    }

    private static RaceInputData prepareRaceData() {
        CarNames carNamesForParticipants = RacingInput.askCarNamesForParticipants();
        TotalLapCount lapCountForRace = RacingInput.askTotalLapCount();
        return new RaceInputData(carNamesForParticipants, lapCountForRace);
    }

    private static void followUpForRace(CarRacingResult carRacingResult) {
        RacingOutput.announceRaceDetails(carRacingResult.raceRecord());
        RacingOutput.announceRaceWinners(carRacingResult.winners());
    }

    private record RaceInputData(CarNames carNamesForParticipants, TotalLapCount lapCountForRace) {

    }

}
