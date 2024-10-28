package racingcar;

import java.util.List;

public class OutputRacing {
    public static void main(String[] args) {
        RandomRaceOrNot RaceResult = new RandomRaceOrNot();
        RaceResult.performRace();

        String[] carList = RaceResult.getCarList();
        List<StringBuilder> progressList = RaceResult.getProgressList();

        System.out.println("실행 결과");
        for (int i = 0; i < carList.length; i++) {
                System.out.println(carList[i] + " : " + progressList.get(i).toString());
            }

        String winners = OutputWinner.findWinners(carList, progressList);
        System.out.println("최종 우승자 : " + winners);
    }
}

