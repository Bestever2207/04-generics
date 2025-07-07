package ohm.softa.a04;

public interface SimpleList<T> extends Iterable {
	/**
	 * Add a given object to the back of the list.
	 */
	void add(T t);

	default void addDefault(Class<T> tclass){
        try {
            this.add(tclass.newInstance());

        } catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
    }

	default SimpleList<T> filter(SimpleFilter<T> filter){
		SimpleList<T> result;

        try {
            result = (SimpleList<T>) getClass().newInstance();

        } catch (InstantiationException | IllegalAccessException e) {
			result = new SimpleListImpl<>();
		}

        for(T t : this){
			if(filter.include(t)){
				result.add(t);
			}
		}

		return result;
	}

	/**
	 * @return current size of the list
	 */
	int size();

	/**
	 * Generate a new list using the given filter instance.
	 * @return a new, filtered list
	 */
}
