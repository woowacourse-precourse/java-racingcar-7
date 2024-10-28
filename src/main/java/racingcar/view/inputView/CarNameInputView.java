package racingcar.view.inputView;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.validator.CarNameValidator;

public class CarNameInputView implements InputView {
    private static final String CAR_NAME_INPUT_MESSAGE= "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private final CarNameValidator validator;

    public CarNameInputView(){
        this.validator = new CarNameValidator();
    }

    @Override
    public String input(){
        System.out.println(CAR_NAME_INPUT_MESSAGE);

        String input = Console.readLine();

        isValidate(input);

        return input;
    }

    @Override
    public void isValidate(String input) {
        validator.isValidate(input);
    }
}
