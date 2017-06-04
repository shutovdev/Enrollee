package viti.kaf22.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import viti.kaf22.dao.DAO;

/**
 * 
 * @author shkiddy
 * @since 04.05.17
 * 
 */
@Service("HService")
public class HServiceImpl implements HService {
	
	@Autowired
	private DAO dao;
	
	@Transactional(readOnly = true)
	@Override
	public <T> T get(Class<T> type, Long id) {
		// TODO Auto-generated method stub
		return dao.get(type, id);
	}

	@Transactional(readOnly = true)
	@Override
	public <T> List<T> getAll(Class<T> type) {
		// TODO Auto-generated method stub
		return dao.getAll(type);
	}

	@Transactional(readOnly = true)
	@Override
	public <T> List<T> getAllWithLazy(Class<T> type) {
		// TODO Auto-generated method stub
		return dao.getAllWithLazy(type);
	}

	@Transactional(readOnly = true)
	@Override
	public <T> List<T> namedQuery(String query, Object value) {
		// TODO Auto-generated method stub
		return dao.namedQuery(query, value);
	}

	

}
