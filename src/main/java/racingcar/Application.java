package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class Application {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //indent depth가 3이 넘지 않도록. 2까지만 허용 -> 메서드 분리
        //3항 연산자 쓰지 말기
        //함수가 한가지 일만 하도록 최대한 작게 만들기
        //JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인

        //주어진 횟수 동안 n대의 자동차는 전진 또는 정지
        //각 자동차에 이름 부여 가능. 전진하는 자동차 출력 시 자동차 이름 같이 출력
        //자동차 이름은 쉼표 기준으로 구분, 이름은 5자 이하
        //전진하는 조건은 0~9의 무작위 값을 구한 후 무작위 값이 4 이상 일때
        //끝나면 우승자 알려주기
        //우승자가 여러 명이면 쉼표를 이용하여 구분
        //잘못된 값 입력시 IllegalArgumentException 발생

        String inputCarNames = Console.readLine();

        String[] carNames = inputCarNames.split(",");

        Map<String, Integer> carMoveMap = new HashMap<>();
        for(String carName : carNames) { //carName의 앞 뒤에 공백이 있을 경우 고려
            carMoveMap.put(carName, 0);
        }

        for (String s : carMoveMap.keySet()) {
            System.out.println("s = " + s);
        }

        int attempts = Integer.parseInt(Console.readLine());

        Console.close();
    }
}
