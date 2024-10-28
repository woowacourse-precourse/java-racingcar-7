package racingcar.domain.name;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import racingcar.exception.name.NameException;
import racingcar.exception.name.NameExceptionMessage;

public class Names {
	private final List<Name> names;

	public Names(List<Name> names) {
		validateNames(names);
		this.names = names;
	}

	public List<Name> getNames() {
		return names;
	}

	private void validateNames(List<Name> names) {
		Set<Name> notDuplicatedNames = new HashSet<>(names);

		if (notDuplicatedNames.size() != names.size()) {
			throw new NameException(NameExceptionMessage.HAS_DUPLICATED_NAME);
		}

	}
}
