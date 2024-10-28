package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String moveCnt = Console.readLine();

        validateInput(moveCnt);
        ArrayList<Car> raceResult = raceStart(cars, moveCnt);
        ArrayList<String> winners = getRaceWinners(raceResult);
        printWinners(winners);
    }

    public static void validateInput(String input) {
        try {
            int moveCount = Integer.parseInt(input);
            if (moveCount < 0) {
                throw new IllegalArgumentException("이동 횟수는 음수일 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 숫자여야 합니다.");
        }
    }

    public static ArrayList<Car> addCars(String cars) {
        ArrayList<Car> carList = new ArrayList<>();
        String[] carNames = cars.split(",");

        if (carNames.length == 0 || (carNames.length == 1 && carNames[0].isEmpty())) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }

        for (String carName : carNames) {
            carName = carName.strip();
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
            }
            carList.add(new Car(carName, 0));
        }
        return carList;
    }

    public static ArrayList<Car> raceStart(String cars, String moveCnt) {
        ArrayList<Car> carList = addCars(cars);
        int moveTime = Integer.parseInt(moveCnt);

        while (moveTime-- > 0) {
            for (Car car : carList) {
                car.move();
                car.showRaceProgress();
            }
            System.out.println();
        }
        return carList;
    }

    public static ArrayList<String> getRaceWinners(ArrayList<Car> carList) {
        int maxWins = 0;
        ArrayList<String> winners = new ArrayList<>();

        for (Car car : carList) {
            if (car.getDistance() > maxWins) {
                maxWins = car.getDistance();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getDistance() == maxWins) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public static void printWinners(ArrayList<String> winners) {
        System.out.print("최종 우승자 : ");

        for (int i = 0; i < winners.size() - 1; i++) {
            System.out.print(winners.get(i) + ", ");
        }
        System.out.print(winners.getLast());
    }
}