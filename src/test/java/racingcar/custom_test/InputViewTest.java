package racingcar.custom_test;

import org.junit.jupiter.api.*;
import racingcar.view.InputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InputViewTest {
    private InputView inputView;

    @BeforeEach //실행 전, inputView Instance 가져오기
    void setUp() {
        inputView = InputView.getInstance();

        // 테스트에 사용할 문자열 사용 ( ,로만 구분되는지,  )
        String input = "car1,   car  2 , c  ar3\n6\n";
        // 입력 문자열을 바이트 배열로 변환
        InputStream in = new ByteArrayInputStream(input.getBytes());
        // InputStream의 바이트 배열을 입력 받은 것으로 모의처리 ( 실제 입력은 System.in )
        System.setIn(in);
    }

    @Test
    @Order(1)
    @DisplayName("입력 확인 테스트")
    void inputViewGetVehicleNameTest(){
        //given

        // 정상 결과 (검사용)
        String[] result = {"car1", "car2", "car3"};

        //when
        String[] vehicleNames = inputView.getVehicleName();

        //then
        assertArrayEquals(result, vehicleNames); // 둘이 동일한 값을 가진 배열인지 확인, 레퍼런스 비교 X (레퍼런스 비교는 assertSame)
        System.setIn(System.in);
    }

    @Test
    @Order(2)
    @DisplayName("시도 횟수 입력 (문자열 -> 숫자) 테스트")
    void inputViewGetMoveCountTest() {
        //given
        int result1 = 6;
        //when
        int moveCount = inputView.getMoveCount();
        //then
        Assertions.assertEquals(moveCount, result1);
    }
}
