package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsNameInput = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String countInput = Console.readLine();

        String[] carsNameArray = parseCarsName(carsNameInput);
        List<String> carsNameList = arrayToList(carsNameArray);
        List<String> trimmedCarsNameList = carsNameTrim(carsNameList);

        validateCarsName(trimmedCarsNameList);

        List<Car> cars = new ArrayList<>();
        for (String carName : trimmedCarsNameList) {
            cars.add(createCar(carName));
        }

        validateCount(countInput);
        int count = parseInt(countInput);

        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            race(cars);
            printRaceResult(cars);
        }

        List<String> winnerList = determineWinner(cars);
        String winnerString = parseWinner(winnerList);
        System.out.println("최종 우승자 : " + winnerString);
    }

    private static String[] parseCarsName(String carInput) {
        return carInput.split(",");
    }

    private static List<String> arrayToList(String[] array) {
        return Arrays.asList(array);
    }

    private static List<String> carsNameTrim(List<String> cars) {
        List<String> trimmedCarsName = new ArrayList<>();
        for (String car : cars) {
            trimmedCarsName.add(car.trim());
        }
        return trimmedCarsName;
    }

    private static void validateCarsName(List<String> trimmedCarsNameList) {
        List<String> existCarsNameList = new ArrayList<>();
        for (String carName : trimmedCarsNameList) {
            // 공백, 빈값
            if (carName == null || carName.isBlank()) {
                throw new IllegalArgumentException();
            }

            // 이름에 공백
            if (carName.contains(" ")) {
                throw new IllegalArgumentException();
            }

            // 5글자 초과
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }

            // 중복일 때
            if (existCarsNameList.contains(carName)) {
                throw new IllegalArgumentException();
            }

            existCarsNameList.add(carName);
        }

        // 자동차 1대 이하일 때
        if (existCarsNameList.size() <= 1) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 엄청 큰 숫자가 들어왔을 때도 고려
    private static int parseInt(String string) {
        return Integer.parseInt(string);
    }

    private static void validateCount(String countInput) {
        try {
            Integer.parseInt(countInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (Integer.parseInt(countInput) < 1) {
            throw new IllegalArgumentException();
        }
    }

    private static Car createCar(String name) {
        return new Car(name);
    }

    private static void race(List<Car> cars) {
        for (Car car : cars) {
            int random = Randoms.pickNumberInRange(0, 9);

            if (random >= 4) {
                car.increaseDistance();
            }
        }
    }

    private static void printRaceResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    private static List<String> determineWinner(List<Car> cars) {
        int maxDistance = 0;
        for (Car car : cars) {
            if (maxDistance < car.getDistance()) {
                maxDistance = car.getDistance();
            }
        }

        List<String> winner = new ArrayList<>();
        for (Car car : cars) {
            if (maxDistance == car.getDistance()) {
                winner.add(car.getName());
            }
        }
        return winner;
    }

    private static String parseWinner(List<String> winnerList) {
        StringBuilder winnerString = new StringBuilder();
        int size = winnerList.size();
        for (int i = 0; i < size; i++) {
            winnerString.append(winnerList.get(i));
            if (i < size - 1) {
                winnerString.append(", ");
            }
        }
        return winnerString.toString();
    }

    private static class Car {
        private final String name;
        private int distance;

        public Car(String name) {
            this.name = name;
            this.distance = 0;
        }

        public String getName() {
            return name;
        }

        public int getDistance() {
            return distance;
        }

        public void increaseDistance() {
            distance++;
        }
    }
}
