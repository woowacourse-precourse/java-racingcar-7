package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.car.CarUtil;

import java.util.Arrays;
import java.util.HashMap;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * @author ddaerae
 * @since 2024-10-23
 * 자동차 관련 기능을 테스트하는 클래스
 */
class CarUtilTest {

    @Test
    @DisplayName("주어진 라이브러리의 함수가 원하는 값을 리턴하는지")
    void 라이브러리_테스트() {
        assertDoesNotThrow(() -> {
            var ranNumArray = new int[30];
            for (int i = 0; i < 30; i++) {
                int ranNum = Randoms.pickNumberInRange(0, 9);
                ranNumArray[i] = ranNum;
            }

            for (int i = 0; i < 30; i++) {
                if (ranNumArray[i] > 9 || ranNumArray[i] < 0) {
                    throw new IllegalArgumentException("설정하지마!");
                }
            }
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3, 4, 5})
    @DisplayName("4 이상이면 - 기호 리턴, 아니면 공백리턴")
    void 전진_기호_리턴(int ranNum) {
        String result;
        if (ranNum >= 4) {
            result = "-";
        } else {
            result = "";
        }

        if (ranNum >= 4) {
            assertThat(result).isEqualTo("-");
        } else {
            assertThat(result).isEmpty();
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"koo,sang,woo"})
    @DisplayName("참여하는 자동차의 대수를 정확하게 구한다.")
    void 참여_대수_구하기(String participatingCars) {
        var carsList = Arrays.stream(participatingCars.split(",")).toList();

        assertThat(carsList.size()).isSameAs(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"구상우,홍길동,백치"})
    @DisplayName("한글로 값이 들어와도 예외가 발생되면 안된다")
    void 유효성_검사_한글_테스트(String carNames) {
        assertDoesNotThrow(() -> {
            CarUtil.splitAndNameValidation(carNames);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc,def,ghi"})
    @DisplayName("영문 이름으로 이루어진 이름들은 예외를 발생하면 안된다.")
    void 유효성_검사_영문_테스트(String carNames) {
        assertDoesNotThrow(() -> {
            CarUtil.splitAndNameValidation(carNames);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"Koo , Sang, woo", " Hong, Gil,Dong", "kim,Duk,bae"})
    @DisplayName("공백값이 있으면 잘라줘야함")
    void 공백_값을_없앤다(String containSpace) {
        var carNameList = Arrays.stream(containSpace.split(",")).map(String::trim).toList();

        for (int i = 0; i < carNameList.size(); i++) {
            String carName = carNameList.get(i);
            assertThat(carName).doesNotContain(" ");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {" ,koo,sang,woo"})
    @DisplayName("콤마의 위치로 인해 공백값이 생기면 예외를 반환해야함")
    void 콤마_공백값_예외_발생(String carNames) {
        assertThatThrownBy(() -> {
            CarUtil.splitAndNameValidation(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차명은 공백이 될 수 없습니다.\n, 의 위치를 확인하세요");
    }

    @ParameterizedTest
    @ValueSource(strings = {":koo,sang,woo!", "koo ,sangL:woo", "1Skk,상우,한글", "1koo,sang,woo", "koo,>sang,woo", "훈민,정음:,만세", "한글1,산맥,동백?꽃"})
    @DisplayName("다른 특수기호, 숫자값에 대해 모두 예외를 리턴해야함")
    void 이름_유효성_검사_예외_테스트(String carNames) {
        assertThatThrownBy(() -> {
            CarUtil.splitAndNameValidation(carNames);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(", 외에 다른 특수 기호와 숫자를 사용하면 안됩니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"  koo,sa  ng,woo  ", "구  , 상  , 우  "})
    @DisplayName("replace를 통해 중간 공백은 물론 2칸 이상의 공백도 없앤다.")
    void 공백_제거_2차_테스트(String carNames) {
        assertDoesNotThrow(() -> {
            CarUtil.splitAndNameValidation(carNames);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"구상우,ksw,sang"})
    @DisplayName("자동차명 문자열을 넘기면 차명과 전진횟수 문자열을 가진 Map 리턴")
    void 자동차별_Map_생성(String carNames) {
        var trimCarNames = CarUtil.splitAndNameValidation(carNames);
        var carNameConvertMapList = trimCarNames.stream().map(carName -> {
            var nameAndGoCount = new HashMap<String, String>();
            nameAndGoCount.put("name", carName);
            nameAndGoCount.put("goCount", "");
            return nameAndGoCount;
        }).toList();

        for (int i = 0; i < trimCarNames.size(); i++) {
            assertThat(carNameConvertMapList.get(i).get("name")).isNotEmpty();
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"koo,sang,woo", "구,상,우", " 구, 상 , 우 ", "koo , sang , woo  "})
    @DisplayName("구현한 함수가 예외를 발생하지 않고 데이터를 원하는대로 변환해야함")
    void Map_리턴_함수_테스트(String carNames) {
        assertDoesNotThrow(() -> {
            CarUtil.getCarNameAndGoCountList(carNames);
        });
    }
}
