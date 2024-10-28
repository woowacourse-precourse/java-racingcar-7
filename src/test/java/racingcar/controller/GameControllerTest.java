package racingcar.controller;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;


class GameControllerTest {
    private Validator validator;
    private GameController controller;
    private InputView inputView;
    private OutputView outputView;

    @BeforeEach
    void setUp() {
        validator = new Validator();

        // InputView에 테스트용 입력값을 설정할 수 있도록 상속하여 생성
        inputView = new InputView() {
            @Override
            public String inputCarNames() {
                return "car1,car2,car3";
            }

            @Override
            public String inputTryCount() {
                return "3";
            }
        };

        // OutputView에 필요한 출력 처리 메서드 오버라이드
        outputView = new OutputView() {
            @Override
            public void printRoundResult(List<Car> cars) {
                cars.forEach(car -> System.out.println(car.getName() + " : " + "-".repeat(car.getPosition())));
            }

            @Override
            public void printWinners(List<Car> winners) {
                winners.forEach(winner -> System.out.println("최종 우승자 : " + winner.getName()));
            }
        };

        controller = new GameController(validator, inputView, outputView);
    }

    @Test
    @DisplayName("게임 컨트롤러에서 자동차 이름 파싱 및 검증")
    void startGameCarNamesTest() {
        // startGame()을 호출하여 설정된 입력을 처리하고 결과가 출력되는지 확인
        controller.startGame();
    }
}
