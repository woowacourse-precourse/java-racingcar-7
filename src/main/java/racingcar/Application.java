package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    private static final ProgressCarRace progressCarRace = new ProgressCarRace();
    private static final InitMapClass initMapClass = new InitMapClass();
    private static Map<String, Integer> stateMap;
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
        List<String> nameList = initMapClass.splitCarNameString(InputCarNames);
        stateMap = initMapClass.setStateMap(nameList);

        System.out.println("시도할 횟수는 몇 회인가요?");
        progressCount = Integer.parseInt(Console.readLine());
    }

    /**
     * 입력된 값들을 활용하여 경주를 진행합니다.
     * 각 자동차의 전진을 시도한 후, 시도 결과를 출력합니다.
     */
    private static void progressRace() {
        System.out.println("실행 결과");
        for (int i = 0; i < progressCount; i++) {
            progressCarRace.moveForward(stateMap);
            progressCarRace.printStates(stateMap);
        }
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
