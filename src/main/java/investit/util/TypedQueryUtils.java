package investit.util;

import java.util.List;

import javax.persistence.TypedQuery;

public class TypedQueryUtils {

	public static <T> T getFirstOrNull(TypedQuery<T> typedQuery) {
		List<T> all = typedQuery.getResultList();
		if (all.size()==0) return null;
		final T first = all.get(0);
		return first;
	}

}
