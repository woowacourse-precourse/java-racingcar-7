package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.Utils.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분");
        String[] carNames = getNamesFromString(readLine());

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = getTryCountFromString(readLine());

        List<Car> vehicles = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            vehicles.add(new Car(carName, 0));
        }

        System.out.println("실행 결과");
        for (int i = 0; i <tryCount; i++) {
            for (Car car : vehicles) {
                car.move();
                car.printLocation();
            }
        }

        // 최종 우승자
        findWinner(vehicles);
    }

    private static void findWinner(List<Car> vehicles) {
        int max = vehicles.stream().mapToInt(Car::getLocation).max().orElse(0);
        List<String> winners = vehicles.stream()
                                       .filter(car -> car.getLocation() == max)
                                       .map(Car::getName)
                                       .toList();


        System.out.print("최종 우승자 : ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < winners.size()-1; i++) {
            sb.append(winners.get(i));
            sb.append(", ");
        }
        sb.append(winners.get(winners.size()-1));
        System.out.print(sb);
    }
}
