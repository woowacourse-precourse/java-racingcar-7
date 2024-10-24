package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputVehicles = Console.readLine();

        List<Vehicle> vehicles = Arrays.stream(inputVehicles.split(","))
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .map(Vehicle::new)
                .toList();

        System.out.println("시도할 횟수는 몇 회인가요?");

        try {
            int raceRounds = Integer.parseInt(Console.readLine());
            for (int i = 0; i < raceRounds; i++) {
                vehicles.forEach(vehicle -> {
                    Randoms.pickNumberInRange(0, 9);
                });
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("경주 횟수는 숫자여야 합니다. 올바른 값을 입력해주세요.");
        }
    }
}
