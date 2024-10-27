package racingcar;

import static racingcar.AfterRacing.moveCountMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AfterRacingTest {

    @BeforeEach
    void setUp() {
        moveCountMap.clear();
    }

    @Test
    void 최종_우승자(){
        List<CarDto> carDtoList = new ArrayList<>();

        CarDto resutString1 = new CarDto("haha", false);
        CarDto resutString2 = new CarDto("hoho", true);
        CarDto resutString3 = new CarDto("kiki", true);

        carDtoList.add(resutString1);
        carDtoList.add(resutString2);
        carDtoList.add(resutString3);

        List<CarDto> carDtoList2 = new ArrayList<>();

        CarDto resutString11 = new CarDto("haha", false);
        CarDto resutString22 = new CarDto("hoho", true);
        CarDto resutString33 = new CarDto("kiki", true);

        carDtoList2.add(resutString11);
        carDtoList2.add(resutString22);
        carDtoList2.add(resutString33);

        Map<Integer, List<CarDto>> carRacingInfo = new HashMap<>();
        carRacingInfo.put(1, carDtoList);
        carRacingInfo.put(2, carDtoList2);
        AfterRacing.getRaceResult(carRacingInfo);

        List<String> winner = AfterRacing.getWinner();
        Assertions.assertThat(winner).containsExactly("hoho", "kiki");
    }

}