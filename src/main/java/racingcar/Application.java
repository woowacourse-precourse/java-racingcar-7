package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    public static String inputText() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String text = Console.readLine();
        return text;
    }

    public static List<Car> createCarList(String text) {
        List<Car> carList = new ArrayList<>();
        Set<String> carSet = new HashSet<>();

        for (String carName : text.split(",")) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }

            if (!carSet.add(carName)) {
                throw new IllegalArgumentException();
            }

            if (carName == null || carName.isBlank()) {
                throw new IllegalArgumentException();
            }

            carList.add(new Car(carName));
        }

        return carList;
    }

    public static int inputTestCaseNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        int testCase = Integer.parseInt(input);
        if (testCase < 0) {
            throw new IllegalArgumentException();
        }
        return testCase;
    }

    public static void racingCar(int tc, List<Car> carList) {
        System.out.println("실행 결과");

        while (tc >= 0) {
            for (Car car : carList) {
                car.move();
                car.print();
            }
            tc--;
        }
    }

    public static int findMax(List<Car> cars) {
        // list를 받아서 가장 많이 전진한 car를 찾는 메서드
        int mx = 0;
        for (Car car : cars) {
            if (mx < car.getMoveCount()) {
                mx = car.getMoveCount();
            }
        }
        return mx;
    }

    public static List<String> createWinnerList(List<Car> cars, int maxNum) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMoveCount() == maxNum) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public static void printWinner(List<String> winnerList) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(",", winnerList));
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputText = inputText();

        List<Car> carList = new ArrayList<>();
        carList = createCarList(inputText);

        int trialCount = inputTestCaseNum();

        racingCar(trialCount, carList);

        System.out.println();
        int mx = findMax(carList);

        List<String> winnerList = new ArrayList<>();
        winnerList = createWinnerList(carList, mx);

        printWinner(winnerList);
    }
}
