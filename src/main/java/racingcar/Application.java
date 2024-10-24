package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    static String[] cars;
    static StringBuilder[] carsRaceProgress;
    public static void main(String[] args) {

    }
    public static String[] carNameSplitter(String input) {
        String[] result = input.split(",");
        for (String s : result) {
            if (s.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 한다.");
            }
        }
        return result;
    }
    public static void doRace(int round) {
        for(int i=0; i<round; i++) {
            for (int j = 0; j < carsRaceProgress.length; j++) {
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    // 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우 자동차는 전진
                    carsRaceProgress[j].append('-');
                }
            }
            printRaceRound();
            // 각 차수별 실행 결과의 구분을 위해 빈 줄을 하나 출력한다.
            System.out.println();
        }
        // 모든 라운드가 끝난 뒤, 최종 우승자를 출력한다.
        printRaceWinner();
    }
    public static void printRaceRound() {
        for(int i=0; i<cars.length; i++) {
            System.out.printf("%s : %s\n", cars[i], carsRaceProgress[i]);
        }
    }
    public static void printRaceWinner() {
        // 최종 우승 자동차의 위치 winnerProgress
        int winnerProgress = 0;
        // 최종 우승 자동차(들)의 index 저장할 리스트 winnerList
        List<Integer> winnerList = new ArrayList<>();

        for(int i=0; i<carsRaceProgress.length; i++) {
            int pos = carsRaceProgress[i].length();
            if(pos > winnerProgress) {
                winnerProgress = pos;
                winnerList.clear();
                winnerList.add(i);
            } else if(pos == winnerProgress) {
                winnerList.add(i);
            }
        }

        System.out.printf("최종 우승자 : %s", winnerList.stream().map(i -> cars[i])
                .collect(Collectors.joining(", ")));
    }
}
