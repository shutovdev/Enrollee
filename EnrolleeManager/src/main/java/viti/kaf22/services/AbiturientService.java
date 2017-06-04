package viti.kaf22.services;

import viti.kaf22.entities.Abiturient;

import java.util.List;

public interface AbiturientService {

	public void save(final Abiturient group);

	public void delete(final Abiturient group) ;

	public Abiturient get(final Long id) ;
	
	public Abiturient getWithLazy(final Long id);

	public void saveOrUpdate(final Abiturient group) ;
	
	public void update(final Abiturient group);

	public List<Abiturient> getAll() ;
	
	public List<Abiturient> getAllWithLazy();
	
	public List<Abiturient> namedQuery(String query, Object value);


}
