package racingcar.model.entity;

import racingcar.model.dto.CarNames;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

/** RacingTurn을 순차적으로 저장하여 순회할 수 있도록 저장함 */
public final class RacingTurns implements Iterable<RacingTurn> {

    private final List<RacingTurn> turns;

    public RacingTurns(List<RacingTurn> turns) {
        this.turns = turns;
    }

    public static RacingTurns getInstance(CarNames names,
                              StrategiesByCarNames strategiesWithCarNames,
                              RacingChance chance) {

        List<RacingTurn> turns = new ArrayList<>();
        for (int i = 0; i < chance.getValue(); i++) {
            RacingTurn turn =
                    getTurn(names, strategiesWithCarNames, i);
            turns.add(turn);
        }

        return new RacingTurns(turns);

    }

    private static RacingTurn getTurn(CarNames names,
                                     StrategiesByCarNames strategiesAtNames,
                                     int index) {

        LinkedHashMap<String, Supplier<Integer>> strategyAtCarName =
                new LinkedHashMap<>();

        for (String name : names) {
            List<Supplier<Integer>> strategies = strategiesAtNames.get(name);
            strategyAtCarName.put(name, strategies.get(index));
        }

        return new RacingTurn(strategyAtCarName);

    }

    @Override
    public Iterator<RacingTurn> iterator() {
        return new RacingTurnsIterator();
    }

    private final class RacingTurnsIterator implements Iterator<RacingTurn> {

        private int index;

        @Override
        public boolean hasNext() {
            return index < turns.size();
        }

        @Override
        public RacingTurn next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            RacingTurn turn = turns.get(index);
            index++;
            return turn;
        }

    }

}
