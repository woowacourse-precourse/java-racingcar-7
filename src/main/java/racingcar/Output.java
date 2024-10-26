package racingcar;

import java.util.List;

public class Output {
    public static void printExecuteResult() {
        printSpace();
        System.out.println("실행 결과");
    }

    public static void printSpace() {
        System.out.println();
    }

    public static void printCarPosition(Car car){
        String position = "";
        for (int i = 0; i < car.getPosition(); i++) {
            position = position.concat("-");
        }
        System.out.println(car.getName() + " : " + position);
    }

    public static void printWinner(List<String> winnerName) {
        if(winnerName.size() == 1){
            System.out.println("최종 우승자 : " + winnerName.getFirst());
        }else{
            System.out.println("최종 우승자 : " + String.join(", ", winnerName));
        }
    }
}
