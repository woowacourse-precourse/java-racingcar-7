package racingcar;

import java.util.List;
import racingcar.controller.IndexController;
import racingcar.controller.RaceController;
import racingcar.domain.Car;
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

        // 2. 요청받은 자동차 이름들 유효성 검사
        raceController.isCarNameValid(requestDto);

        // 3. 유효성 검사 통과 후 toEntity 로 Car 객체로 변환해서 레포에 저장

        // 4. 시도할 횟수 입력하라는 화면 보여주고 입력받음

        // 5. 입력받은 Lap 횟수만큼 랜덤값 돌리고 나온 값에 따라 car 객체에 정보 업데이트
        //    차수별 실행 결과 출력

        // 6. 우승자 보여주기
    }
}
