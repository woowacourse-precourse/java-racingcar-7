package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine().trim();
        if (!Validator.validateCarNames(carNamesInput)) {
            throw new IllegalArgumentException();
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCntInput = Console.readLine().trim();
        if (!Validator.validateTryCntInput(tryCntInput)) {
            throw new IllegalArgumentException();
        }
        int tryCnt = Integer.parseInt(tryCntInput);

        // 차량 제작
        List<Car> cars = new ArrayList<>();
        String[] carNames = carNamesInput.split(",");
        for (String carName : carNames) {
            cars.add(new Car(carName.trim()));
        }
        
        // 경주
        race(cars, tryCnt);
        
        // 우승자 출력
        printWinners(cars);
    }

    private static void race(List<Car> cars, int tryCnt) {
        System.out.println("\n실행 결과");
        while (tryCnt > 0) {
            for (Car car : cars) {
                car.forward();
            }
            System.out.println();
            tryCnt--;
        }
    }

    private static void printWinners(List<Car> cars) {
        int max = 0;
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.moves < max) continue;
            if (car.moves > max) winners.clear();
            winners.add(car);
            max = car.moves;
        }

        StringBuilder result = new StringBuilder();
        for (Car winner : winners) {
            if (!result.isEmpty()) result.append(", ");
            result.append(winner.name);
        }
        System.out.println("최종 우승자 : " + result);
    }

}
