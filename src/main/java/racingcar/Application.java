package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // 사용자에게 입력 받기
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = scanner.nextLine();

        String[] carNames = carName.split(",");

        List<Car> cars = new ArrayList<>();
        for (String carname : carNames) {
            carname = carname.trim();
            if (carname.isEmpty() || carname.length() > 5) {
                throw new IllegalArgumentException();
            }
            cars.add(new Car(carname));
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int maxTurns = Integer.parseInt(Console.readLine());
        if (maxTurns <= 0) {
            throw new IllegalArgumentException();
        }


        System.out.println("실행 결과");

        for (int turn = 0; turn < maxTurns; turn++) {
            for (Car car : cars) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) {
                    car.moveForward();
                }
                System.out.print(car.getName() + " : ");
                Car.printCarPosition(car.getPosition());
            }
            System.out.println();
        }
        findWinners(cars);
    }

    public static void findWinners(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);

        List<String> winners = cars.stream().filter(car -> car.getPosition() == maxPosition).map(Car::getName).collect(Collectors.toList());

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
