package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.message.Message;
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
        System.out.println(Message.enterName.getMessage());
        String userInput = Console.readLine();

        String[] carNames = userInput.split("\\s*,\\s*");
        List<String> carNameList = Arrays.asList(carNames);

        carNameValidation.isNotEmpty(carNameList);
        carNameValidation.isNameLengthValid(carNameList);
        carNameValidation.isNotDuplicate(carNameList);

        return carNameList;
    }

    public int enterCount(){
        System.out.println(Message.count.getMessage());
        String userInput = Console.readLine();

        return countValidation.convertToNaturalNum(userInput);
    }
}
