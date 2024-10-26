package racingcar;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Race 의 출력을 담당하는 객체
 */
public class RaceDisplay {
    private static BufferedWriter output;

    /**
     * 자동차 경기의 현재 상태를 출력
     * 자동차의 현재위치 나타내는 String 을 RacingCar.getCurrentState 으로 받아와서 출력
     *
     * @param carRace 출력할 경기 객체
     * @throws IOException
     */
    public static void displayCurrentState(CarRace carRace) throws IOException {
        ArrayList<RacingCar> participants = carRace.getParticipants();
        if (output == null) {
            output = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        for (RacingCar car : participants) {
            output.write(car.getCurrentState());
        }
        output.newLine();
    }

    /**
     * BufferedWriter 싱글톤 객체를 프로그램 중간에서 닫을수 있게 옵션을 부여
     *
     * @throws IOException
     */
    public void close() throws IOException {
        /* 자바의 경우 null 체크를 알아서 해줌 */
        output.close();
    }

    public RaceDisplay() {
    }
}
