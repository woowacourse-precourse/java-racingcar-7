package racingcar;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // 핸들러 인스턴스 생성
        InputHandler inputHandler = new InputHandler();
        MoveHandler moveHandler = new MoveHandler();
        ResultHandler resultHandler = new ResultHandler();

        // 사용자 입력 처리
        List<String> carNames = inputHandler.getCarNames();
        int attemptCount = inputHandler.getRaceAttemptCount();

        // 자동차 초기화
        List<Car> cars = inputHandler.initializeCars(carNames);

        // 지정된 시도 횟수만큼 경주 진행
        for (int i = 0; i < attemptCount; i++) {
            moveHandler.playRound(cars);
            resultHandler.printRoundResult(cars); // 매 라운드 결과 출력
        }

        // 최종 우승자 출력
        List<Car> winners = resultHandler.getWinners(cars);
        resultHandler.printWinners(winners);
    }
}
