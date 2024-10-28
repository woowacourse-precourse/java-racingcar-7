package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.utils.CustomException;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingCarController {
    private final Input input;
    private final Output output;


    public RacingCarController(Input input, Output output) {
        this.input = new Input();
        this.output = new Output();
    }

    public void startGame() {
        try {
            // 자동차 이름 입력 및 유효성 검사
            List<String> carNames = input.getCarName();
            // 시도 횟수 입력 및 유효성 검사
            int tryCount = input.getRound();
            List<Car> carList = carNames.stream()
                    .map(Car::new)  // 각 이름을 기반으로 Car 객체 생성
                    .collect(Collectors.toList());

            // 게임 객체 초기화
            Cars cars = new Cars(carList);
            RacingGame game = new RacingGame(cars, tryCount);

            // 실행 결과 안내 출력
            output.printExecutionResult();

            // 게임 플레이 및 차수별 결과 출력
            game.play(() -> output.printRoundResult(cars));

            // 최종 우승자 출력
            output.printWinners(game.getWinners());

        } catch (IllegalArgumentException | CustomException e) {
            System.out.println(e.getMessage());
            // 예외 발생 시 프로그램을 종료하거나 필요한 예외 처리를 수행합니다.
        }
    }
}
