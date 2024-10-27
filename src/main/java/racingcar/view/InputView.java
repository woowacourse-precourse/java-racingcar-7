package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.CarNameValidation;
import racingcar.validation.CountValidation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private final CarNameValidation carNameValidation = new CarNameValidation();
    private final CountValidation countValidation = new CountValidation();

    public List<String> inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();

        String[] carNames = userInput.split(",");
        List<String> carNameList = Arrays.asList(carNames);

        carNameValidation.validateCarNames(carNameList);

        return carNameList;
    }

    public int inputCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(Console.readLine());

        countValidation.validateCount(count);

        return count;
    }

}
