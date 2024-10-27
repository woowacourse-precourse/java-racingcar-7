package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            // 사용자 입력 처리
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)로 구분): ");
            List<String> carNames = InputHandler.getCarNames(Console.readLine());

            System.out.println("시도할 횟수를 입력하세요: ");
            int attempts = InputHandler.getRaceAttempts(Console.readLine());

            // 자동차 객체 생성
            List<Car> cars = carNames.stream()
                    .map(Car::new)
                    .collect(Collectors.toList());

            // 이동 전략 설정
            MoveStrategy moveStrategy = new RandomMoveStrategy();

            // 게임 컨트롤러 생성 및 경주 시작
            GameController gameController = new GameController(cars, moveStrategy);
            gameController.startRace(attempts);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}