package racingcar;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.setOut(new PrintStream(new PrintStream(System.out, true, StandardCharsets.UTF_8)));

        /* input parsing */
        String[] carNames = inputCarNames();
        int runCount = inputRunCount();
        System.out.println("\n실행결과");


        /* Run and print according to runCount */
        int[] carDistance = new int[carNames.length];
        StringBuilder output = new StringBuilder();
        final int PRINT_INTERVAL = 20;

        for (int i = 0; i < runCount; i++) {
            if (i % PRINT_INTERVAL == 0) { // for memory, flush output
                printOutput(output);
            }
            move(carDistance); // calculate new distance
            updateOutput(carNames, carDistance, output);
        }
        printOutput(output);


        /* print final output */
        output.append("최종 우승자 : ");
        List<Integer> maxValueIndexes = getMaxValueIndexes(carDistance);
        for (int index : maxValueIndexes) {
            output.append(carNames[index]).append(", ");
        }
        output.deleteCharAt(output.length() - 2);
        System.out.println(output);
    }

    /** Get input by stdin and split it with ",". Every car name must be between 1 and 5 characters */
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
    /** Get input by stdin and parse to int. The number should be positive integer or zero. */
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
    /** Calculate new distances. For every car, if it can move this time, add 1 to the carDistance */
    public static void move(int[] carDistance) {
        for (int i = 0; i < carDistance.length; i++) {
            if (canMove()) {
                carDistance[i] += 1;
            }
        }
    }
    /** Translate current distance to the "{carName} : (-)*{carDistance}" format. */
    public static void updateOutput(String[] carNames, int[] carDistance, StringBuilder output) {
        for (int i = 0; i < carDistance.length; i++) {
            output.append(carNames[i]).append(" : ").append("-".repeat(carDistance[i])).append("\n");
        }
        output.append("\n");
    }
    /** Print output and set stringbuilder length to zero. */
    public static void printOutput(StringBuilder output) {
        System.out.println(output);
        output.setLength(0);
    }
    /** Find max value of int array then return those values' indexes */
    public static List<Integer> getMaxValueIndexes(int[] carDistance) {
        int maxDistance = 0;
        List<Integer> maxValueIndexes = new ArrayList<>();

        for (int i = 0; i < carDistance.length; i++) {
            if (carDistance[i] > maxDistance) {
                maxDistance = carDistance[i];
                maxValueIndexes.clear();
                maxValueIndexes.add(i);
            } else if (carDistance[i] == maxDistance) {
                maxValueIndexes.add(i);
            }
        }

        return maxValueIndexes;
    }
}
