package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.sql.Array;
import java.util.*;

public class Application {
    private static final String DELIMITER = ",";
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9; // endInclusive
    private static final int MOVING_FORWARD = 4;

    private static Map<String, Integer> stateMap = null;
    private static int progressCount = 0;
    public static void main(String[] args) {
        setArguments();
        progressRace();
        List<String> winners = searchWinner();
        printWinners(winners);
    }

    /**
     * 사용자가 입력한 문자열을 통해 프로그램을 수행하는 데 필요한 변수들을 설정한다.
     *
     * @throws IllegalArgumentException 입력한 문자열이 올바른 값이 아닌 경우 해당 예외를 발생시킵니다.
     */
    private static void setArguments() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String InputCarNames = Console.readLine();
        List<String> nameList = splitCarNameString(InputCarNames);
        setStateMap(nameList);

        System.out.println("시도할 횟수는 몇 회인가요?");
        progressCount = Integer.parseInt(Console.readLine());
    }

    /**
     * 사용자가 입력한 이름 문자열을 구분자인 쉼표(,)를 기준으로 이름을 구분합니다.
     *
     * @param inputString 사용자가 입력한 이름 문자열입니다.
     * @return 구분한 이름들에 대한 List입니다.
     */
    private static List<String> splitCarNameString(String inputString) {
        return new ArrayList<>(Arrays.asList(inputString.strip().split(DELIMITER)));
    }

    /**
     * 이름 List에 있는 원소들을 stateMap의 Key로 저장합니다.
     * 이름이 공백이거나 일정 길이를 초과한 경우, 중복된 경우 예외를 발생시킵니다.
     *
     * @param nameList 이름이 저장된 List입니다.
     * @throws IllegalArgumentException 잘못된 입력이 주어진 경우 에러를 발생시킵니다.
     */
    private static void setStateMap(List<String> nameList) throws IllegalArgumentException {
        stateMap = new HashMap<>();

        for (String name: nameList) {
            if(name.isBlank() || name.length() > NAME_LENGTH_LIMIT) {
                throw new IllegalArgumentException();
            } else if (stateMap.containsKey(name)) {
                throw new IllegalArgumentException();
            } else {
                stateMap.put(name, 0);
            }
        }
    }

    /**
     * 입력된 값들을 활용하여 경주를 진행합니다.
     * 각 자동차의 전진을 시도한 후, 시도 결과를 출력합니다.
     */
    private static void progressRace() {
        System.out.println("실행 결과");
        for (int i = 0; i < progressCount; i++) {
            moveForward();
            printStates();
        }
    }

    /**
     * 각 자동차의 전진을 한 차례 시도합니다.
     * 전진 조건은 무작위 값이 일정 수치 이상인 경우입니다.
     */
    private static void moveForward() {
        for (String name: stateMap.keySet()) {
            if(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) >= MOVING_FORWARD) {
                stateMap.put(name, stateMap.get(name) + 1);
            }
        }
    }

    /**
     * 현재 각 자동차의 상황(전진 횟수)을 출력합니다.
     */
    private static void printStates() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : stateMap.entrySet()) {
            stringBuilder.append(entry.getKey()).append(" : ");
            stringBuilder.append("-".repeat(Math.max(0, entry.getValue())));
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder.toString());
    }

    /**
     * 경주를 모두 마친 후, 경주의 우승자를 탐색합니다.
     */
    private static List<String> searchWinner() {
        List<String> winnerList = new ArrayList<>();

        int winnerMoveForwardCount = getWinnerMoveForwardCount();
        for (String name: stateMap.keySet()) {
            if(stateMap.get(name) == winnerMoveForwardCount) {
                winnerList.add(name);
            }
        }

        return winnerList;
    }

    /**
     * 경주의 우승자가 전진한 횟수를 반환합니다.
     * @return 경주 우승자의 전진 횟수
     */
    private static int getWinnerMoveForwardCount() {
        int result = 0;

        for (String name: stateMap.keySet()) {
            result = Math.max(result, stateMap.get(name));
        }

        return result;
    }

    /**
     * 경주 우승자 명단을 통해 최종 우승자를 출력합니다.
     * @param winners 경주 우승자 명단 List
     */
    private static void printWinners(List<String> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            stringBuilder.append(winners.get(i));
            if (i != winners.size() - 1) {
                stringBuilder.append(", ");
            }
        }

        System.out.println(stringBuilder.toString());
    }
}
