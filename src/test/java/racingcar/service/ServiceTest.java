package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ServiceTest {
    private Service service;

    @BeforeEach
    void beforeEach() {
        service = new Service();
    }

    @Test
    void 자동차들이_모두_결과에_반영되는지_확인(){
        //given
        List<String> nameList = Arrays.asList("남석","김남석","김","남","석","김남","석김");
        service.setCarName(nameList);
        //when
        Map<String, String> result = service.playGame();

        //then
        assertNotNull(result);
        assertEquals(nameList.size(), result.size());
    }

    @Test
    void 반복_횟수가_0인_경우(){
        List<String> nameList = Arrays.asList("남석","김남석","김남");
        service.setCarName(nameList);

        Map<String, String> result = service.playGame();

        assertNotNull(result);
        assertEquals(nameList.size(), result.size()); // 전원이 정지한 상태이므로 공동 우승자로 취급되어야 합니다.
    }

}
