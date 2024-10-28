package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import domain.CarName;
import domain.CarNames;
import domain.TryCount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공동_우승_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                4, 4
        );
    }

    @Test
    void CarName_아무런_값도_들어_오지_않은_경우() {
        Assertions.assertThatThrownBy(() -> {
            CarName carName = new CarName("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void CarName_공백이_값으로_들어온_경우() {
        Assertions.assertThatThrownBy(() -> {
            CarName carName = new CarName(" ");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "pobi",
            "",
            "lina",
            "chin",
            "mina"
    })
    void CarNames_자동차_이름을_1개_이하로_작성한_경우(String names) {
        List<CarName> list = new ArrayList<>();
        list.add(new CarName("pobi"));
        Assertions.assertThatThrownBy(() -> {
            CarNames carNames = new CarNames(list);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "pobi,pobi",
            "pobi,lina,pobi",
            "pobi,lina,chin,pobi",
            "pobi,lina,chin,mina,pobi",
            "pobi,lina,chin,mina,linda,pobi"
    })
    void CarNames_자동차_이름을_중복된_이름으로_작성한_경우(String names) {
        List<CarName> list = new ArrayList<>();
        for(String name: names.split(",")) {
            list.add(new CarName(name));
        }
        Assertions.assertThatThrownBy(() -> {
            CarNames carNames = new CarNames(list);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "pobi,moa",
            "joon,lily,nico",
            "milo,noah,luna,zoey,eric",
            "ella,kyra,jack,ryan,dave,abc",
            "leah,cole,aria,paul,zoe,abc,cde"
    })
    void CarNames_이름을_올바르게_작성한_경우(String names) {
        List<CarName> list = new ArrayList<>();
        String[] splitNames = names.split(",");
        for(String name: splitNames) {
            list.add(new CarName(name));
        }
        CarNames carNames = new CarNames(list);

        Assertions.assertThat(carNames.getNames().size()).isEqualTo(splitNames.length);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1","23","355","4312","55523"
    })
    void TryCount_올바른_숫자를_입력한_경우(String input) {
        TryCount tryCount = new TryCount(input);
        Assertions.assertThat(tryCount.getValue()).isEqualTo(Integer.parseInt(input));
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "a","b","c",";","!"
    })
    void TryCount_숫자를_입력하지_않고_문자를_입력한_경우(String input) {
        Assertions.assertThatThrownBy(() -> {
            TryCount tryCount = new TryCount(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            " 1"," 2"," 3"," 4"," 5","5 ","6 "
    })
    void TryCount_숫자를_입력하지_않고_공백을_입력한_경우(String input) {
        Assertions.assertThatThrownBy(() -> {
            TryCount tryCount = new TryCount(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void TryCount_숫자를_입력하지_않고_아무런_값도_입력하지_않은_경우() {
        Assertions.assertThatThrownBy(() -> {
            TryCount tryCount = new TryCount("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void TryCount_0을_입력한_경우() {
        Assertions.assertThatThrownBy(() -> {
            TryCount tryCount = new TryCount("0");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "-1","-2","-3","-4","-5","-6"
    })
    void TryCount_음수를_입력한_경우(String input) {
        Assertions.assertThatThrownBy(() -> {
            TryCount tryCount = new TryCount(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
