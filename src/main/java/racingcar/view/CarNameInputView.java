package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class CarNameInputView implements InputView{
    private static final String CAR_NAME_INPUT_MESSAGE= "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private String carName;

    @Override
    public void input(){
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String carName = Console.readLine();

        this.carName = carName;
    }

    @Override
    public boolean isValidate() {
        return false;
    }
}
