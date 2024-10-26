package racingcar.view;

import java.io.BufferedWriter;
import java.io.IOException;
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
}
