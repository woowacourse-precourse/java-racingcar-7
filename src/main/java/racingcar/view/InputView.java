package racingcar.view;

import static racingcar.service.InputService.isCorrectInput;
import static racingcar.service.InputService.isTheLengthOfStringLessThanFive;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Game;
import racingcar.domain.Input;
import racingcar.service.GameService;

public class InputView {

    private static Input input = new Input("", 0);

    private static Game game = new Game();
    static GameService gameService;


    public static void getStringInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String names = Console.readLine();
        input.setNames(names);

        if (isCorrectInput(input.getNames())) {
            isTheLengthOfStringLessThanFive(input.getNames());
        } else throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    public static void getCountInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(Console.readLine());
        input.setCount(count);

        gameService = new GameService(input, game);
        gameService.addCarName();
    }




}
