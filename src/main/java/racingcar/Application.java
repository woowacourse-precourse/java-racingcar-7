package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

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
            for(int j=0; j<cars.length; j++) {
                if(Randoms.pickNumberInRange(0, 9) >= 4) {
                    // 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우 자동차는 전진
                    carsRaceProgress[j].append('-');
                }
            }
            printRaceRound();
            // 각 차수별 실행 결과의 구분을 위해 빈 줄을 하나 출력한다.
            System.out.println();
        }
    }
    public static void printRaceRound() {
        for(int i=0; i<cars.length; i++) {
            System.out.printf("%s : %s\n", cars[i], carsRaceProgress[i]);
        }
    }
}
