package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.racingapp.business.CarRacingService;
import racingcar.racingapp.controller.CarRacingController;
import racingcar.racingapp.model.car.carEngine.RegulationsCarEngine;

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
