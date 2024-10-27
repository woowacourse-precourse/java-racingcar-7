package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        RaceDto data = new RaceDto();
        getInput(data);
        System.out.println(data);

        DataTrans(data);
        StartRace(data);

        CheckResult(data);

        Winner(data);
    }

    public static void getInput(RaceDto data){
        System.out.println("경주할 자동차 이름을 \",\"로 구분하여 입력해주세요 ");
        data.carName = Console.readLine();
        System.out.println("시도할 횟수를 입력해주세요");
        data.num = Integer.parseInt(Console.readLine());
    }

    public static void DataTrans(RaceDto data){
        data.racers = data.carName.split(",");
        validateRacers(data.racers);
        data.forwardNum = new int[data.racers.length];
    }

    private static void validateRacers(String[] racers) {
        for (int i = 0; i < racers.length; i++) {
            racers[i] = racers[i].trim();
            validateRacerLength(racers[i]);
        }
    }

    private static void validateRacerLength(String racer) {
        if (racer.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public static void StartRace(RaceDto data){
        for (int i = 0; i < data.num; i++) {
            moveCars(data);
        }
    }

    private static void moveCars(RaceDto data) {
        for (int j = 0; j < data.racers.length; j++) {
            if (shouldMove()) {
                data.forwardNum[j]++;
            }
        }
    }

    private static boolean shouldMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public static void CheckResult(RaceDto data){
        for (int i = 0; i < data.racers.length; i++){
            System.out.println(data.racers[i] + " : " + "-".repeat(data.forwardNum[i]));
        }
    }

    public static void Winner(RaceDto data){
        int max = findMaxDistance(data.forwardNum);
        int[] winners = findWinners(data, max);
        printWinners(data, winners);
    }

    private static int findMaxDistance(int[] forwardNum) {
        int max = 0;
        for (int distance : forwardNum) {
            if (distance > max) {
                max = distance;
            }
        }
        return max;
    }

    private static int[] findWinners(RaceDto data, int max) {
        int[] winners = new int[data.racers.length];
        int count = 0;
        for (int i = 0; i < data.racers.length; i++) {
            if (data.forwardNum[i] == max) {
                winners[count] = i;
                count++;
            }
        }
        return trimWinners(winners, count);
    }

    private static int[] trimWinners(int[] winners, int count) {
        int[] result = new int[count];
        System.arraycopy(winners, 0, result, 0, count);
        return result;
    }

    private static void printWinners(RaceDto data, int[] winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.length; i++) {
            System.out.print(data.racers[winners[i]]);
            if (i < winners.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}

class RaceDto{
    String carName;
    int num;
    String[] racers;
    int[] forwardNum;
}