package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();

        // 1. 자동차 이름과 경주 시도 횟수를 입력받기
        List<String> carNames = carRacing.getCarNames();
        int attempts = carRacing.getRaceAttempts();

        // 2. 입력받은 자동차 이름 유효성 검사 및 초기화
        carRacing.validateCarNames(carNames);
        carRacing.initializeCars(carNames);

        // 3. 경주 시작 및 각 회차별 결과 출력
        carRacing.startRace(attempts);

        // 4. 최종 우승자 출력
        carRacing.printWinners();
    }
}
