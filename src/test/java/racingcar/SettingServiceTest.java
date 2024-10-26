package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.service.RacingGameSettingService;

public class SettingServiceTest {
    RacingGameSettingService racingGameSettingService = new RacingGameSettingService();

    @Nested
    class CarNameTest {
        @Test
        public void 자동차_이름은_중복될_수_없다(){
            
        }
    }
}
