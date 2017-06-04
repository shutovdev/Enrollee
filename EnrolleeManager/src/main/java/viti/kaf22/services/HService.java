package viti.kaf22.services;

import java.util.List;

public interface HService {

	public <T> T get(final Class<T> type, final Long id);

	public <T> List<T> getAll(final Class<T> type);	
	
	public <T> List<T> getAllWithLazy(final Class<T> type);	
	
	public <T> List<T> namedQuery(String query, Object value);
}
