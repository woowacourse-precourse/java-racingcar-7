package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public List<Car> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        String[] names = devideNames(inputNames);
        return makeNameList(names);
    }

    public List<Car> makeNameList(String[] names) throws IllegalArgumentException {
        List<Car> racingCar = new ArrayList<>();
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            } else {
                racingCar.add(new Car(name, 0));
            }
        }
        return racingCar;
    }

    public String[] devideNames(String names) {
        return names.split(",");
    }

    public int getNumberOfGames() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int numberOfGames = Integer.parseInt(Console.readLine());
        return numberOfGames;
    }
}