package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CarNameTest {
    private static Car testCar;

    @BeforeAll
    static void initAll() {
        testCar = new Car();
    }

    @Test
    @DisplayName("구분자 두 개,, 예외")
    void doubleSeparator(){
        //given
        final InputStream input = new ByteArrayInputStream("하나,둘,,셋".getBytes());
        System.setIn(input);

        //when
        final Throwable thrown = catchThrowable(() -> {
            testCar.set();
        });

        //then
        assertThat(thrown)
                .as("doubleSeparator 예외 처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자는 한 개씩만 사용할 수 있습니다.");
    }

    @Test
    @DisplayName("마지막 구분자 뒤에 이름 없으면 예외")
    void lastBlank(){
        //given
        final InputStream input = new ByteArrayInputStream("하나,둘,".getBytes());
        System.setIn(input);

        //when
        final Throwable thrown = catchThrowable(() -> {
            testCar.set();
        });

        //then
        assertThat(thrown)
                .as("lastBlank 예외 처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자 뒤에는 자동차 이름이 지정되어야 합니다.");
    }

    @Test
    @DisplayName("\\s 공백 예외")
    void blank(){
        //given
        final InputStream input = new ByteArrayInputStream("하나, 둘,셋".getBytes());
        System.setIn(input);

        //when
        final Throwable thrown = catchThrowable(() -> {
            testCar.set();
        });

        //then
        assertThat(thrown)
                .as("blank 예외 처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백은 자동차의 이름에 포함될 수 없습니다.");
    }

    @Test
    @DisplayName("차 대수 5 초과 예외")
    void count(){
        //given
        final InputStream input = new ByteArrayInputStream("하나,둘,셋,넷,다섯,여섯".getBytes());
        System.setIn(input);

        //when
        final Throwable thrown = catchThrowable(() -> {
            testCar.set();
        });

        //then
        assertThat(thrown)
                .as("count 예외 처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차는 최대 5대까지 출전 가능합니다.");
    }

    @Test
    @DisplayName("차 이름의 길이가 5 초과 예외")
    void nameLen(){
        //given
        final InputStream input = new ByteArrayInputStream("여섯글자예요".getBytes());
        System.setIn(input);

        //when
        final Throwable thrown = catchThrowable(() -> {
            testCar.set();
        });

        //then
        assertThat(thrown)
                .as("nameLen 예외 처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 최대 5자입니다.");
    }

    @Test
    @DisplayName("차 이름 중복 예외")
    void duplication(){
        //given
        final InputStream input = new ByteArrayInputStream("하나,둘,하나".getBytes());
        System.setIn(input);

        //when
        final Throwable thrown = catchThrowable(() -> {
            testCar.set();
        });

        //then
        assertThat(thrown)
                .as("duplication 예외 처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("carMap에 자동차 추가")
    void putCarMap(){
        //given
        final InputStream input = new ByteArrayInputStream("하나,둘,셋".getBytes());
        final HashMap<String, Integer> testMap = new HashMap<>();
        testMap.put("하나", 0);
        testMap.put("둘", 0);
        testMap.put("셋", 0);
        System.setIn(input);

        //when
        testCar.set();

        //then
        assertThat(testCar.carMap).isEqualTo(testMap);
    }

    // camp.nextstep.edu.missionutils.Console에서 scanner가 static이다.
    // readLine()의 getInstance()에서 scanner가 null이 아니면 scanner 객체를 그대로 반환하고 nextLine()을 반환한다.
    // 따라서 input값을 새롭게 할당하기 위해 scanner을 null로 만들어야 한다.
    @AfterEach
    void closeConsole() {
        Console.close();
    }
}
