package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.NameParser;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {
    @Test
    @DisplayName("자동차_이름을_쉼표로_구분한다")
    public void 자동차_이름을_쉼표로_구분한다() {
        String carName = "kim,park,lee";
        ArrayList<String> expectNameList = new ArrayList<>();
        expectNameList.add("kim");
        expectNameList.add("park");
        expectNameList.add("lee");
        assertEquals(NameParser.parse(carName), expectNameList);
    }

    @Test
    @DisplayName("단일_자동차_이름은_그_이름_하나만_반환한다")
    public void 단일_자동차_이름은_그_이름_하나만_반환한다() {
        String carName = "kim";
        ArrayList<String> expectNameList = new ArrayList<>();
        expectNameList.add("kim");
        assertEquals(NameParser.parse(carName), expectNameList);
    }
}
