package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 * 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
 * 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
 * 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 * 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
 * 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
 * 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
 * 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
 */
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();
        List<String> carNames = List.of(carNameInput.split(","));

        carNames.forEach(car -> {
            if(car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        });

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());
        if(tryCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1이상이어야 합니다.");
        }


        Map<String, Integer> cars = new HashMap<>();
        carNames.forEach(carName -> {
            cars.putIfAbsent(carName, 0);
        });

        for(int i = 0; i < tryCount; i++) {

            for(String car : cars.keySet()) {
                int randomValue = Randoms.pickNumberInRange(0, 9);

                if(randomValue >= 4) {
                    int prevPosition = cars.get(car);
                    cars.put(car, prevPosition + 1);
                }
            }

            //현재상태 출력
            StringBuilder carStatus = new StringBuilder();
            cars.keySet().forEach(carName -> {
                carStatus.append(carName).append(" : ");
                for(int k = 0; k < cars.get(carName); k++) {
                    carStatus.append("-");
                }
                carStatus.append("\n");
            });
            System.out.println(carStatus);
        }




    }
}
