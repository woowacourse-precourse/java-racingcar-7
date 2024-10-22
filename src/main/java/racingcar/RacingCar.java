package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCar {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요");
        String inputText = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int roofCount = Integer.parseInt(Console.readLine());

        List<String> carNames = Arrays.asList(inputText.split(","));
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

    private static List<Car> getWinners(List<Car> cars) {
        int highestPoint = 0;

        //stream max 사용 가능?
        for (Car car : cars) {
            int winningPoint = car.getWinningPoint();
            if (winningPoint > highestPoint) {
                highestPoint = winningPoint;
            }
        }

        //stream filter가 나을지도? 성능고려?
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

