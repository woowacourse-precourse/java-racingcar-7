package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            // 입력 처리
            List<String> carNames = InputView.getCarNames();
            int attempts = InputView.getRaceAttempts();

            // 자동차 객체 생성
            List<Car> cars = carNames.stream()
                    .map(Car::new)
                    .collect(Collectors.toList());

            // 이동 전략 설정
            MoveStrategy moveStrategy = new RandomMoveStrategy();

            // 게임 컨트롤러 생성 및 경주 시작
            GameController gameController = new GameController(cars, moveStrategy);
            gameController.startRace(attempts);
        } finally {
            // 리소스 해제
            camp.nextstep.edu.missionutils.Console.close();
        }
    }
}