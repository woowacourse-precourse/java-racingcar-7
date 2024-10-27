package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // 자동차 이름 입력 및 검증
        List<String> nameList = inputCarNames();

        // 이동 횟수 입력 및 검증
        int times = inputRaceTimes();

        // 자동차 경주 진행
        List<Integer> racePositions = initializePositions(nameList.size());

        System.out.println("실행 결과");
        for (int i = 0; i < times; i++) {
            moveCars(racePositions);
            printRaceStatus(nameList, racePositions);
        }

        // 우승자 결정 및 출력
        List<String> winners = findWinners(nameList, racePositions);
        printWinners(winners);
    }

    private static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = readLine();
        List<String> nameList = Arrays.asList(names.split(","));
        for (String name : nameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
        return nameList;
    }

    private static int inputRaceTimes() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수는 숫자만 입력할 수 있습니다.");
        }
    }

    private static List<Integer> initializePositions(int size) {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            positions.add(0);
        }
        return positions;
    }

    private static void moveCars(List<Integer> positions) {
        for (int i = 0; i < positions.size(); i++) {
            if (pickNumberInRange(0, 9) >= 4) {
                positions.set(i, positions.get(i) + 1);
            }
        }
    }

    private static void printRaceStatus(List<String> nameList, List<Integer> positions) {
        for (int i = 0; i < nameList.size(); i++) {
            System.out.print(nameList.get(i) + " : ");
            System.out.println("-".repeat(positions.get(i)));
        }
        System.out.println();
    }

    private static List<String> findWinners(List<String> nameList, List<Integer> positions) {
        int maxPosition = positions.stream().max(Integer::compareTo).orElse(0);
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < positions.size(); i++) {
            if (positions.get(i) == maxPosition) {
                winners.add(nameList.get(i));
            }
        }
        return winners;
    }

    private static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(",", winners));
    }
}