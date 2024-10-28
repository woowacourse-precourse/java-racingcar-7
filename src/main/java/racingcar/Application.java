package racingcar;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = getValidCarNames(readLine());

        System.out.println("시도할 횟수는 몇 회인가요?");
        int attempts = getValidAttempts(readLine());

        try {
            List<Car> cars = createCars(carNames);
            Race game = new Race(cars, attempts);
            game.start();

            List<String> winners = game.getWinners();
            System.out.println("최종 우승자 : " + String.join(", ", winners));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public static int getValidAttempts(String input){
        try {
            int attempts = Integer.parseInt(input);
            if (attempts < 0) {
                throw new IllegalArgumentException("음수는 시도 횟수로 입력될 수 없습니다.");
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수로는 숫자가 입력되어야 합니다.");
        }
    }

    public static String[] getValidCarNames(String input){
        String[] carNames = input.split(",");
        for (String name: carNames){
            name = name.trim();
            if (name.length() > 5 || name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하만 입력될 수 있습니다.");
            }
        }
        return carNames;
    }

    private static List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }
}

