package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.data.Index;

import java.util.HashMap;
import java.util.Map;

public class racingCarLauncher {

    private Map<String, Integer> recentRecord = new HashMap<>();
    public void start(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String cars = Console.readLine();
        inputCars(cars);
    }

    private void inputCars(String cars) {

        String[] split = cars.split(",");

        for (String car : split) {

            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
            }
            if(recentRecord.containsKey(car)){
                throw new IllegalArgumentException("자동차 이름은 중복이 안됩니다.");
            }
            recentRecord.put(car, recentRecord.getOrDefault(car, 0));
        }
    }

}
