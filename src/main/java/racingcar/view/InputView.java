package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.validation.CarNameValidation;
import racingcar.validation.CountValidation;

public class InputView {
    private CarNameValidation carNameValidation;
    private CountValidation countValidation;

    public InputView(){
    }

    public InputView(CarNameValidation carNameValidation, CountValidation countValidation){
        this.carNameValidation = carNameValidation;
        this.countValidation = countValidation;
    }

    public List<String> enterCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();

        String[] carNames = userInput.split("\\s*,\\s*");
        List<String> carNameList = Arrays.asList(carNames);

        carNameValidation.isNotEmpty(carNameList);
        carNameValidation.isNameLengthValid(carNameList);
        carNameValidation.isNotDuplicate(carNameList);

        return carNameList;
    }

    public int enterCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String userInput = Console.readLine();

        return countValidation.convertToNaturalNum(userInput);
    }
}
