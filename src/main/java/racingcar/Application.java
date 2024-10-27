package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    static String[] cars;
    static StringBuilder[] carsRaceProgress;
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        try {
            cars = carNameSplitter(input);
        } catch (IllegalArgumentException e) {
            throw e;
        }

        carsRaceProgress = new StringBuilder[cars.length];
        for(int i=0; i<carsRaceProgress.length; i++) {
            carsRaceProgress[i] = new StringBuilder();
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int round;
        try{
            round = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 정수를 입력해주세요.");
        }

        for(int i=0; i<round; i++) {
            doRace();
        }
        // 모든 라운드가 끝난 뒤, 최종 우승자를 출력한다.
        printRaceWinner();
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
    public static void doRace() {
        for (int i = 0; i < carsRaceProgress.length; i++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                // 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우 자동차는 전진
                carsRaceProgress[i].append('-');
            }
        }
        printRaceRound();
        // 각 차수별 실행 결과의 구분을 위해 빈 줄을 하나 출력한다.
        System.out.println();
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
