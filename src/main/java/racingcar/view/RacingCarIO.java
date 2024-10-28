package racingcar.view;

import java.math.BigInteger;
import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingCarIO {

    public String getCarInfo() {
        System.out.println("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    public String tryCountInfo() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return readLine();
    }

    public void printResult(ArrayList<String> names, ArrayList<BigInteger> values) {
        System.out.println("실행 결과");

        for (int i = 0; i < names.size(); i++) {
            StringBuilder slash = getSlash(values.get(i));
            System.out.println(names.get(i) + " : " + slash);
        }
    }

    private static StringBuilder getSlash(BigInteger value) {
        StringBuilder slash = new StringBuilder();

        for (BigInteger i = BigInteger.ZERO; i.compareTo(value) < 0; i = i.add(BigInteger.ONE)) {
            slash.append("-");
        }
        return slash;
    }

    public void printWinners(String[] winners) {
        System.out.println("최종 우승자 : ");

        if (winners.length == 0) {
            return;
        }

        System.out.print(winners[0]);
        for (int i = 1; i < winners.length; i++) {
            System.out.print("," + winners[i]);
        }
    }
}
