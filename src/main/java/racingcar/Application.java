package racingcar;


import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        IInputDisplay inputDisplay = new WtcInputDisplay();

        String carNameMass = inputDisplay.getPromptInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String[] carNameList = carNameMass.split(",");

        List<ICar> carList = new ArrayList<>();
        for (final String carName : carNameList) {
            carList.add(new CarImpl(carName));
        }

        String roundStr = inputDisplay.getPromptInput("시도할 횟수는 몇 회인가요?\n");
        int round = Integer.parseInt(roundStr);

        CarRacingGame carRacingGame = new CarRacingGame(carList, round);
    }
}
