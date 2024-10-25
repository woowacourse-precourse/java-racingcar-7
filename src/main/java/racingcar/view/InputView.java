package racingcar.view;

import static racingcar.service.InputService.isCorrectInput;
import static racingcar.service.InputService.isTheLengthOfStringLessThanFive;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Input;

public class InputView {

    public static void getUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Input input = new Input(Console.readLine());

        if (isCorrectInput(input.getInput())) {
            isTheLengthOfStringLessThanFive(input.getInput());
        }
        else throw new IllegalArgumentException("잘못된 입력입니다.");
    }




}
