package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Controller.ForwardController;

import java.util.List;

public class InputView {
    public static List<ForwardController> getCars(){
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        return List.of(input.split(",")).stream()
                .map(String::trim)
                .map(ForwardController::new)
                .toList();
    }

    public static int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
    }
}
