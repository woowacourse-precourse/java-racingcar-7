package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void checkCarsNameProvideException(String cars) {
        if (cars == null) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.\n");
        }
    }
    public static void checkCarsNameException(String cars) {
        if (cars.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요.\n");
        }
    }
    public static void checkCarsNumberException(String[] cars) {
        if (cars.length > 10 || cars.length < 2) {
            throw new IllegalArgumentException("자동차는 2대 이상, 10대 이하로 입력해 주세요.\n");
        }
    }
    public static void checkRaceNumberScopeException(int numberInt) {
        if (numberInt > 10 || numberInt < 1) {
            throw new IllegalArgumentException("횟수는 1회 이상, 10회 이하로 입력해주세요.\n");
        }
    }
    public static void checkRaceNumberTypeException(String numberInt) {
        if (!numberInt.matches("\\d+")) {
            throw new IllegalArgumentException("자동차 경주 횟수는 한 개의 숫자만 넣어주세요.\n");
        }
    }
    public static void checkDuplicateCarsException(String[] cars) {
        Set<String> carSet = new HashSet<>();

        for (String car : cars) {
            // 중복 체크
            if (!carSet.add(car)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.\n");
            }
        }
    }

    public  static String getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carInput = Console.readLine();
        checkCarsNameProvideException(carInput);
        return carInput;
    }

    public static String[] trimCars(String[] cars) {
        for (int i = 0; i < cars.length; i++) {
            cars[i] = cars[i].trim();
            checkCarsNameException(cars[i]);
        }
        checkCarsNumberException(cars);
        checkDuplicateCarsException(cars);
        return cars;
    }

    public static int getRaceNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String raceNumberInput = Console.readLine();
        String raceNumber = raceNumberInput.trim();

        checkRaceNumberTypeException(raceNumber);
        int raceNumberInt = Integer.parseInt(raceNumber);

        checkRaceNumberScopeException(raceNumberInt);
        return raceNumberInt;
    }

    public static void moveWhenMoreFour(int randomNumber, RacingCar cars, StringBuilder raceResult) {
        if (randomNumber >= 4) {
            raceResult.append("-");
            cars.setMoveCount();
        }
    }

    public static void printWinners(List<RacingCar> cars) {
        int maxMoveCount = -1;
        List<String> winners = new ArrayList<>();

        for (RacingCar car : cars) {
            if (car.getMoveCount() > maxMoveCount) {
                maxMoveCount = car.getMoveCount();
            }
        }
        for (RacingCar car : cars) {
            if (car.getMoveCount() == maxMoveCount) {
                winners.add(car.getName());
            }
        }

        System.out.print("최종 우승자 : ");
        var result = String.join(", ", winners);
        System.out.println(result);
    }

    public static void raceGame(List<RacingCar> cars, int raceNumber){
        List<StringBuilder> raceResult = new ArrayList<>();

        System.out.println("실행 결과");

        for (int i = 0; i < cars.size(); i++) {
            raceResult.add(new StringBuilder());
        }

        for (int i = 0; i < raceNumber; i++) {
            for (int j = 0; j < cars.size(); j++) {
                System.out.print(cars.get(j).getName() + " : ");
                
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                moveWhenMoreFour(randomNumber, cars.get(j), raceResult.get(j));
                
                System.out.print(raceResult.get(j));
                System.out.print("\n");
            }
            System.out.print("\n");
        }
        printWinners(cars);
    }

    public static void main(String[] args) {
        String carInput = getCarName();
        List<RacingCar> racingCars = new ArrayList<>();

        String[] splitCar = carInput.split(",", -1);
        String[] trimmedCar = trimCars(splitCar);

        for (String car : trimmedCar) {
            racingCars.add(new RacingCar(car));
        }
        int raceNumber = getRaceNumber();

        raceGame(racingCars, raceNumber);
    }
}