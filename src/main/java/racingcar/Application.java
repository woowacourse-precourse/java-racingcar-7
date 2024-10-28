package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String cars = getCarNames();
        int tries = getTries();

        CarList carlist = new CarList();
        addCarsToList(cars, carlist);

        raceCars(carlist, tries);
        printWinners(carlist);
    }

    private static String getCarNames() {
        System.out.println("자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static void validation(String carName) {
        if (carName.trim().isEmpty() || carName.length() > 5) throw new IllegalArgumentException();
    }

    private static int getTries() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        String triesInput = Console.readLine();
        return Integer.parseInt(triesInput);
    }

    private static void addCarsToList(String cars, CarList carlist) {
        String[] carNames = cars.split(",");
        for (String carName : carNames) {
            validation(carName);
            Car car = new Car(carName, 0);
            carlist.getCars().add(car);
        }
    }

    private static void moveCars(CarList carlist) {
        for (Car car : carlist.getCars()) {
            car.move_car();
        }
    }

    private static void raceCars(CarList carList, int tries) {
        while (tries-- > 0) {
            moveCars(carList);
            carList.printPositions(carList);
            System.out.println();
        }
    }

    private static List<String> findWinners(CarList carList) {
        int max_move = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : carList.getCars()) {
            if (car.getMovevalue() > max_move) {
                winners.clear();
                max_move = car.getMovevalue();
                winners.add(car.getName());
            } else if (car.getMovevalue() == max_move) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
    private static void printWinners(CarList carList) {
        List<String> winners = findWinners(carList);
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }
}
