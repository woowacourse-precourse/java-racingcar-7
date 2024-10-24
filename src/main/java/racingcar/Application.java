package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        IInputDisplay inputDisplay = new WtcInputDisplay();

        String carNameMass = inputDisplay.getPromptInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String[] carNameList = carNameMass.split(",");
    }
}
