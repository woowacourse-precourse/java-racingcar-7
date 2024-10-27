package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceControl {
    private List<String> nameList;
    private int trialCount;
    List<Car> carList = new ArrayList<>();

    /**
     * 경주할 자동차 이름을 등록합니다.
     */
    void enroll() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        this.nameList = Arrays.stream(input.split(","))
                .map(String::trim) // 각 문자열 요소의 양 끝 공백 제거
                .collect(Collectors.toList());
    }

    /**
     * 경주할 자동차 명단을 확정합니다.
     */
    void confirmRoster() {
        for (String name : this.nameList) {
            Car car = new Car(name);

            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }

            this.carList.add(car);  // 생성된 Car 객체를 리스트에 추가
        }
    }

    /**
     * 경주할 횟수를 정합니다.
     */
    void decideRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        this.trialCount = Integer.parseInt(Console.readLine());
    }

    /**
     * 경기를 진행합니다. (구현 예정)
     */
    void race() {
        for (int i = 0; i < this.trialCount; i++) {
            for(Car car : this.carList) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) {
                    car.move();
                }
            }

            this.record(i);
        }
    }

    /**
     * 경기의 결과를 표시합니다.
     *
     * @param round 경기회차
     */
    void record(int round) {

        System.out.println();

        if (round == 0) {
            System.out.println("실행결과");
        }

        for(Car car : this.carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getLocation()) );
        }

    }

}
