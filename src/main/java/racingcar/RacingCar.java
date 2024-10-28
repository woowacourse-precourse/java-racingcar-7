package racingcar;

import java.util.Map;

public class RacingCar {

    private RacingCar() {
    }

    public static void startRace() {
        final UserRaceSettingDto userRaceSettingDto = CarRaceView.receiveRaceInfoFromUser();
        final Map<String, Integer> raceStatus = CarRaceProcessor.setUpRacingCars(
                userRaceSettingDto.carNames());
        for (int raceCount = 0; raceCount < userRaceSettingDto.tryRace(); raceCount++) {
            CarRaceView.displayRaceStatus(CarRaceProcessor.runSingleRound(raceStatus));
        }
        CarRaceView.displayWinningCar(CarRaceProcessor.getWinners(raceStatus));
    }
}
