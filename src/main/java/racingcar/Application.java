package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String[] carNames = InputHandler.inputCarNames();
        int tryCount = InputHandler.inputTryCount();

        Car[] cars = createCars(carNames);

        PlayGame game = new PlayGame(cars, tryCount);
        game.start(); //apt apt apt apt apt apt uh

        GameResultCalculator calculator = new GameResultCalculator(cars);
        calculator.printWinners();
    }

    private static Car[] createCars(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }
}

class InputHandler {
    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }

        String[] carNames = input.split(",");
        for (String name : carNames) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름에 빈 칸이 포함되어 있거나 잘못된 형식입니다.");
            }
        }
        return carNames;
    }

    public static int inputTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int tryCount = Integer.parseInt(Console.readLine());
            if (tryCount <= 0) {
                throw new IllegalArgumentException("횟수는 1 이상이어야 합니다.");
            }
            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }
}

class PlayGame {
    private final Car[] cars;
    private final int tryCount;

    public PlayGame(Car[] cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void start() {
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            printCarStatuses();
            System.out.println();
        }
    }

    private void printCarStatuses() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.move());
        }
    }
}

class GameResultCalculator {
    private final Car[] cars;

    public GameResultCalculator(Car[] cars) {
        this.cars = cars;
    }

    public void printWinners() {
        int maxWins = findMaxWins();
        String[] winners = findWinners(maxWins);
        System.out.println("최종 우승자 : " + String.join(",", winners));
    }

    private int findMaxWins() {
        int maxWins = 0;
        for (Car car : cars) {
            maxWins = Math.max(maxWins, car.getWinCount());
        }
        return maxWins;
    }

    private String[] findWinners(int maxWins) {
        int count = countWinners(maxWins);
        String[] winnerList = new String[count];
        fillWinnersList(winnerList, maxWins);
        return winnerList;
    }

    private int countWinners(int maxWins) {
        int count = 0;
        for (Car car : cars) {
            if (car.getWinCount() == maxWins) {
                count++;
            }
        }
        return count;
    }

    private void fillWinnersList(String[] winList, int maxWins) {
        int index = 0;
        for (Car car : cars) {
            if (car.getWinCount() == maxWins) {
                winList[index++] = car.getName();
            }
        }
    }
}

class Car {
    private final String name;
    private int winCount = 0;
    private String track = "";

    public Car(String name) {
        if(name == null || name.trim().isEmpty() | name.length()>5){
            throw new IllegalArgumentException("자동차 이름의 길이는 1부터 5까지 입니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getWinCount() {
        return winCount;
    }

    public String move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            winCount++;
            track += "-";
        }
        return track;
    }
}

