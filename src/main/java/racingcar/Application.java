package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.business.CarRacingService;
import racingcar.controller.CarRacingController;
import racingcar.object.carEngine.RegulationsCarEngine;

public class Application {

    public static void main(String[] args) {
        try {
            CarRacingController raceHandler = new CarRacingController(new CarRacingService(new RegulationsCarEngine()));
            raceHandler.doHandleCarRacing();
        } catch (Error e) {
            e.printStackTrace();
            throw new IllegalArgumentException("예기치 못한 오류로 프로그램을 종료합니다.");
        } finally {
            Console.close();
        }
    }

}
