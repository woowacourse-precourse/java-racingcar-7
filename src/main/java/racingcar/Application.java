package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 자동차 경주 게임의 메인 애플리케이션 클래스. 사용자 입력을 받아 게임을 실행한다.
 *
 * @author JBumLee
 * @version 2024/10/28
 */
public class Application {
    /**
     * 자동차 경주 게임의 메인 메소드. 사용자로부터 자동차 이름들과 시도 횟수를 입력받아 게임을 실행한다.
     *
     * @param args 명령행 인수 (사용하지 않음)
     */
    public static void main(String[] args) {
        Race race = Race.create(setCarNames(), setTryCount());
        race.start();
    }

    /**
     * 사용자로부터 자동차 이름들을 입력받는다. 쉼표(,)로 구분된 문자열을 입력받아 자동차 이름 리스트를 생성한다.
     *
     * @return 입력받은 자동차 이름들의 리스트
     * @throws IllegalArgumentException 자동차가 2대 미만인 경우
     */
    private static List<String> setCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String line = Console.readLine();
        StringTokenizer st = new StringTokenizer(line, ",");
        List<String> carNames = new ArrayList<>();

        while (st.hasMoreTokens()) {
            carNames.add(st.nextToken().trim());
        }

        if (carNames.size() < 2) {
            throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
        }

        return carNames;
    }

    /**
     * 사용자로부터 시도할 횟수를 입력받는다.
     *
     * @return 입력받은 시도 횟수
     * @throws IllegalArgumentException 입력값이 숫자가 아닌 경우
     */
    private static int setTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}