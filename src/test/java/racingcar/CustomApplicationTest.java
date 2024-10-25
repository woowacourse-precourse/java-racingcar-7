package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.CarService;

public class CustomApplicationTest {

    @Test
    void 자동차_참가자_변환() throws Exception {
        //given
        String[] carNames = {"c", "s", "w"};

        //when
        Method method = CarService.class.getDeclaredMethod("convertToCarList", String[].class);
        method.setAccessible(true);
        List<Car> participants = (List<Car>) method.invoke(null, (Object) carNames);

        //then
        assertEquals(3, participants.size(), "맞음");
        assertEquals("c", participants.get(0).getName(), "첫번째 자동차 이름");
        assertEquals("s", participants.get(1).getName(), "두번째 자동차 이름");
        assertEquals("w", participants.get(2).getName(), "세번째 자동차 이름");
    }

}
