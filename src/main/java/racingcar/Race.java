package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Race {
    public void runRace() {
        String racingCarsName = inputCarName(); // 자동차 이름 문자열을 입력받는다.
        int raceRound = inputRaceRound(); // 자동차 race round를 입력받는다.

        List<Car> racingCars = createCarClassList(racingCarsName); // Car클래스 리스트를 생성한다.
    }

    public String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        return Console.readLine();
    }

    public int inputRaceRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public List<Car> createCarClassList(String str) {
        List<String> carsList = Arrays.asList(str.split(","));

        List<Car> racingCars = new ArrayList<>();
        for (String name : carsList) {
            validate(name);  // 자동차 이름에 대한 유효성을 검사한다.
            racingCars.add(new Car(name));
        }
        return racingCars;
    }

    public void validate(String name) {
        if (name.length() > 5 ) {
            throw new IllegalArgumentException("wrong input");
        }
    }
}
