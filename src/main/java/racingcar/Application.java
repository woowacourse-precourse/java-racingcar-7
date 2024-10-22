package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        int attempts;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        String[] carNames = input.split(",");

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }



        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputAttempt = readLine();
        attempts = Integer.parseInt(inputAttempt);


    }
}
