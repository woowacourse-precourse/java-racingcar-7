package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 차 이름 입력받고 이름을 하나씩 나누어 이름 배열에 저장 -> getCarNames()
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        String[] cars = names.split(",");

        // 시도 횟수 -> getRepeatNum()
        System.out.println("시도할 횟수는 몇 회인가요?");
        String repeatStr = Console.readLine();
        int repeat = Integer.parseInt(repeatStr);

        // 입력받은 횟수만큼 차량 전진
        while (repeat-- > 0) {
            moveCars(); // 차량 이동
            showCurrentStatus(); // 현재 차수 실행 결과 출력
        }

        // 프로그램 완료: 우승자 출력
        showWinner();
    }
    public static void moveCars() {

    }

    public static void showCurrentStatus() {

    }

    public static void showWinner() {

    }
}
