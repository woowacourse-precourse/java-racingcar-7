package racingcar;
import static java.util.stream.Collectors.joining;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<String> cars = getCars();

        int count = getCount();

        List<Integer> moves = new ArrayList<>(Collections.nCopies(cars.size(),0));

        System.out.println("실행 결과");

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < cars.size(); j++) {
                if (determineMovement()) moves.set(j, moves.get(j) + 1);
            }
            printMoves(cars, moves);
        }

        printWinner(cars, moves);
    }

    private static List<String> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> cars = new ArrayList<String>(Arrays.asList(input.split(",")));
        return cars;
    }

    private static int getCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(Console.readLine());
        return count;
    }

    private static boolean determineMovement() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) return true;
        return false;
    }

    private static void printMoves(List<String> cars, List<Integer> moves) {
        StringBuilder roundResult = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            roundResult.append(cars.get(i)).append(" : ");
            for (int j = 0; j < moves.get(i); j++) {
                roundResult.append("-");
            }
            roundResult.append("\n");
        }
        System.out.println(roundResult);
    }

    private static void printWinner(List<String> cars, List<Integer> moves) {
        int maxValue = moves.stream().max(Integer::compare).orElse(0);

        List<Integer> maxIndices = new ArrayList<>();
        for (int i = 0; i < moves.size(); i++) {
            if (moves.get(i).equals(maxValue)) {
                maxIndices.add(i);
            }
        }

        String result = String.join(", ", maxIndices.stream()
                .map(index -> cars.get(index))
                .collect(Collectors.toList()));

        System.out.println("최종 우승자 : " + result);
    }
}