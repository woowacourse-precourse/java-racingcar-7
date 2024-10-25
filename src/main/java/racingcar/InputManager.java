package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;

public class InputManager {
    private ArrayList<Car> cars;

    public void processInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");

        if (hasDuplicateNames(names)) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }

        for (String name : names) {
            String trimmedName = name.trim();
            if (trimmedName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
            }
            if (trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다: " + trimmedName);
            }
            if (!isNameValid(trimmedName)) {
                throw new IllegalArgumentException("자동차 이름에는 숫자가 포함될 수 없습니다: " + trimmedName);
            }
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String numberInput = Console.readLine();
        int number = Integer.parseInt(numberInput);

        if (number < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }

        GameInitializer gameInitializer = new GameInitializer();
        gameInitializer.gameInitialize(names);
        this.cars = gameInitializer.getCars();
        startGame(cars, number);
        gameInitializer.longestCarName(cars);
    }

    private boolean isNameValid(String name) {
        return !name.matches(".*\\d.*");
    }

    private boolean hasDuplicateNames(String[] names) {
        HashSet<String> nameSet = new HashSet<>();
        for (String name : names) {
            if (!nameSet.add(name.trim())) {
                return true;
            }
        }
        return false;
    }

    public void startGame(ArrayList<Car> cars, Integer number) {
        for (int i = 0; i < number; i++) {
            for (Car car : cars) {
                car.move();
            }
            gamePrint(cars);
        }
    }

    public void gamePrint(ArrayList<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.displayStatus());
        }
        System.out.println();
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
}
