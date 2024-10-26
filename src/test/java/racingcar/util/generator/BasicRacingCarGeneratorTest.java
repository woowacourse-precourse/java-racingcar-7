package racingcar.util.generator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

public class BasicRacingCarGeneratorTest {
    private final BasicRacingCarGenerator basicRacingCarGenerator;

    public BasicRacingCarGeneratorTest() {
        this.basicRacingCarGenerator = new BasicRacingCarGenerator();
    }

    @Test
    public void 이름을_부여한_자동차_생성_테스트(){
        assertSimpleTest(() ->{
            // given
            List<String> names = List.of("창의", "민규", "상현");

            // when
            List<RacingCar> result = basicRacingCarGenerator.generateCar(names);

            // then
            assertThat(result)
                    .extracting(RacingCar::getName)
                    .usingRecursiveComparison()
                    .isEqualTo(names);
        });
    }
}
