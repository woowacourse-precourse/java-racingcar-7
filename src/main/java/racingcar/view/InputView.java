package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.RacingInput;

public class InputView {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT = "시도할 횟수는 몇 회인가요?";


    public RacingInput readRacingInput(){
        return new RacingInput(InputCars(),InputTryCount());
    }

    public String InputCars(){
        System.out.println(INPUT_CAR_NAME);
        String inputCarsName = Console.readLine();

        return inputCarsName;
    }

    public int InputTryCount(){
        System.out.println(INPUT_TRY_COUNT);
        int inputTryCount = Integer.parseInt(Console.readLine());

        return inputTryCount;
    }

}
