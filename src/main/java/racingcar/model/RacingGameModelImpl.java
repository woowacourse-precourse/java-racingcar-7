package racingcar.model;

import java.util.List;

import static racingcar.util.CarFactory.createCars;
import static racingcar.util.TrialValidator.validateTrial;

/**
 * RacingGameModel 인터페이스를 구현한 RacingGameModelImpl 클래스.
 * 자동차 경주 게임의 로직을 처리하며, 주어진 자동차 이름과 시도 횟수를 기반으로 경주를 진행한다.
 */
public class RacingGameModelImpl implements RacingGameModel {

    /**
     * 자동차 이름과 시도 횟수를 기반으로 경주 게임을 실행하여 결과를 반환한다.
     * 자동차 목록은 CarFactory에서 생성하고, 시도 횟수는 TrialValidator로 검증하여 설정한다.
     *
     * @param carNames 콤마로 구분된 자동차 이름 문자열
     * @param trialNum 경주 시도 횟수를 나타내는 문자열
     * @return 각 시도 마다의 자동차 상태와 최종 우승자 결과 문자열
     */
    @Override
    public String play(String carNames, String trialNum) {
        // 입력된 자동차 이름으로 RacingCar 객체 리스트를 생성
        List<RacingCar> cars = createCars(carNames);

        // 유효성을 검증한 후 시도 횟수를 설정
        int trial = validateTrial(trialNum);

        // GameResults 객체를 사용하여 게임 결과 생성
        GameResults results = new GameResults(cars, trial);

        return results.getResults();
    }
}
