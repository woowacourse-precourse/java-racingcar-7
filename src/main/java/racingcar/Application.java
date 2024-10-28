package racingcar;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.setOut(new PrintStream(new PrintStream(System.out, true, StandardCharsets.UTF_8)));
        String[] carNames = inputCarNames();
        int runCount = inputRunCount();

        int[] carDistance = new int[carNames.length];

        for (int i = 0; i < runCount; i++) {
            move(carDistance);
        }

        System.out.println(String.join(" ",
                Arrays.stream(carDistance)
                .mapToObj(String::valueOf) // 각 요소를 String으로 변환
                .collect(Collectors.joining(" "))));
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

    public static boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public static void move(int[] carDistance) {
        for (int i = 0; i < carDistance.length; i++) {
            if (canMove()) {
                carDistance[i] += 1;
            }
        }
    }
}
