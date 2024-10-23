package model;

import java.util.ArrayList;

/**
 * Represents user input for a racing game, containing participant names
 * and the number of times to run the race.
 * This class is immutable as all fields are final and the contained ArrayList
 * is not exposed for modification.
 */
public record RaceInput(ArrayList<String> names, int times) {
    /**
     * Creates a new race input with participant names and running times.
     *
     * @param names comma-separated names of participants
     * @param times number of times to run the race
     */
    public RaceInput {
    }

    /**
     * Returns the list of participant names.
     *
     * @return the list of participant names
     */
    @Override
    public ArrayList<String> names() {
        return names;
    }

    /**
     * Returns the number of times to run the race.
     *
     * @return the number of race iterations
     */
    @Override
    public int times() {
        return times;
    }
}