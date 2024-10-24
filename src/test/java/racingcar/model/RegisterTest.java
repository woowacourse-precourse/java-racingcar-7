package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RegisterTest {

    @Test
    void 자동차_리스트_등록_리스트_길이_확인() {
        Register register = new Register();
        ArrayList<String> cars = new ArrayList<>(Arrays.asList("진용", "진용2", "진용3"));

        register.carListUp(cars);

        Assertions.assertThat(register.carList.size()).isEqualTo(3);
    }

    @Test
    void 자동차_리스트_등록_이름_초기화_확인() {
        Register register = new Register();
        ArrayList<String> cars = new ArrayList<>(Arrays.asList("진용", "진용2", "진용3"));

        register.carListUp(cars);

        Assertions.assertThat(register.carList)
                .extracting("name")
                .containsExactly("진용", "진용2", "진용3");
    }

    @Test
    void 자동차_리스트_등록_전진_횟수_초기화_확인() {
        Register register = new Register();
        ArrayList<String> cars = new ArrayList<>(Arrays.asList("진용", "진용2", "진용3"));

        register.carListUp(cars);

        Assertions.assertThat(register.carList)
                .extracting("distance")
                .containsExactly(0, 0, 0);
    }

}