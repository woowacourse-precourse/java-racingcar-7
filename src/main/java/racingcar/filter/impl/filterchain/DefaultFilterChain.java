package racingcar.filter.impl.filterchain;

import java.util.ArrayList;
import java.util.List;
import racingcar.filter.Filter;
import racingcar.filter.FilterChain;

public abstract class DefaultFilterChain implements FilterChain {

    protected final List<Filter> filters = new ArrayList<Filter>();
    protected int filterListLength = 0;
    protected int position = 0;

    public DefaultFilterChain() {
    }

    @Override
    public void doFilter(String input) {
        internalDoFilter(input);
    }

    @Override
    public void addFilter(Filter filter) {
        filters.add(filter);
        filterListLength++;
    }

    protected abstract void internalDoFilter(String input);
}
