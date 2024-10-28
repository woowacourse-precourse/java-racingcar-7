package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.ScoreEntry;

public class Output {

    public void outputRoundProcess(List<ScoreEntry> scoreBoard){

        for(ScoreEntry scoreEntry : scoreBoard){
            printEachCar(scoreEntry);
        }

        System.out.println();
    }

    private void printEachCar(ScoreEntry scoreEntry){
        System.out.print(scoreEntry.getCarName() + " : ");
        for(int forwardCount= scoreEntry.getForwardCount();forwardCount>=0;forwardCount--){
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinners(List<Car> winnerList) {
        String winners = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winners);
    }
}
