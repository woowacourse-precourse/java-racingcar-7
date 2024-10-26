package racingcar.model.entity;

import racingcar.model.dto.CarNames;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

public final class RacingTurns implements Iterable<RacingTurn> {

    private final List<RacingTurn> turns;

    public RacingTurns(List<RacingTurn> turns) {
        this.turns = turns;
    }

    public static RacingTurns getInstance(CarNames names,
                              StrategiesAtCarNames strategiesWithCarNames,
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
                                     StrategiesAtCarNames strategiesWithNames,
                                     int index) {

        LinkedHashMap<String, Supplier<Integer>> strategyWithCar =
                new LinkedHashMap<>();
        for (String name : names) {
            List<Supplier<Integer>> strategies = strategiesWithNames.get(name);
            strategyWithCar.put(name, strategies.get(index));
        }
        return new RacingTurn(strategyWithCar);

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
