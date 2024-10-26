package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputRacingCarView {
    private static final String CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_MOVE_COUNT_INPUT = "시도할 횟수는 몇 회인가요?";

    public String inputCarName() {
        System.out.println(CAR_NAME_INPUT);
        try{
            String input = Console.readLine();
            return input;
        }
        finally {
            Console.close();
        }
    }

    public String inputCarMoveCount() {
        System.out.println(CAR_MOVE_COUNT_INPUT);
        try {
            String input = Console.readLine();
            return input;
        }
        finally {
            Console.close();
        }
    }

}
