package racingcar;

import java.util.HashMap;
import camp.nextstep.edu.missionutils.Console; // readLine()
import camp.nextstep.edu.missionutils.Randoms; //pickNumberInRange()

public class Application {
    public static void main(String[] args) {
    }
}

//n대의 자동차 입력받고 저장하기
//주어진 횟수(이동 횟수) 입력받고 저장하기
//자동차 전진 또는 멈춤(랜덤값)
//차수별 실행 결과 출력하기
//우승자 출력하기
//예외 처리
class Racingcar {
    HashMap<String, Integer> carLocation = new HashMap<String, Integer>(); // (자동차 이름: 현재 위치)

    void inputCar(final String text) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        for(final String carName : text.split(",")) {
            carLocation.put(carName, 0);
        }
    }
}