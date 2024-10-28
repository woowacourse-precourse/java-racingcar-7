package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.model.CarInfo;
import racingcar.model.CarNameDelimiter;
import racingcar.model.RandomUtils;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.controller.CarRaceController.endGame;
import static racingcar.controller.CarStatusController.printCarStatus;


public class FunctionTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    CarNameDelimiter carNameDelimiter = new CarNameDelimiter();


    @Test
    void 자동차_이름_분리_테스트() {
        String[] nameList = {"pobi", "woni", "jun"};
        String[] result = carNameDelimiter.NameDelimiter("pobi,woni,jun");

        Assertions.assertArrayEquals(nameList, result);
    }


    @Test
    void 랜덤_숫자_전진조건_테스트() {
        CarInfo testCar = new CarInfo("test1");
        testCar.moveCount = 0;
        long randomNum = 6;
        long validateNumber = 1;
        RandomUtils.validRandomNumber(randomNum, testCar);
        Assertions.assertEquals(validateNumber, testCar.moveCount);

    }

    @Test
    void 주차_별_경주_결과_테스트() {
        ArrayList<CarInfo> participantCars = new ArrayList<>();
        CarInfo test1 = new CarInfo("test1");
        CarInfo test2 = new CarInfo("test2");
        test1.moveCount = 1;
        test2.moveCount = 0;
        participantCars.add(test1);
        participantCars.add(test2);
        printCarStatus(participantCars);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream resultOutput = System.out;
        System.setOut(new PrintStream(output));

        try {
            printCarStatus(participantCars);

            String expectedResult = "test1 : -\n" + "test2 :";
            String actualResult = output.toString().trim();

            Assertions.assertEquals(expectedResult, actualResult);
        } finally {
            System.setOut(resultOutput);
        }

    }

    @Test
    void 공동_우승자_테스트() {
        ArrayList<CarInfo> winnerRacers = new ArrayList<>();
        CarInfo test1 = new CarInfo("test1");
        CarInfo test2 = new CarInfo("test2");
        winnerRacers.add(test1);
        winnerRacers.add(test2);
        endGame(winnerRacers);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream resultOutput = System.out;
        System.setOut(new PrintStream(output));

        try {
            endGame(winnerRacers);

            String expectedResult = "최종 우승자 : " + "test1, test2";
            String actualResult = output.toString().trim();

            Assertions.assertEquals(expectedResult, actualResult);
        } finally {
            System.setOut(resultOutput);
        }

    }

    @Test
    void 단독_우승자_테스트() {
        ArrayList<CarInfo> winnerRacer = new ArrayList<>();
        CarInfo test1 = new CarInfo("test1");
        winnerRacer.add(test1);
        endGame(winnerRacer);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream resultOutput = System.out;
        System.setOut(new PrintStream(output));

        try {
            endGame(winnerRacer);

            String expectedResult = "최종 우승자 : " + "test1";
            String actualResult = output.toString().trim();

            Assertions.assertEquals(expectedResult, actualResult);
        } finally {
            System.setOut(resultOutput);
        }

    }

    @Test
    void 자동차이름_공백_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차이름_구분자_공백_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(", , ,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차이름_구분자_사이_공백_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(", , ,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 자동차이름_길이_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("sldkfjlk, abd", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    void 구분자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(";", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_다른_구분자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi;woni;jun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun", " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 한글_이름_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("한명,두명", "1");
                    assertThat(output()).contains("한명 : -", "두명 : ", "최종 우승자 : 한명");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 공동_우승_테스트() {
        assertSimpleTest(() -> {
            run("pobi,woni,jun", "0");
            assertThat(output()).contains("최종 우승자 : " + "pobi, woni, jun");
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
