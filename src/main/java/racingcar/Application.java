package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Car> cars = getCarNames();
        int moves = getMovementCounts();

        startRace(cars, moves);
        endRace(cars);

    }

    public static List<Car> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine().trim();

        validateInput(input);
        List<Car> cars = new ArrayList<>();
        for (String name : input.split(",")) {
            cars.add(new Car(name));
        }
        validateNames(cars);
        return cars;
    }

    public static void validateInput(String input) {
        if (input.isEmpty()){
            throw new IllegalArgumentException("입력 오류: 입력값이 없습니다.");
        }
        if (input.startsWith(",") || input.endsWith(",") || input.contains(",,")){
            throw new IllegalArgumentException("입력 오류: 잘못된 쉼표 사용입니다.");
        }
    }

    public static void validateNames(List<Car> cars) {
        Set<String> uniqueNames = new HashSet<>();

        for (Car car : cars) {
            if (car.getName().length() > 5) {
                throw new IllegalArgumentException("입력 오류: 5글자를 초과한 이름이 있습니다.");
            }

            if (!uniqueNames.add(car.getName())) {
                throw new IllegalArgumentException("입력 오류: 중복된 이름이 있습니다.");
            }
        }
    }

    public static int getMovementCounts() {
        try{
            System.out.println("시도할 횟수는 몇 회인가요?");
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 오류: 정수를 입력하세요.");
        }
    }

    public static void startRace(List<Car> cars, int moves) {
        System.out.println("실행 결과");
        for (int i = 0; i < moves; i++) {
            for(Car car : cars){
                car.move();
                car.printPosition();
            }
            System.out.println();
        }
    }

    public static void endRace(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
