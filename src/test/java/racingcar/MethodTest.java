package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MethodTest {
    @Test
    @DisplayName("입력이 정상적으로 들어오는지")
    void test_1() {
        String given = "pobi,woni,jun";
        String expected = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(given.getBytes()));
        String result = Application.getInput();
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("문자열이 정상적으로 분리 되는지")
    void test_2() {
        String given = "pobi,woni,jun";

        List<String> result = Application.divideMember(given);

        assertThat(result).hasSize(3).containsOnly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("문자열을 분리 할때 특정 이름이 5글자 이상이면 IllegalArguementException을 발생시킨다")
    void test_21() {
        String given = "morethanfive,woni,jun";

        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> Application.divideMember(given));
        assertEquals(illegalArgumentException.getMessage(), "자동차 이름은 5글자 이상으로 작성할수 없습니다.");

    }

    @Test
    @DisplayName("게임 한번 플레이 진행")
    void test_3() {
        List<Integer> given = new ArrayList<>() {{
            add(0);
            add(0);
            add(0);
            add(0);
            add(0);
        }};

        Application.raceOneTime(given);

        //TODO: 랜덤값으로 인하여 정확하게 테스트를 진행하기 어려우니 refactoring 하여, 테스트가 가능한 코드가 되도록 변경
        assertThat(given).hasSize(5);
    }

    @Test
    @DisplayName("개별 게임에 대한 결과 표시")
    void test_4() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        PrintStream standardOut = System.out;
        System.setOut(new PrintStream(outputStreamCaptor));

        List<Integer> givenCount = new ArrayList<>() {{
            add(1);
            add(3);
            add(2);
            add(0);
            add(4);
        }};
        List<String> givenName = new ArrayList<>() {{
            add("nameA");
            add("nameB");
            add("nameC");
            add("nameD");
            add("nameE");
        }};

        Application.printEachRaceResult(givenName, givenCount);

        assertEquals("nameA : -\nnameB : ---\nnameC : --\nnameD : \nnameE : ----", outputStreamCaptor.toString().trim());
        System.setOut(standardOut);
    }

    @DisplayName("숫자 리스트 중에서 최대의 숫자의 인덱스를 가져오기 (여러개일경우 )")
    @Test
    void test_5() {
        List<Integer> given = new ArrayList<>() {{
            add(0);
            add(0);
            add(13);
            add(23);
            add(23);
            add(23);
        }};

        List<Integer> result = Application.getMaxIndexList(given);

        assertThat(result).hasSize(3).containsExactly(3, 4, 5);
    }

    @DisplayName("숫자 리스트 중에서 최대의 숫자의 인덱스를 가져오기 (없을경우)")
    @Test
    void test_6() {
        List<Integer> given = new ArrayList<>();

        List<Integer> result = Application.getMaxIndexList(given);

        assertThat(result).hasSize(0);
    }

    @DisplayName("숫자 리스트 중에서 최대의 숫자의 인덱스를 가져오기 (한개)")
    @Test
    void test_7() {
        List<Integer> given = new ArrayList<>() {{
            add(0);
            add(0);
            add(13);
            add(23);
        }};

        List<Integer> result = Application.getMaxIndexList(given);

        assertThat(result).hasSize(1).containsExactly(3);
    }

    @DisplayName("인덱스에 해당하는 우승자를 출력하기(우승자가 여러명일 경우)")
    @Test
    void test_8() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        PrintStream standardOut = System.out;
        System.setOut(new PrintStream(outputStreamCaptor));

        List<String> givenNameList = new ArrayList<>() {{
            add("choi");
            add("lee");
            add("kim");
            add("park");
            add("ryu");
            add("han");
        }};

        List<Integer> givenIndexList = new ArrayList<>() {{
            add(1);
            add(3);
            add(5);
        }};

        Application.printWinner(givenIndexList, givenNameList);

        assertEquals("최종 우승자 : lee,park,han", outputStreamCaptor.toString().trim());
        System.setOut(standardOut);

    }

    @DisplayName("인덱스에 해당하는 우승자를 출력하기(우승자가 한명일 경우)")
    @Test
    void test_9() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        PrintStream standardOut = System.out;
        System.setOut(new PrintStream(outputStreamCaptor));

        List<String> givenNameList = new ArrayList<>() {{
            add("choi");
            add("lee");
            add("kim");
            add("park");
            add("ryu");
            add("han");
        }};

        List<Integer> givenIndexList = new ArrayList<>() {{
            add(0);
        }};

        Application.printWinner(givenIndexList, givenNameList);

        assertEquals("최종 우승자 : choi", outputStreamCaptor.toString().trim());
        System.setOut(standardOut);
    }
}
