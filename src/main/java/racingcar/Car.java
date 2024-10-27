package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private StringBuilder state;

    // 자동차 입력 받고 쉼표 기준으로 나누어 반환
    public static String[] input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNamesList = Console.readLine().split(",");
        return carNamesList;
    }

    // 생성자
    public Car(String name) {
        this.name = name;
        this.state = new StringBuilder();
    }

    // 자동차 이름 반환
    public String getName() {
        return name;
    }

    // 자동차 상태 반환
    public String getState() {
        return state.toString();
    }

    // 자동차 전진
    public void moveForward() {
        state.append("-");
    }

    // 자동차 경주
    public void race() {
        int randNum = Randoms.pickNumberInRange(0, 9);
        if(randNum>=4){
            moveForward();
        }
    }

    // 자동차 상황 출력
    public void statePrint() {
        System.out.println(name + " : " + state.toString());
    }
}
