package racingcar;

import racingcar.controller.CarController;
import racingcar.controller.RaceController;

/**
 * packageName    : racingcar
 * fileName       : main
 * author         : ehgur
 * date           : 2024-10-27
 * description    : api 호출 및 동작 과정을 표현
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-25         ehgur           사용자 역할
 */

public class Application {

    private static final int RACE_ID = 0; // 현재는 레이스가 1개이기 때문에 0으로 고정

    public static void main(String[] args) {
        final CarController carController = CarController.getInstance();
        final RaceController raceController = RaceController.getInstance();

        // 1. 사용자에게 자동차 이름 입력 화면을 보여주고 입력받음
        carController.displayCarsNameInputPage();

        // 2. 사용자에게 몇 바퀴 돌건지 입력하라는 화면 보여주고 입력받음
        raceController.displayRaceLapInputPage();

        // 3. 레이스 시작 후 Lap 별 결과 출력
        raceController.raceStartById(RACE_ID);
    }
}
