package racingcar;

import racingcar.controller.IndexController;
import racingcar.controller.RaceController;
import racingcar.domain.Cars;
import racingcar.domain.dto.CarsSaveRequestDto;

/**
 * packageName    : racingcar
 * fileName       : main
 * author         : ehgur
 * date           : 2024-10-25
 * description    : api 호출 및 동작 과정을 표현
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-25         ehgur          사용자 역할
 */

public class Application {
    public static void main(String[] args) {
        final IndexController indexController = IndexController.getInstance();
        final RaceController raceController = RaceController.getInstance();

        // 1. 사용자에게 자동차 이름 입력 화면을 보여주고 입력받음
        CarsSaveRequestDto requestDto = indexController.displayCarsNameInputPage();

        // 2.요청 정보 레포지토리에 저장
        raceController.saveAll(requestDto);

        // 3. 시도할 횟수 입력하라는 화면 보여주고 입력받음
        int lap = indexController.displayRaceLapInputPage();

        // 4. 레이스 시작 후 차수별 실행결과 출력




        // 6. 우승자 보여주기
    }
}
