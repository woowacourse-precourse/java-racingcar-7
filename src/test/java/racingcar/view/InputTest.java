//package racingcar.view;
//import camp.nextstep.edu.missionutils.Console;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import racingcar.view.Input;
//import racingcar.utils.CustomErrorMessage;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//
//class InputTest {
//
//    private final InputStream originalIn = System.in;
//
//    @BeforeEach
//    void setUp() {
//        // 테스트 시작 전 원래 입력 스트림을 저장
//        System.setIn(originalIn);
//    }
//
////    @AfterEach
////    void tearDown() {
////        // 테스트가 끝나면 입력 스트림을 원래 상태로 복구
////        System.setIn(originalIn);
////    }
////
////    private void provideInput(String data) {
////        InputStream in = new ByteArrayInputStream(data.getBytes());
////        System.setIn(in);
////    }
////
////    @Test
////    void getCarName_유효한_입력() {
////        // 유효한 자동차 이름 입력을 설정
////        provideInput("pobi,java\n");
////
////        Input input = new Input();
////        List<String> carNames = input.getCarName();
////
////        assertThat(carNames).containsExactly("pobi", "java");
////    }
//
//    @Test
//    void getCarName_5자를_초과하는_입력() {
//        // 5자를 초과하는 자동차 이름 입력을 설정
//        provideInput("pobi,javajava\n");
//
//        Input input = new Input();
//
//        assertThatThrownBy(input::getCarName)
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining(CustomErrorMessage.INVALID_CAR_NAME);
//    }
//}
//
////    @Test
////    void getRound_유효한_숫자_입력() {
////        // 유효한 시도 횟수 입력을 설정
////        provideInput("5\n");
////
////        Input input = new Input();
////        int round = input.getRound();
////
////        assertThat(round).isEqualTo(5);
////    }
////
////    @Test
////    void getRound_유효하지_않은_숫자_입력() {
////        // 유효하지 않은 시도 횟수 입력 (0 이하)를 설정
////        provideInput("0\n");
////
////        Input input = new Input();
////
////        assertThatThrownBy(input::getRound)
////                .isInstanceOf(IllegalArgumentException.class)
////                .hasMessageContaining(CustomErrorMessage.INVALID_ROUND);
//
