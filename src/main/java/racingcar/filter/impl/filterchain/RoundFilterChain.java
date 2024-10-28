package racingcar.filter.impl.filterchain;

import racingcar.filter.Filter;

public class RoundFilterChain extends DefaultFilterChain {
    public RoundFilterChain() {
        super();
    }

    @Override
    protected void internalDoFilter(String input) {
        if (position < filterListLength) {
            try {
                Filter filter = filters.get(position++);
                filter.doFilter(input, this);
            } finally {
                this.position = 0;
            }
        }
    }
}
