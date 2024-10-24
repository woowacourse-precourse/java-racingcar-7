package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class CarRacing {
    private static final String CAR_NAME_REGEXP = "[\\w\\s,]+";
    private static final String ATTEMPTS_REGEXP = "\\d+";

    public void init() {
        // inputStringsArr = [ 자동차 이름들, 시도횟수 ]
        ArrayList<String> inputStringsArr = inputStrings();

        int attempts = convertAttempts(inputStringsArr.get(1));
        ArrayList<Car> cars = createCarObjects(convertCarNames(inputStringsArr.get(0)));

        ArrayList<String> winners = racingStart(cars, attempts);

        printGameWinners(winners);

    }

    private ArrayList<String> inputStrings() {
        ArrayList<String> inputStringArr = new ArrayList<>();

        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        inputStringArr.add(Console.readLine());
        println("시도할 횟수는 몇 회인가요?");
        inputStringArr.add(Console.readLine());

        return inputStringArr;
    }

    ArrayList<String> convertCarNames(String nameInput) {
        ArrayList<String> carNames = new ArrayList<>();

        if (validateInput(CAR_NAME_REGEXP, nameInput)) {
            carNames = new ArrayList<>(Arrays.asList(nameInput.split(",")));
        }

        if (carNames.isEmpty() || !validateNameLimit(carNames)) {
            throw new IllegalArgumentException();
        }
        return carNames;
    }

    int convertAttempts(String countInput) {
        if (validateInput(ATTEMPTS_REGEXP, countInput)) {
            return Integer.parseInt(countInput);
        }
        return 0;
    }

    boolean validateInput(final String regExp, String input) {
        if (input.isEmpty() || input.isBlank() || !input.matches(regExp)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    boolean validateNameLimit(ArrayList<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    ArrayList<Car> createCarObjects(ArrayList<String> carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    ArrayList<String> racingStart(ArrayList<Car> cars, int attempts) {
        System.out.println("실행 결과");
        for (int i = 0; i < attempts; i++) {
            // 랜덤 값 생성하고 자동차 전진
            for (Car car : cars) {
                car.run();
            }
            printGameStatus(cars);
        }
        return determineWinner(cars);
    }

    private void printGameStatus(ArrayList<Car> cars) {
        for (Car car : cars) {
            println(makeMovedAmountString(car.name, car.movedAmount));
        }
        println("\n");
    }

    public String makeMovedAmountString(String carName, int movedAmount) {
        String movedAmountString = "-".repeat(movedAmount);
        if (movedAmount == 0) {
            movedAmountString = "";
        }
        return String.format("%s : %s", carName, movedAmountString);
    }

    public ArrayList<String> determineWinner(ArrayList<Car> cars) {
        int maxMovedAmount = 0;
        ArrayList<Car> candidateCars = new ArrayList<>();

        // 참가 자동차 배열을 순회하면서 movedAmount가 가장 큰 자동차 저장
        for (Car car : cars) {
            if (car.movedAmount > maxMovedAmount) {
                maxMovedAmount = car.movedAmount;
                candidateCars.clear();
            } else if (car.movedAmount < maxMovedAmount) {
                continue;
            }
            candidateCars.add(car);
        }

        return getWinnerNames(candidateCars);
    }

    private void printGameWinners(ArrayList<String> winners) {
        println("최종 우승자 : " + String.join(", ", winners));
    }

    private ArrayList<String> getWinnerNames(ArrayList<Car> winners) {
        ArrayList<String> winnerNames = new ArrayList<>();

        winners.forEach(car -> winnerNames.add(car.name));

        return winnerNames;
    }

    private void println(String args){
        System.out.println(args);
    }

}