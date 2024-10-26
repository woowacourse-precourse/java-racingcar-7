package racingcar;
import static java.util.stream.Collectors.joining;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<String> carNames = getcarNames();

        int count = getCount();

        List<Integer> moves = new ArrayList<>(Collections.nCopies(carNames.size(),0));

        runRace(count, carNames, moves);

        printWinner(carNames, moves);
    }

    private static List<String> getcarNames() {
        String input = getString();
        List<String> carNames = parseCarList(input);
        return carNames;
    }

    private static String getString() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static List<String> parseCarList(String input) {
        List<String> carNames = new ArrayList<String>(Arrays.asList(input.split(",")));
        return carNames;
    }

    private static int getCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private static void runRace(int count, List<String> carNames, List<Integer> moves) {
        System.out.println("실행 결과");

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < carNames.size(); j++) {
                moveForward(moves, j);
            }
            printMoves(carNames, moves);
        }
    }

    private static void moveForward(List<Integer> moves, int j) {
        if (determineMovement()) moves.set(j, moves.get(j) + 1);
    }

    private static boolean determineMovement() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private static void printMoves(List<String> carNames, List<Integer> moves) {
        StringBuilder roundResult = new StringBuilder();
        for (int i = 0; i < carNames.size(); i++) {
            roundResult.append(carNames.get(i)).append(" : ");
            roundResult.append("-".repeat(moves.get(i)));
            roundResult.append("\n");
        }
        System.out.println(roundResult);
    }

    private static void printWinner(List<String> carNames, List<Integer> moves) {
        int maxValue = getMaxValue(moves);

        List<Integer> maxIndices = getMaxIndices(moves, maxValue);

        String result = getResult(carNames, maxIndices);

        System.out.println("최종 우승자 : " + result);
    }

    private static int getMaxValue(List<Integer> moves) {
        return moves.stream().max(Integer::compare).orElse(0);
    }

    private static List<Integer> getMaxIndices(List<Integer> moves, int maxValue) {
        List<Integer> maxIndices = new ArrayList<>();
        for (int i = 0; i < moves.size(); i++) {
            if (moves.get(i).equals(maxValue)) {
                maxIndices.add(i);
            }
        }
        return maxIndices;
    }

    private static String getResult(List<String> carNames, List<Integer> maxIndices) {
        String result = String.join(", ", maxIndices.stream()
                .map(index -> carNames.get(index))
                .collect(Collectors.toList()));
        return result;
    }
}