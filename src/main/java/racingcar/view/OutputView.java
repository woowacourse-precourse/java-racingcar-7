package racingcar.view;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;

public class OutputView {
    //----- 싱글톤 패턴 적용 -----//
    private static final OutputView instance = new OutputView();
    private OutputView(){}
    public static OutputView getInstance() {
        return instance;
    }
    //------------------------//

    public void displayResultByLap(Race race, BufferedWriter bw) throws IOException {
        int len = race.getCarsCount();

        for (int i = 0; i < len; i++) {
            Car car = race.getCars().get(i);
            int carMovement = car.getMoveCount();

            bw.write(car.getName() + " : " + move(carMovement));
            bw.newLine();
        }
        bw.newLine();
    }

    private String move(int movement) {
        return "-".repeat(Math.max(0, movement));
    }

    public void displayWinner(int max, List<Car> cars, BufferedWriter bw) throws IOException{
        List<String> winner = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMoveCount() == max) {
                winner.add(car.getName());
            }
        }
        String winners = String.join(", ", winner);
        bw.write("최종 우승자 : " + winners);
    }
}
