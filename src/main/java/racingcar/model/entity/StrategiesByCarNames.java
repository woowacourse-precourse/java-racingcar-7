package racingcar.model.entity;

import racingcar.model.dto.CarNames;
import racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/** 자동차 이름과 자동차 이동 전략 순차적으로 저장한 컬렉션을 매핑함 */
public record StrategiesByCarNames(Map<String, List<Supplier<Integer>>> strategies) {

    public static StrategiesByCarNames getAllRandomMove(CarNames names,
                                                        RacingChance chance) {

        Map<String, List<Supplier<Integer>>> strategiesAtCarName =
                new HashMap<>();

        for (String name : names) {
            strategiesAtCarName.put(name, new ArrayList<>());
        }

        for (String name : names) {
            for (int i = 0; i < chance.getValue(); i++) {
                strategiesAtCarName.get(name).add(MoveStrategy::random);
            }
        }

        return new StrategiesByCarNames(strategiesAtCarName);
    }

    public List<Supplier<Integer>> get(String name) {
        return strategies.get(name);
    }

}
