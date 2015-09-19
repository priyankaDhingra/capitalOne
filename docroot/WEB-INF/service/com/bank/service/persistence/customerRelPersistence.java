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

import com.bank.model.customerRel;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the customer rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author priyanka
 * @see customerRelPersistenceImpl
 * @see customerRelUtil
 * @generated
 */
public interface customerRelPersistence extends BasePersistence<customerRel> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link customerRelUtil} to access the customer rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the customer rel in the entity cache if it is enabled.
	*
	* @param customerRel the customer rel
	*/
	public void cacheResult(com.bank.model.customerRel customerRel);

	/**
	* Caches the customer rels in the entity cache if it is enabled.
	*
	* @param customerRels the customer rels
	*/
	public void cacheResult(
		java.util.List<com.bank.model.customerRel> customerRels);

	/**
	* Creates a new customer rel with the primary key. Does not add the customer rel to the database.
	*
	* @param uId the primary key for the new customer rel
	* @return the new customer rel
	*/
	public com.bank.model.customerRel create(long uId);

	/**
	* Removes the customer rel with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param uId the primary key of the customer rel
	* @return the customer rel that was removed
	* @throws com.bank.NoSuchcustomerRelException if a customer rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bank.model.customerRel remove(long uId)
		throws com.bank.NoSuchcustomerRelException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bank.model.customerRel updateImpl(
		com.bank.model.customerRel customerRel, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the customer rel with the primary key or throws a {@link com.bank.NoSuchcustomerRelException} if it could not be found.
	*
	* @param uId the primary key of the customer rel
	* @return the customer rel
	* @throws com.bank.NoSuchcustomerRelException if a customer rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bank.model.customerRel findByPrimaryKey(long uId)
		throws com.bank.NoSuchcustomerRelException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the customer rel with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param uId the primary key of the customer rel
	* @return the customer rel, or <code>null</code> if a customer rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bank.model.customerRel fetchByPrimaryKey(long uId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the customer rels.
	*
	* @return the customer rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bank.model.customerRel> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bank.model.customerRel> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bank.model.customerRel> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the customer rels from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of customer rels.
	*
	* @return the number of customer rels
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}