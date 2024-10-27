package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws CarNameInputException {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int n = Integer.parseInt(Console.readLine());
        countInputVerification(n);

        List<Car> cars = createParticipant(input);

        System.out.println("실행 결과");
        for (int i = 0; i < n; i++) {

            for (Car car : cars) {
                car.isMove();
                System.out.println(car);
            }

            System.out.println();
        }

        int max = calMaxMove(cars);
        List<String> winners = findWinners(cars, max);

        System.out.println("최종 우승자 : " + String.join(", ", winners));

    }

    public static List<Car> createParticipant(String input) {

        String[] names = input.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            name = name.trim();
            carNameInputVerification(name);
            cars.add(new Car(name));
        }

        return cars;
    }

    public static void countInputVerification(int n) {
        if (n < 0) {
            throw new NumberInputException();
        }
    }

    public static void carNameInputVerification(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new CarNameInputException();
        }
    }

    public static int calMaxMove(List<Car> cars) {

        int res = 0;

        for (Car item : cars) {

            int value = item.getPosition();

            if (value > res) {
                res = value;
            }
        }

        return res;
    }

    public static List<String> findWinners(List<Car> cars, int max) {

        List<String> winners = new ArrayList<>();

        for (Car car : cars) {

            if (car.getPosition() == max) {
                winners.add(car.getCarName());
            }
        }

        return winners;
    }
}