package racingcar;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.setOut(new PrintStream(new PrintStream(System.out, true, StandardCharsets.UTF_8)));
        String[] carNames = inputCarNames();
        int runCount = inputRunCount();

        // input check
        for (int i = 0; i < carNames.length; i++) {
            System.out.println("#" + i + " " + carNames[i]);
        }
        System.out.println("runCount : " + runCount);
    }

    public static String[] inputCarNames() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");

        for (String carName : carNames) {
            if (carName.isEmpty() || carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        return carNames;
    }

    public static int inputRunCount() throws IllegalArgumentException {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int runCount;

        try{
            runCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException | NoSuchElementException e) {
            throw new IllegalArgumentException();
        }

        if (runCount < 0) {
            throw new IllegalArgumentException();
        }
        return runCount;
    }
}
