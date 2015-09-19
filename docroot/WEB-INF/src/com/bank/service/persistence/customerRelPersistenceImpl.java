/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.bank.service.persistence;

import com.bank.NoSuchcustomerRelException;

import com.bank.model.customerRel;
import com.bank.model.impl.customerRelImpl;
import com.bank.model.impl.customerRelModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the customer rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author priyanka
 * @see customerRelPersistence
 * @see customerRelUtil
 * @generated
 */
public class customerRelPersistenceImpl extends BasePersistenceImpl<customerRel>
	implements customerRelPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link customerRelUtil} to access the customer rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = customerRelImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(customerRelModelImpl.ENTITY_CACHE_ENABLED,
			customerRelModelImpl.FINDER_CACHE_ENABLED, customerRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(customerRelModelImpl.ENTITY_CACHE_ENABLED,
			customerRelModelImpl.FINDER_CACHE_ENABLED, customerRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(customerRelModelImpl.ENTITY_CACHE_ENABLED,
			customerRelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the customer rel in the entity cache if it is enabled.
	 *
	 * @param customerRel the customer rel
	 */
	public void cacheResult(customerRel customerRel) {
		EntityCacheUtil.putResult(customerRelModelImpl.ENTITY_CACHE_ENABLED,
			customerRelImpl.class, customerRel.getPrimaryKey(), customerRel);

		customerRel.resetOriginalValues();
	}

	/**
	 * Caches the customer rels in the entity cache if it is enabled.
	 *
	 * @param customerRels the customer rels
	 */
	public void cacheResult(List<customerRel> customerRels) {
		for (customerRel customerRel : customerRels) {
			if (EntityCacheUtil.getResult(
						customerRelModelImpl.ENTITY_CACHE_ENABLED,
						customerRelImpl.class, customerRel.getPrimaryKey()) == null) {
				cacheResult(customerRel);
			}
			else {
				customerRel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all customer rels.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(customerRelImpl.class.getName());
		}

		EntityCacheUtil.clearCache(customerRelImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the customer rel.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(customerRel customerRel) {
		EntityCacheUtil.removeResult(customerRelModelImpl.ENTITY_CACHE_ENABLED,
			customerRelImpl.class, customerRel.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<customerRel> customerRels) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (customerRel customerRel : customerRels) {
			EntityCacheUtil.removeResult(customerRelModelImpl.ENTITY_CACHE_ENABLED,
				customerRelImpl.class, customerRel.getPrimaryKey());
		}
	}

	/**
	 * Creates a new customer rel with the primary key. Does not add the customer rel to the database.
	 *
	 * @param uId the primary key for the new customer rel
	 * @return the new customer rel
	 */
	public customerRel create(long uId) {
		customerRel customerRel = new customerRelImpl();

		customerRel.setNew(true);
		customerRel.setPrimaryKey(uId);

		return customerRel;
	}

	/**
	 * Removes the customer rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param uId the primary key of the customer rel
	 * @return the customer rel that was removed
	 * @throws com.bank.NoSuchcustomerRelException if a customer rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public customerRel remove(long uId)
		throws NoSuchcustomerRelException, SystemException {
		return remove(Long.valueOf(uId));
	}

	/**
	 * Removes the customer rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the customer rel
	 * @return the customer rel that was removed
	 * @throws com.bank.NoSuchcustomerRelException if a customer rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public customerRel remove(Serializable primaryKey)
		throws NoSuchcustomerRelException, SystemException {
		Session session = null;

		try {
			session = openSession();

			customerRel customerRel = (customerRel)session.get(customerRelImpl.class,
					primaryKey);

			if (customerRel == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchcustomerRelException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(customerRel);
		}
		catch (NoSuchcustomerRelException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected customerRel removeImpl(customerRel customerRel)
		throws SystemException {
		customerRel = toUnwrappedModel(customerRel);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, customerRel);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(customerRel);

		return customerRel;
	}

	@Override
	public customerRel updateImpl(com.bank.model.customerRel customerRel,
		boolean merge) throws SystemException {
		customerRel = toUnwrappedModel(customerRel);

		boolean isNew = customerRel.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, customerRel, merge);

			customerRel.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(customerRelModelImpl.ENTITY_CACHE_ENABLED,
			customerRelImpl.class, customerRel.getPrimaryKey(), customerRel);

		return customerRel;
	}

	protected customerRel toUnwrappedModel(customerRel customerRel) {
		if (customerRel instanceof customerRelImpl) {
			return customerRel;
		}

		customerRelImpl customerRelImpl = new customerRelImpl();

		customerRelImpl.setNew(customerRel.isNew());
		customerRelImpl.setPrimaryKey(customerRel.getPrimaryKey());

		customerRelImpl.setUId(customerRel.getUId());
		customerRelImpl.setCustomerId(customerRel.getCustomerId());

		return customerRelImpl;
	}

	/**
	 * Returns the customer rel with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the customer rel
	 * @return the customer rel
	 * @throws com.liferay.portal.NoSuchModelException if a customer rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public customerRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the customer rel with the primary key or throws a {@link com.bank.NoSuchcustomerRelException} if it could not be found.
	 *
	 * @param uId the primary key of the customer rel
	 * @return the customer rel
	 * @throws com.bank.NoSuchcustomerRelException if a customer rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public customerRel findByPrimaryKey(long uId)
		throws NoSuchcustomerRelException, SystemException {
		customerRel customerRel = fetchByPrimaryKey(uId);

		if (customerRel == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + uId);
			}

			throw new NoSuchcustomerRelException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				uId);
		}

		return customerRel;
	}

	/**
	 * Returns the customer rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the customer rel
	 * @return the customer rel, or <code>null</code> if a customer rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public customerRel fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the customer rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param uId the primary key of the customer rel
	 * @return the customer rel, or <code>null</code> if a customer rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public customerRel fetchByPrimaryKey(long uId) throws SystemException {
		customerRel customerRel = (customerRel)EntityCacheUtil.getResult(customerRelModelImpl.ENTITY_CACHE_ENABLED,
				customerRelImpl.class, uId);

		if (customerRel == _nullcustomerRel) {
			return null;
		}

		if (customerRel == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				customerRel = (customerRel)session.get(customerRelImpl.class,
						Long.valueOf(uId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (customerRel != null) {
					cacheResult(customerRel);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(customerRelModelImpl.ENTITY_CACHE_ENABLED,
						customerRelImpl.class, uId, _nullcustomerRel);
				}

				closeSession(session);
			}
		}

		return customerRel;
	}

	/**
	 * Returns all the customer rels.
	 *
	 * @return the customer rels
	 * @throws SystemException if a system exception occurred
	 */
	public List<customerRel> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the customer rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer rels
	 * @param end the upper bound of the range of customer rels (not inclusive)
	 * @return the range of customer rels
	 * @throws SystemException if a system exception occurred
	 */
	public List<customerRel> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the customer rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer rels
	 * @param end the upper bound of the range of customer rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of customer rels
	 * @throws SystemException if a system exception occurred
	 */
	public List<customerRel> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<customerRel> list = (List<customerRel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CUSTOMERREL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOMERREL;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<customerRel>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<customerRel>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the customer rels from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (customerRel customerRel : findAll()) {
			remove(customerRel);
		}
	}

	/**
	 * Returns the number of customer rels.
	 *
	 * @return the number of customer rels
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CUSTOMERREL);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the customer rel persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bank.model.customerRel")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<customerRel>> listenersList = new ArrayList<ModelListener<customerRel>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<customerRel>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(customerRelImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = customerRelPersistence.class)
	protected customerRelPersistence customerRelPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CUSTOMERREL = "SELECT customerRel FROM customerRel customerRel";
	private static final String _SQL_COUNT_CUSTOMERREL = "SELECT COUNT(customerRel) FROM customerRel customerRel";
	private static final String _ORDER_BY_ENTITY_ALIAS = "customerRel.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No customerRel exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(customerRelPersistenceImpl.class);
	private static customerRel _nullcustomerRel = new customerRelImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<customerRel> toCacheModel() {
				return _nullcustomerRelCacheModel;
			}
		};

	private static CacheModel<customerRel> _nullcustomerRelCacheModel = new CacheModel<customerRel>() {
			public customerRel toEntityModel() {
				return _nullcustomerRel;
			}
		};
}