package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.GameInput;
import racingcar.service.GamePhase;
import racingcar.service.NameValidator;

import java.util.List;

public class Game {
    private final GameInput gameInput;
    private final NameValidator nameValidator;
    private final GamePhase gamePhase;
    List<Car> carList;

    public Game(GameInput gameInput, NameValidator nameValidator, GamePhase gamePhase) {
        this.gameInput = gameInput;
        this.nameValidator = nameValidator;
        this.gamePhase = gamePhase;
    }

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 심표(,) 기준으로 구분)");
        registerCars();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int turn = gameInput.getTurn();

        System.out.println("\n실행 결과");
        while(turn-- > 0) {
            gamePhase.advanceTheGamePhase();
            System.out.println();
        }

        System.out.print("최종 우승자 : ");
        gamePhase.showWinners();
    }

    private void registerCars() {
        String input = gameInput.getInput();
        carList = nameValidator.separatePlayerList(input);
        gamePhase.registerList(carList);
    }
}
