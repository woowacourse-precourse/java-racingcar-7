package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private List<RacingCar> cars = new ArrayList<>();

    public String[] setCarName(String input) {
        return input.split(",");
    }

    public void setCar(String[] carNames) {
        for (String name : carNames) {
            cars.add(new RacingCar(name.trim())); // trim()으로 공백 제거
        }
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application racingGame = new Application();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();  //사용자 입력
        String[] carNames = racingGame.setCarName(carNameInput);
        racingGame.setCar(carNames);
    }
}