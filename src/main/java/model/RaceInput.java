package model;

import java.util.ArrayList;

/**
 * Represents user input for a racing game, containing participant names
 * and the number of times to run the race.
 * This class is immutable as all fields are final and the contained ArrayList
 * is not exposed for modification.
 */
public class RaceInput {
    private final ArrayList<String> names;
    private final Integer times;

    /**
     * Creates a new race input with participant names and running times.
     *
     * @param names comma-separated names of participants
     * @param times number of times to run the race
     */
    public RaceInput(ArrayList<String> names, Integer times) {
        this.names = names;
        this.times = times;
    }

    /**
     * Returns the list of participant names.
     *
     * @return the list of participant names
     */
    public ArrayList<String> getNames() {
        return names;
    }

    /**
     * Returns the number of times to run the race.
     *
     * @return the number of race iterations
     */
    public Integer getTimes() {
        return times;
    }
}