package racingcar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Racers implements Iterable<Racer> {
    private final List<Racer> racers;

    public Racers(List<Racer> racers) {
        this.racers = new ArrayList<>(racers);
    }

    public void go() {
        for (Racer racer : racers) {
            racer.random();
        }
    }

    public static Racers racerParse(String input) {
        List<Racer> racerList = new ArrayList<>();
        String[] inputArray = input.split(",", -1);
        System.out.println(inputArray.length);
        for (String racer : inputArray) {
            racerList.add(new Racer(racer));
        }
        System.out.println();
        return new Racers(racerList);
    }

    public Iterator<Racer> iterator() {
        return racers.iterator();
    }

    @Override
    public String toString() {
        return racers.toString();
    }
}
