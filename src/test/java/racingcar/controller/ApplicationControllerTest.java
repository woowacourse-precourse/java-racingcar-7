package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationControllerTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }

    private ByteArrayOutputStream setByyeArrayStream(String test){
        System.setIn(new ByteArrayInputStream(test.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        return outputStream;
    }

    private String getTotalOutput(String userInput, List<Integer> fixRandomValue){
        List<String> carsName = Arrays.asList(userInput.split("\n")[0].split(","));
        int tryNum = Integer.parseInt(userInput.split("\n")[1]);
        String output = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n" +
                "시도할 횟수는 몇 회인가요?\n\n" +
                "실행 결과\n";
        for(int i = 1; i <= tryNum; i++){
            output += getRaceDisplay(carsName, fixRandomValue, i);
        }
        output += "최종 우승자 : ";
        boolean checkFirstWinner = true;
        for(int i = 0; i<carsName.size(); i++){
            if(fixRandomValue.get(i)>3 && !checkFirstWinner){
                output += ", " + carsName.get(i);
            }
            if(fixRandomValue.get(i)>3 && checkFirstWinner){
                output += carsName.get(i);
                checkFirstWinner = false;
            }
        }
        if(checkFirstWinner){
            for(int i = 0; i < carsName.size()-1; i++){
                output += carsName.get(i) + ", ";
            }
            output += carsName.get(carsName.size()-1);
        }
        output += "\n";
        return output;
    }

    private String getRaceDisplay(List<String> carsName, List<Integer> fixRandomValu, int round){
        String output = "";
        for(int i = 0; i < carsName.size(); i++){
            output += carsName.get(i) + " : ";
            if(fixRandomValu.get(i) >= 4){
                output += "-".repeat(round);
            }
            output += "\n";
        }
        output += "\n";
        return output;
    }

    @ParameterizedTest
    @DisplayName("자동차가 3명일 때 우승자가 1명일 경우 정상동작 확인")
    @ValueSource(strings = {"po,bi,pobi\n2\n", "po,bi,pobi\n4\n", "popop,bbi,p\n2\n", "popop,bbi,p\n4\n"})
    void checkPlayRace3Car1Winner(String test){
        ByteArrayOutputStream outputStream = setByyeArrayStream(test);

        List<Integer> fixRandomValue = Arrays.asList(3, 3, 4);
        String output = getTotalOutput(test, fixRandomValue);

        new ApplicationController(fixRandomValue);

        assertEquals(output, outputStream.toString());
    }
    @ParameterizedTest
    @DisplayName("자동차가 3명일 때 우승자가 2명일 경우 정상동작 확인")
    @ValueSource(strings = {"po,bi,pobi\n2\n", "po,bi,pobi\n4\n", "popop,bbi,p\n2\n", "popop,bbi,p\n4\n"})
    void checkPlayRace3Car2Winner(String test){
        ByteArrayOutputStream outputStream = setByyeArrayStream(test);

        List<Integer> fixRandomValue = Arrays.asList(3, 4, 4);
        String output = getTotalOutput(test, fixRandomValue);

        new ApplicationController(fixRandomValue);

        assertEquals(output, outputStream.toString());
    }
    @ParameterizedTest
    @DisplayName("자동차가 3명일 때 우승자가 3명일 경우 정상동작 확인")
    @ValueSource(strings = {"po,bi,pobi\n2\n", "po,bi,pobi\n4\n", "popop,bbi,p\n2\n", "popop,bbi,p\n4\n"})
    void checkPlayRace3Car3Winner(String test){
        ByteArrayOutputStream outputStream = setByyeArrayStream(test);

        List<Integer> fixRandomValue = Arrays.asList(4, 4, 4);
        String output = getTotalOutput(test, fixRandomValue);

        new ApplicationController(fixRandomValue);

        assertEquals(output, outputStream.toString());
    }
    @ParameterizedTest
    @DisplayName("자동차가 3명일 때 전부 정지할 경우 확인")
    @ValueSource(strings = {"po,bi,pobi\n2\n", "po,bi,pobi\n4\n", "popop,bbi,p\n2\n", "popop,bbi,p\n4\n"})
    void checkPlayRace3CarStop(String test){
        ByteArrayOutputStream outputStream = setByyeArrayStream(test);

        List<Integer> fixRandomValue = Arrays.asList(1, 1, 1);
        String output = getTotalOutput(test, fixRandomValue);

        new ApplicationController(fixRandomValue);

        assertEquals(output, outputStream.toString());
    }

    @ParameterizedTest
    @DisplayName("사용자 입력이 예외상황일 경우 예외 확인")
    @ValueSource(strings = {"popppp,bi,pobi\n1\n", "po,bi,pobi\n0\n", "popop,bbi,p\n101\n", "김김,bbi,p\n4\n"})
    void checkUserInputEroor(String test){
        ByteArrayOutputStream outputStream = setByyeArrayStream(test);

        List<Integer> fixRandomValue = Arrays.asList(4, 4, 4);

        assertThatThrownBy(() -> new ApplicationController(fixRandomValue))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
