package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceCarTest extends NsTest {

    @ParameterizedTest
    @CsvSource({"'노범석,김수한무거북이'","'java,abracadabra'","111111,222"})
    @DisplayName("한글,영문,숫자로 5글자 이상이 입력으로 주어질 때 테스트")
    void testNameLength(String input){
        RaceCar raceCar = new RaceCar();
        assertThatThrownBy(()->{raceCar.splitNames(input);})
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"'one'","''"})
    @DisplayName("경주 횟수로 숫자 외 입력이 들어오는 경우")
    void testRaceCount(String input){
        RaceCar raceCar = new RaceCar();
        assertThatThrownBy(()->{raceCar.isValidCount(input);})
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Override
    public void runMain() {
        // Application 클래스의 main 메서드를 실행
        Application.main(new String[]{});
    }
}










//import camp.nextstep.edu.missionutils.test.NsTest;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//
//import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
//import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//
//
//public class RaceCarTest extends NsTest {
//    @DisplayName("콘솔에서 차량 이름을 입력받아 제대로 처리하는지 테스트")
//    @ParameterizedTest
//    @CsvSource({
//            "노범석,장윤미,1",     // 정상 케이스
//            "노범석,장윤미미미,1"  // 예외 케이스 (5글자 초과)
//    })
//    void race(String carNames, String attemptCount) {
//        // 가상의 콘솔 입력 설정 (차량 이름과 시도 횟수 입력)
//        run(carNames, attemptCount);
//
//        // 결과 확인 (예를 들어 콘솔 출력에 포함된 내용이 맞는지 확인)
//        assertThat(output()).contains("경주할 자동차 이름을 입력하세요.");
//    }
//
//
//    @Override
//    public void runMain() {
//        Application.main(new String[]{});
//    }
//
//}
