package racingcar;


import java.util.ArrayList;
import java.util.List;

public class Application {

    private static IInputDisplay inputDisplay;

    public static void main(String[] args) {
        inputDisplay = new WtcInputDisplay();

        List<ICar> carList = settingCarList();

        String roundStr = inputDisplay.getPromptInput("시도할 횟수는 몇 회인가요?\n");
        int round = Integer.parseInt(roundStr);

        IOutputDisplay outputDisplay = new OutputDisplayImpl();
        CarRacingGame carRacingGame = new CarRacingGame(outputDisplay, carList, round);

        carRacingGame.start();
    }

    private static List<ICar> settingCarList() {
        String carNameMass = inputDisplay.getPromptInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String[] carNames = carNameMass.split(",");

        List<ICar> carList = new ArrayList<>();
        for (final String carName : carNames) {
            carList.add(new CarImpl(carName));
        }

        return carList;
    }
}
