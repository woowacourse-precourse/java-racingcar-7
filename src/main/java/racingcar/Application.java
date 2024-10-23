package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        List<String> carNames = StringParser.parse(input, ",");

        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int moveTryCount = Integer.parseInt(readLine());
        for (int i = 0; i < moveTryCount; i++) {
            for (RacingCar racingCar : racingCars) {
                racingCar.move();
            }
        }
    }
}
