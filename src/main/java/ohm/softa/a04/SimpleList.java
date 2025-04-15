package ohm.softa.a04;

import java.util.function.Function;

public interface SimpleList<T> extends Iterable<T> {
	/**
	 * Add a given object to the back of the list.
	 */
	void add(T o);

	/**
	 * @return current size of the list
	 */
	int size();

	/**
	 * Generate a new list using the given filter instance.
	 * @return a new, filtered list
	 */
	SimpleList<T> filter(SimpleFilter<T> filter);

	@SuppressWarnings("unchecked")
	default void addDefault(Class<T> clazz) {
		try {
			this.add(clazz.newInstance());
		}
		catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	default SimpleList<T> filter(SimpleFilter<T> filter){

	}

	default <R> SimpleList<R> map(Function<T,R> transform){

	}
}
