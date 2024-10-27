package racingcar;

public class ConditionConfig {
    int rand_min;
    int rand_max;
    int threshold;

    ConditionConfig(int rand_min, int rand_max, int threshold) {
        this.rand_min = rand_min;
        this.rand_max = rand_max;
        this.threshold = threshold;
    }
}
