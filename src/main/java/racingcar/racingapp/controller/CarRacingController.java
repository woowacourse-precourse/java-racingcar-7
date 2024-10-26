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
        DataForCarRacing requiredDataForRacing = prepareRaceData();

        CarRacingResult carRacingResult = carRacingService.performCarRacing(
                requiredDataForRacing.carNamesForParticipants(),
                requiredDataForRacing.lapCountForRace());

        followUpForRace(carRacingResult);
    }

    private static DataForCarRacing prepareRaceData() {
        CarNames carNamesForParticipants = RacingInput.askCarNamesForParticipants();
        TotalLapCount lapCountForRace = RacingInput.askTotalLapCount();
        return new DataForCarRacing(carNamesForParticipants, lapCountForRace);
    }

    private static void followUpForRace(CarRacingResult carRacingResult) {
        RacingOutput.announceRaceDetails(carRacingResult.raceRecord());
        RacingOutput.announceRaceWinners(carRacingResult.winners());
    }

    private record DataForCarRacing(CarNames carNamesForParticipants, TotalLapCount lapCountForRace) {

    }

}
