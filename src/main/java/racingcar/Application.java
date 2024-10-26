package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.business.CarRacingService;
import racingcar.object.carEngine.RegulationsCarEngine;
import racingcar.object.value.CarRacingResult;
import racingcar.view.RacingInput;
import racingcar.view.RacingOutput;

public class Application {

    public static void main(String[] args) {
        try {
            CarRacingService carRacingService = new CarRacingService(new RegulationsCarEngine());
            CarRacingResult carRacingResult = carRacingService.performCarRacing(
                    RacingInput.askCarNamesForParticipants(),
                    RacingInput.askTotalLapCount());

            RacingOutput.announceRaceDetails(carRacingResult.raceRecord());
            RacingOutput.announceRaceWinners(carRacingResult.winners());

        } catch (Error e) {
            e.printStackTrace();
            throw new IllegalArgumentException("예기치 못한 오류로 프로그램을 종료합니다.");
        } finally {
            Console.close();
        }
    }

}
