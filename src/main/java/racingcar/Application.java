package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.io.InputStream;
import java.util.Scanner;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 유저가 형식에 따라 자동차 이름과 시도 횟수를 입력하면
        String carNames = Console.readLine();
        // 예: 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
        // 시도할 횟수는 몇 회인가요?
        String playCounts = Console.readLine();
        int countsValue = Integer.parseInt(playCounts);
        // 입력값에 근거한 자동차 경주 실행 결과와 최종 우승자를 출력한다
        Controller controller = new Controller(carNames, countsValue);

        // 실행 결과
        // ...
        // 최종 우승자 : 봉진 님
        Frontend frontend = new Frontend(controller);



    }
}
