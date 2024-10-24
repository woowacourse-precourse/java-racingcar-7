package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCar {
    public RacingCar() {
    }

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요");
        String inputCarNames = Console.readLine();
        checkLengthWithinLimits(inputCarNames);
        List<String> carNames = validateInputCarNames(inputCarNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputRoofCount = Console.readLine();

        //검증을 하고 타입을 가공하여 리턴받는건 한 가지의 기능을 수행하는 메서드가맞는지
        int roofCount = validateInputRoofCount(inputRoofCount);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        System.out.println("실행 결과");
        for (int i = 0; i < roofCount; i++) {
            for (Car car : cars) {
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    car.moveForward();
                }
            }

            printCurrentResult(cars);
            System.out.println();
        }

        List<Car> winners = getWinners(cars);
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i < winners.size() - 1) {
                System.out.print(",");
            }
        }

    }

    public static List<String> validateInputCarNames(String input) {
        if (!checkLengthWithinLimits(input)) {
            throw new IllegalArgumentException("자동차 이름의 길이는 최대 5글자입니다");
        }
        if (hasDuplicatedCarName(input)) {
            throw new IllegalArgumentException("중복되는 자동차 이름이 있습니다");
        }
        if (!hasValidDelimiter(input)) {
            throw new IllegalArgumentException("자동차 이름으로 공백이 허용되지 않습니다");
        }

        return Arrays.stream(input.split(","))
                .toList();
    }

    private static boolean checkLengthWithinLimits(String input) {
        final int LENGTH_CONDITION = 5;
        String[] carNames = input.split(",");

        for (String carName : carNames) {
            if (carName.length() >= LENGTH_CONDITION) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasDuplicatedCarName(String input) {
        List<String> carNames = Arrays.stream(input.split(","))
                .toList();

        //중복값이 있으면 true를 반환
        //디버그의 단점: 스트림을 꽂아서 사용할 경우 변수표시가 명확하지않음
        return carNames.stream()
                .distinct()
                .count() != carNames.size();
    }

    private static boolean hasValidDelimiter(String input) {
        final String CAR_NAME_DELIMITER = ",";
        String[] carNames = input.split(CAR_NAME_DELIMITER);

        for (String carName : carNames) {
            //공백 허용하지않음
            if (carName.trim().isEmpty()) {
                return false;
            }

            if (carName.contains(CAR_NAME_DELIMITER)) {
                return false;
            }
        }
        return true;
    }

    private static int validateInputRoofCount(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("숫자외의 값이 포함되어있습니다");
        }

        //음수여부도 isNumeric에서 처리되는 중
        //TODO readLine()상태에서 Enter를 입력할 경우 NumberFormatException
        if (isExistNegativeNumber(input)) {
            throw new IllegalArgumentException("양의 정수만 입력할 수 있습니다");
        }

        return Integer.parseInt(input);
    }

    private static boolean isNumeric(String input) {
        return input.chars()
                .allMatch(Character::isDigit);
    }

    private static boolean isExistNegativeNumber(String input) {
        final String NEGATIVE_SYMBOL = "-";
        return input.contains(NEGATIVE_SYMBOL);
    }

    private static List<Car> getWinners(List<Car> cars) {
        int highestPoint = 0;

        //stream max 사용 가능?
        for (Car car : cars) {
            int winningPoint = car.getWinningPoint();
            if (winningPoint > highestPoint) {
                highestPoint = winningPoint;
            }
        }

        //stream filter
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.winningPoint == highestPoint) {
                winners.add(car);
            }
        }
        return winners;
    }

    //StringBuilder 사용하면 더 나을지도
    private static void printCurrentResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + parse(car.winningPoint));
        }
    }

    //StringBuilder 사용 하면 더 나을지도
    private static String parse(int point) {
        String result = "";
        for (int i = 0; i < point; i++) {
            result += "-";
        }
        return result;
    }

    public static class Car {
        private String name;
        private int winningPoint;

        public Car(String name) {
            this.name = name;
            this.winningPoint = 0;
        }

        public void moveForward() {
            winningPoint++;
        }

        public String getName() {
            return name;
        }

        public int getWinningPoint() {
            return winningPoint;
        }
    }
}

