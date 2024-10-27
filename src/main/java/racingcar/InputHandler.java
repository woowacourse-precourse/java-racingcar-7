package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public List<Car> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        String[] names = divideNames(inputNames);
        return makeNameList(names);
    }

    public String[] divideNames(String names) {
        return names.split(",");
    }

    public void validateNames(String[] names) throws IllegalArgumentException {
        for(String singleName : names) {
            if(singleName.length() > 5 || singleName.isBlank()) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Car> makeNameList(String[] names) throws IllegalArgumentException {
        validateNames(names);
        List<Car> racingCar = new ArrayList<>();
        for (String name : names) {
            racingCar.add(new Car(name, 0));
        }
        return racingCar;
    }

    public int getNumberOfGames() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return validateNumberOfGames(Console.readLine());
    }

    public int validateNumberOfGames(String input) throws IllegalArgumentException {
        try {
            if(Integer.parseInt(input) <= 0) {
                throw new IllegalArgumentException();
            } else {
                return Integer.parseInt(input);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}