package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.RaceController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();
        RaceController raceController = appConfig.getRaceController();
        raceController.run();
    }
    //TODO: 인스턴스 초기화 기능 넣어서 테스트 전후로 호출하기
}
