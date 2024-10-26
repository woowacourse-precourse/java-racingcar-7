package racingcar.controller;

import racingcar.business.CarRacingService;
import racingcar.object.value.CarNames;
import racingcar.object.value.CarRacingResult;
import racingcar.object.value.TotalLapCount;
import racingcar.view.RacingInput;
import racingcar.view.RacingOutput;

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
