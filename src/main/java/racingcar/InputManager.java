package racingcar;

import camp.nextstep.edu.missionutils.Console;
import exceptor.ExceptionHandler;

public class InputManager {
    public static final String RACING_CAR_INPUT_MASSEAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String RACING_TRIAL_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static String inputPlayerNameGroup(){
        System.out.println(RACING_CAR_INPUT_MASSEAGE);
        return Console.readLine();
    }

    public static int inputPlayerTurn(){
        System.out.println(RACING_TRIAL_INPUT_MESSAGE);
        String turn = Console.readLine();
        ExceptionHandler.detectInvalidPlayerTurn(turn);
        return Integer.parseInt(turn);
    }
}
