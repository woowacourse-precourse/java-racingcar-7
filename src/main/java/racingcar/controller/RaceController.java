package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    private final List<Car> cars = new ArrayList<>();
    private static final int MAX_GAME_NUMBER = 1000;

    public void startRace() {
        getCarNames();
        getMoveCount();
    }

    private void getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
    }

    private int getMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요? (최대 경주 횟수는 1000회입니다.)");
        int count;
        try {
            String input = Console.readLine();
            count = Integer.parseInt(input);
            validateMoveCount(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.", e);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("예상치 못한 에러가 발생하였습니다." + e.getMessage());
            throw e;
        }
        return count;
    }

    private void validateMoveCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("경주 횟수는 1 이상의 숫자여야 합니다.");
        }
        if (count > MAX_GAME_NUMBER) {
            throw new IllegalArgumentException("최대 경주 횟수(1000회)를 벗어났습니다.");
        }
    }
}