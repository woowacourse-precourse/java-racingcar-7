package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.car.CarUtil;
import racingcar.util.game.GameUtil;
import racingcar.vo.CarVO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameUtilTest {


    @ParameterizedTest
    @ValueSource(ints = {9, 8, 7, 6, 5, 4, 3, 2, 1})
    @DisplayName("차량의 전진 OR 정지 판단")
    void 전진_아니면_정지(int number) {
        var result = GameUtil.goOrStop(number);

        if (number >= 4)
            assertThat(result).isEqualTo("-");
        else
            assertThat(result).isEmpty();
    }


    @ParameterizedTest
    @ValueSource(strings = {"koo,sang,woo"})
    @DisplayName("게임의 한 턴에 대한 결과값을 정상적으로 삽입한다.")
    void 한턴_진행_결과값_테스트(String carNames) {
        assertDoesNotThrow(() -> {
            List<CarVO> carNameAndGoCountList = CarUtil.getCarNameAndGoCountList(carNames);
            for (var carAndCount : carNameAndGoCountList) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) {
                    carAndCount.goOneStep();
                }
                System.out.println(carAndCount.getCarName() + " : " + "-".repeat(carAndCount.getGoCount()));
            }
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"구상우,홍길동, 김천지"})
    @DisplayName("한턴을 진행해주는 함수가 업데이트 된 값을 가져와야한다.")
    void 한턴_진행_실제_함수_테스트(String carNames) {
        assertDoesNotThrow(() -> {
            GameUtil.oneTurnPrintAndUpdate(CarUtil.getCarNameAndGoCountList(carNames));
        });
    }

    @ParameterizedTest
    @MethodSource("provideCarNamesAndExecuteNumbers")
    @DisplayName("게임 전체를 진행하는 함수를 구현한다.")
    void 전체_진행_기능_테스트(String carNames, int executeNumber) {
        assertDoesNotThrow(() -> {
            List<CarVO> carNameAndGoCountList = CarUtil.getCarNameAndGoCountList(carNames);
            System.out.println("실행 결과");
            for (int i = 0; i < executeNumber; i++) {
                GameUtil.oneTurnPrintAndUpdate(carNameAndGoCountList);
            }

            for (CarVO car : carNameAndGoCountList) {
                System.out.println(car.toString());
            }
        });
    }


    @ParameterizedTest
    @MethodSource("provideCarNamesAndExecuteNumbers")
    @DisplayName("게임 전체를 진행하는 함수가 원하는 값을 출력한다..")
    void 전체_진행_함수_테스트(String carNames, int executeNumber) {
        assertDoesNotThrow(() -> {
            List<CarVO> carNameAndGoCountList = CarUtil.getCarNameAndGoCountList(carNames);
            GameUtil.oneGamePrintAndUpdate(carNameAndGoCountList, executeNumber);
        });
    }

    @ParameterizedTest
    @MethodSource("provideCarVOList")
    @DisplayName("출전자 중 제일 많은 전진 횟수를 구한다.")
    void 우승자_추출_기능_테스트(List<CarVO> carNameAndGoCountList) {
        var maxGoCount = 0;
        for (CarVO carNameAndCount : carNameAndGoCountList) {
            if (carNameAndCount.getGoCount() > maxGoCount) {
                maxGoCount = carNameAndCount.getGoCount();
            }
        }

        assertThat(maxGoCount).isSameAs(5);
    }

    @ParameterizedTest
    @MethodSource("provideCarVOList")
    @DisplayName("woo 자동차 이름을 정상적으로 가져온다.")
    void 우승자_이름_추출_기능(List<CarVO> carNameAndGoCountList) {
        int maxGoCount = 5;
        String winnerName = null;
        for (CarVO carNameAndCount : carNameAndGoCountList) {
            if (carNameAndCount.getGoCount() == maxGoCount) {
                winnerName = carNameAndCount.getCarName();
            }
        }

        assertThat(winnerName).isEqualTo("woo");
    }

    @ParameterizedTest
    @MethodSource("provideCarVOList")
    @DisplayName("우승자가 한명 일 때 이름을 정상적으로 리턴한다.")
    void 단독_우승자_이름_리턴(List<CarVO> carNameAndGoCountList) {
        int maxGoCount = 5;
        List<String> winnerNameArray = new ArrayList<>();
        String result = "";

        for (CarVO carNameAndCount : carNameAndGoCountList) {
            if (carNameAndCount.getGoCount() == maxGoCount) {
                winnerNameArray.add(carNameAndCount.getCarName());
            }
        }

        if (winnerNameArray.size() == 1) {
            result = winnerNameArray.getFirst();
        } else {
            result = winnerNameArray.toString().replaceAll("[\\[\\]]", "");
        }

        assertThat(result).isEqualTo("woo");
    }

    @ParameterizedTest
    @MethodSource("provideTwoWinnerList")
    @DisplayName("우승자가 두명일 경우 이름1, 이름2 로 리턴")
    void 우승자가_두명_일때(List<CarVO> carNameAndGoCountList) {
        int maxGoCount = 5;
        List<String> winnerNameArray = new ArrayList<>();
        String result = "";

        for (CarVO carNameAndCount : carNameAndGoCountList) {
            if (carNameAndCount.getGoCount() == maxGoCount) {
                winnerNameArray.add(carNameAndCount.getCarName());
            }
        }

        if (winnerNameArray.size() == 1) {
            result = winnerNameArray.getFirst();
        } else {
            result = winnerNameArray.toString().replaceAll("[\\[\\]]", "");
        }

        assertThat(result).isEqualTo("woo, hong");
    }

    @ParameterizedTest
    @MethodSource("provideManyWinnerNameList")
    @DisplayName("두 명이상의 우승자 출력 양식으로 변환하는 기능")
    void 다수_우승자_출력양식_변환(List<String> winnerNames) {
        String result = "";
        // 우승자가 한명일때
        if (winnerNames.size() == 1) {
            result = winnerNames.getFirst();
            // 함수에선 여기서 리턴
        }

        if (winnerNames.isEmpty()) {
            result += winnerNames.getFirst();
        } else {
            result += winnerNames.toString().replaceAll("[\\[\\]]", "");
        }


        assertThat(result).isEqualTo("koo, sang, woo");
    }

    @ParameterizedTest
    @MethodSource("provideTwoWinnerList")
    @DisplayName("우승자 구하기 최종 기능 테스트")
    void 우승자_최종_기능_구현(List<CarVO> carNameAndGoCountList) {
        List<String> winnerNameArray = new ArrayList<>();
        var maxCount = GameUtil.getMaxGoCount(carNameAndGoCountList);
        String winnerPrintValue = "최종 우승자 : ";

        for (CarVO carNameAndCount : carNameAndGoCountList) {
            if (carNameAndCount.getGoCount() == maxCount) {
                winnerNameArray.add(carNameAndCount.getCarName());
            }
        }

        if (winnerNameArray.size() == 1) {
            winnerPrintValue += winnerNameArray.getFirst();
        } else {
            winnerPrintValue += winnerNameArray.toString().replaceAll("[\\[\\]]", "");
        }

        assertThat(winnerPrintValue).isEqualTo("최종 우승자 : woo, hong");

    }

    @ParameterizedTest
    @MethodSource("provideTwoWinnerList")
    @DisplayName("우승자 명단 리턴 함수가 기존 테스트 코드처럼 원하는 우승자 양식을 리턴해야함")
    void 우승자_함수_적용_테스트(List<CarVO> carList) {
        String winnerName = GameUtil.getWinnerName(carList);
        assertThat(winnerName).isEqualTo("최종 우승자 : woo, hong");
    }


    @ParameterizedTest
    @ValueSource(strings = {"4,", "4번", "4회", "4게임", "4 ", " 4 ", "4   3  ", "2   3  32 "})
    @DisplayName("잘못된 값이 있으면 NumberFormatExcep이 발생해야함")
    void 게임_횟수_입력값_유효성_테스트(String inputValue) {
        assertThrows(NumberFormatException.class, () -> {
            Integer.valueOf(inputValue);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 ", " 4 ", "4   3  ", "2   3  32 "})
    @DisplayName("공백을 모두 지우고 붙이는 것으로 판단함")
    void 공백값_지우기(String spaceVal) {
        assertDoesNotThrow(() -> {
            Integer result = Integer.valueOf(spaceVal.replace(" ", ""));
            assertThat(result.toString()).doesNotContain(" ");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 ", "1 3  2  4 ", " 23 ", "235"})
    @DisplayName("게임 횟수 유효성 검사 및 공백제거 기능 최종 테스트")
    void 게임_횟수_기능_최종_테스트(String turnNumber) {
        assertDoesNotThrow(() -> {
            String replaceNumber = turnNumber.replace(" ", "");

            try {
                Integer.valueOf(replaceNumber);
            } catch (NumberFormatException numberFormatException) {
                throw new IllegalArgumentException("숫자만 입력해야합니다!");
            }
        });
    }

    // 매개변수 제공 메서드
    static Stream<Arguments> provideCarNamesAndExecuteNumbers() {
        return Stream.of(
                Arguments.of("koo,sang,woo", 5) // 자동차 이름과 실행 횟수
        );
    }

    // 게임 진행 후의 테스트용 데이터를 리턴한다.
    static Stream<Arguments> provideCarVOList() {
        List<CarVO> carNameAndGoCountList = new ArrayList<CarVO>();
        carNameAndGoCountList.add(new CarVO("sang", 3));
        carNameAndGoCountList.add(new CarVO("sang", 4));
        carNameAndGoCountList.add(new CarVO("woo", 5));

        return Stream.of(
                Arguments.of(carNameAndGoCountList) // 자동차 이름과 실행 횟수
        );
    }

    // 우승자가 2명인 경주 결과를 리턴한다.
    static Stream<Arguments> provideTwoWinnerList() {
        List<CarVO> carNameAndGoCountList = new ArrayList<CarVO>();
        carNameAndGoCountList.add(new CarVO("sang", 3));
        carNameAndGoCountList.add(new CarVO("sang", 4));
        carNameAndGoCountList.add(new CarVO("woo", 5));
        carNameAndGoCountList.add(new CarVO("hong", 5));

        return Stream.of(
                Arguments.of(carNameAndGoCountList) // 자동차 이름과 실행 횟수
        );
    }


    // 우승자의 이름 리스트를 반환한다.
    static Stream<Arguments> provideManyWinnerNameList() {
        List<String> winnerNameList = new ArrayList<>();
        winnerNameList.add("koo");
        winnerNameList.add("sang");
        winnerNameList.add("woo");

        return Stream.of(
                Arguments.of(winnerNameList) // 자동차 이름과 실행 횟수
        );
    }
}