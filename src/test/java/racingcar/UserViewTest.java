package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class UserViewTest {
    final OutputStream outputStream = new ByteArrayOutputStream();

    @Test
    @DisplayName("입력된 carName 반환")
    void readCarName(){
        //given
        setInput("안녕하세요!");
        String result = "안녕하세요!";

        //when
        String test = UserView.readCarName();

        //then
        assertThat(test).isEqualTo(result);
    }

    @Test
    @DisplayName("입력된 attemptNum 반환")
    void readAttemptNum(){
        //given
        setInput("5");
        String result = "5";

        //when
        String test = UserView.readAttemptNum();

        //then
        assertThat(test).isEqualTo(result);
    }

    @Test
    @DisplayName("실행 결과 가이드 출력")
    void printResultGuide(){
        //given
        String result = "실행 결과";
        System.setOut(new PrintStream(outputStream));

        //when
        UserView.printResultGuide();
        String test = getOutput();

        //then
        assertThat(test).contains(result);
    }

    @Test
    @DisplayName("자동차별 시도 결과 출력")
    void printPlayerAttemptResult(){
        //given
        String result = "하나 : ---";
        String testName = "하나";
        int testNum = 3;
        System.setOut(new PrintStream(outputStream));

        //when
        UserView.printPlayerAttemptResult(testName, testNum);
        String test = getOutput();

        //then
        assertThat(test).isEqualTo(result);
    }

    @Test
    @DisplayName("최종 우승자 단일 출력")
    void printSoloWinner(){
        //given
        String result = "최종 우승자 : 쥬";
        ArrayList<String> winner = new ArrayList<>(1);
        winner.add("쥬");
        System.setOut(new PrintStream(outputStream));

        //when
        UserView.printWinner(winner);
        String test = getOutput();

        //then
        assertThat(test).isEqualTo(result);
    }

    @Test
    @DisplayName("최종 우승자 다수 출력")
    void printJointWinner(){
        //given
        String result = "최종 우승자 : 쥬, 하, 영";
        ArrayList<String> winner = new ArrayList<>(3);
        winner.add("쥬");
        winner.add("하");
        winner.add("영");
        System.setOut(new PrintStream(outputStream));

        //when
        UserView.printWinner(winner);
        String test = getOutput();

        //then
        assertThat(test).isEqualTo(result);
    }


    private void setInput(String input){
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    private String getOutput(){
        return outputStream.toString().trim();
    }

    // camp.nextstep.edu.missionutils.Console에서 scanner가 static이다.
    // readLine()의 getInstance()에서 scanner가 null이 아니면 scanner 객체를 그대로 반환하고 nextLine()을 반환한다.
    // 따라서 input값을 새롭게 할당하기 위해 scanner을 null로 만들어야 한다.
    @AfterEach
    void closeConsole() {
        Console.close();
    }
}
