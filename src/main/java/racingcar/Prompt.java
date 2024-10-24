package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Printer {

    public static String requestNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static int requestNumberOfTime() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int n = Integer.parseInt(Console.readLine());
            if (n < 0) {
                throw new IllegalArgumentException("시도횟수는 양수만 가능합니다.");
            }
            System.out.println("\n실행 결과");
            return n;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도횟수는 양수만 가능합니다.");
        }
    }

    public static void printWinners(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        winners.forEach(car -> sb.append(car.getName()).append(", "));
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);
    }
}
