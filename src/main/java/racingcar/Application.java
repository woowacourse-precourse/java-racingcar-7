package racingcar;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        try {
            String[] carNames = inputCarNames();
            int raceCount = inputRaceCount();
            Car[] cars = createCars(carNames);
            progressRace(raceCount, cars);
            printWinner(cars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            Console.close();
        }
    }

    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = readLine().split(",");
        for (String carName : carNames){
            if (carName.length() > 5){
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        return carNames;
    }

    public static int inputRaceCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int raceCount = Integer.parseInt(readLine());
        return raceCount;
    }

    public static Car[] createCars(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }

    public static void progressRace(int raceCount, Car[] cars) {
        RacingController racingController = new RacingController(cars);
        System.out.println("\n실행 결과");
        for (int i = 0; i < raceCount; i++) {
            racingController.startRace();
            printRaceResult(cars);
            System.out.println();
        }
    }

    public static void printRaceResult(Car[] cars) {
        for (Car car : cars) {
            String raceResult = car.getName() + ":" + "-".repeat(car.getForwardCount());
            System.out.println(raceResult);
        }
    }

    public static void printWinner(Car[] cars) {
        WinnerDecider winnerDecider = new WinnerDecider(cars);
        System.out.println("최종 우승자 : " + winnerDecider.decideWinner());
    }
}
