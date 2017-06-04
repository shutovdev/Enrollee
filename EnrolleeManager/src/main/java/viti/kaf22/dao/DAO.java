package viti.kaf22.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import viti.kaf22.utils.HelpUtil;
/**
 * 
 * @author shkiddy
 * @since 04.05.17
 * 
 */
@Repository
public class DAO {

	private static Logger logger = Logger.getLogger(DAO.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void save(final Object o) {
		if (o == null) {
			logger.error("**DAO - save* EMPTY OBJ");
			return;
		}
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(o);
	}

	public void update(final Object o) {
		if (o == null) {
			logger.error("**DAO - update* EMPTY OBJ");
			return;
		}
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(o);
	}

	public void delete(final Object object) {
		if (object == null) {
			logger.error("**DAO - delete* EMPTY OBJ");
			return;
		}
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.clear();
		currentSession.delete(object);
		currentSession.flush();

	}

	/***/
	public <T> T get(final Class<T> type, final Long id) {

		Session currentSession = sessionFactory.getCurrentSession();
		T t = currentSession.get(type, id);

		return (T) t;
	}

	/***/
	public <T> void saveOrUpdate(final T o) {
		if (o == null) {
			logger.error("**DAO - saveOrUpdate* EMPTY OBJ");
			return;
		}

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.clear();
		logger.debug(o.getClass()+" "+o);
		currentSession.saveOrUpdate(o);
		currentSession.flush();
	}

	public <T> List<T> getAll(final Class<T> type) {
		logger.debug("**DAO - getAll* criteria ***");
		CriteriaQuery<T> query = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(type);
		logger.debug("**DAO - getAll* select ***");
		query.select(query.from(type));
		logger.debug("**DAO - getAll* query ***");
		Query<T> q = sessionFactory.getCurrentSession().createQuery(query); // CriteriaQueryTypeQueryAdapter
		logger.debug("**DAO - getAll* cacheble ***"); // instance
		q.setCacheable(false);
		logger.debug("**DAO - getAll* list ***");
		List<T> tt = q.list();

		return tt;
	}

	public <T> List<T> getAllWithLazy(final Class<T> type) {

		CriteriaQuery<T> query = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(type);
		query.select(query.from(type));
		Query<T> q = sessionFactory.getCurrentSession().createQuery(query); // CriteriaQueryTypeQueryAdapter
																			// instance
		q.setCacheable(false);
		List<T> tt = q.list();
		logger.debug("**DAO - getAllWithLazy* List tt" + tt);
		for (T t : tt) {
			try {
				logger.debug("**DAO - getAllWithLazy* EXEC INIT BY SET***");
				HelpUtil.executeBySetObject(t, Set.class, Hibernate::initialize, true);
				HelpUtil.clearBuffer();
				logger.debug("**DAO - getAllWithLazy* EXEC INIT BY OBJS***");
				HelpUtil.executeByUserObjects(t, Serializable.class, Hibernate::initialize, true);
				logger.debug("**DAO - getAllWithLazy* EXEC DONE***");

			} catch (Exception e) {
				// TODO: handle exception
				logger.error("**DAO - getAllWithLazy* MESS:" + e.getMessage());
				logger.error("**DAO - getAllWithLazy*CAUSE:" + e.getCause());
			}
		}
		return tt;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> List<T> namedQuery(String query, Object value) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query namedQuery = currentSession.getNamedQuery(query);
		namedQuery.setParameter("name", value);
		return namedQuery.list();

	}

	public <T> T getWithLazy(final Class<T> type, Long id) {
		// TODO Auto-generated method stub

		logger.debug("**DAO - getWithLazy* *******session********");
		Session currentSession = sessionFactory.getCurrentSession();
		logger.debug("**DAO - getWithLazy********get object********");
		T t = currentSession.get(type, id);
		if(t==null)
		{
			logger.error("**DAO - getWithLazy* NOT FOUND WITH "+id+" FOR "+type);
			return null;
		}
		try {
			logger.debug("**DAO - getWithLazy* start init set");
			HelpUtil.executeBySetObject(t, Set.class, Hibernate::initialize, true);
			HelpUtil.clearBuffer();
			logger.debug("**DAO - getWithLazy* start init user objects");
			HelpUtil.executeByUserObjects(t, Serializable.class, Hibernate::initialize, true);
			logger.debug("**DAO - getWithLazy* ******finish***********");
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e);
			logger.error("**DAO - getWithLazy* Cause:*******" + e.getCause());
		}
		return (T) t;
	}

}