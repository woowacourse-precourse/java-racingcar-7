package racingcar.view;

import racingcar.model.RacingCar;

import java.util.List;

public class OutputView {
    private static final String DISTANCE_MARK = "-";
    private static final String WINNER_STRING = "최종 우승자 : ";
    private static final String RESULT_PRINTING = "실행 결과";
    public void printResult(List<RacingCar> cars) {
        System.out.println(RESULT_PRINTING);

        for (RacingCar car : cars) {
            System.out.print(car.getName()+" : ");
            printDistanceMark(car.getDistance());
        }
        System.out.println();
    }

    public void printWinner(List <String> winners) {
        System.out.print(WINNER_STRING);
        if (winners.size()==1){
            System.out.println(winners.get(0));
        }
        else if (winners.size()>1){
            for (int i=0; i<winners.size()-1; i++){
                System.out.print(winners.get(i)+", ");
            }
            System.out.println(winners.get(winners.size()-1));
        }
    }

    private void printDistanceMark(int distance) {
        for (int i = 0; i < distance; i++) {
            System.out.print(DISTANCE_MARK);;
        }
        System.out.println();
    }



}
