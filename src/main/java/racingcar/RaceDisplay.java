package racingcar;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Race 의 출력을 담당하는 객체
 */
public class RaceDisplay {
    private static BufferedWriter output = null;

    private static void checkOutput() {
        if (output == null) {
            output = new BufferedWriter(new OutputStreamWriter(System.out));
        }
    }

    public static void displayStart() throws IOException {
        checkOutput();
        output.newLine();
        output.write("실행결과");
        output.newLine();
    }
    /**
     * 자동차 경기의 현재 상태를 출력
     * 자동차의 현재위치 나타내는 String 을 RacingCar.getCurrentState 으로 받아와서 출력
     *
     * @param carRace 출력할 경기 객체
     * @throws IOException
     */
    public static void displayCurrentState(CarRace carRace) throws IOException {
        ArrayList<RacingCar> participants = carRace.getParticipants();
        checkOutput();

        for (RacingCar car : participants) {
            output.write(car.getCurrentState());
            output.newLine();
        }
        output.newLine();
    }

    /**
     * BufferedWriter 싱글톤 객체를 프로그램 중간에서 닫을수 있게 옵션을 부여
     *
     * @throws IOException
     */
    public static void close() throws IOException {
        /* 자바의 경우 null 체크를 알아서 해줌 */
        output.close();
        output = null;
    }

    /**
     * 우승자를 쉼표로 구분하여 출력하는 함수
     *
     * @param carRace 출력할 경주 객체
     * @throws IOException
     */
    public static void displayWinner(CarRace carRace) throws IOException {
        if (!carRace.isRaceFinished()) {
            return ;
        }
        checkOutput();
        output.write("최종 우승자 : ");
        ArrayList<RacingCar> winners = carRace.getWinners();
        String concatenatedNames = winners.stream()
                .map(RacingCar::getName)  // Assuming your Car class has a getName() method
                .collect(Collectors.joining(", "));
        output.write(concatenatedNames);
        output.newLine();
    }

    public RaceDisplay() {
    }
}
