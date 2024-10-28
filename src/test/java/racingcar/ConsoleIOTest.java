package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.ErrorMessage.*;


public class ConsoleIOTest {

    @AfterEach
    void tearDown() throws Exception {
        Console.close();
    }

    @Test
    void 자동차_이름_입력값에_포함된_공백문자_제거() {

        //given
        String args = "pobi,woni, jun";
        System.setIn(new ByteArrayInputStream(args.getBytes()));

        //then
        assertThat(Application.getCarNames()).isEqualTo(List.of("pobi", "woni", "jun"));
    }

    @Test
    void 자동차_이름_검증_실패_5글자_초과() {

        //given
        String args = "pobiiii, aby";
        System.setIn(new ByteArrayInputStream(args.getBytes()));

        //then
        assertThatThrownBy(Application::getCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_LENGTH_ERROR);
    }

    @Test
    void 자동차_이름_검증_실패_참여_빈문자열() {

        //given
        String args = " ";
        System.setIn(new ByteArrayInputStream(args.getBytes()));

        //then
        assertThatThrownBy(Application::getCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_SHOULD_NOT_BLANK);
    }

    @Test
    void 자동차_이름_검증_실패_빈문자열() {

        //given
        String args = ",pobi";
        System.setIn(new ByteArrayInputStream(args.getBytes()));

        //then
        assertThatThrownBy(Application::getCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_SHOULD_NOT_BLANK);
    }

    @Test
    void 시도_횟수_입력값_검증_성공() {

        //given
        String args = "5";
        System.setIn(new ByteArrayInputStream(args.getBytes()));

        //then
        assertThat(Application.getTryCount()).isEqualTo(5);
    }

    @Test
    void 시도_횟수_입력값_검증_실패() {

        //given
        String args = "0";
        System.setIn(new ByteArrayInputStream(args.getBytes()));

        //then
        assertThatThrownBy(Application::getTryCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TRY_COUNT_ERROR);
    }
}
