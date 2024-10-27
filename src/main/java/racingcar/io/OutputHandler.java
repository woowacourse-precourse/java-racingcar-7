package racingcar.io;

import java.util.List;

public abstract class OutputHandler<T> {
    public void print(String message) {
        System.out.println(message);
    }

    public abstract void printRaceResult(List<T> racers);

    public void printWinner(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}
