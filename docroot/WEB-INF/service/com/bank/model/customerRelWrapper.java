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

package com.bank.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link customerRel}.
 * </p>
 *
 * @author    priyanka
 * @see       customerRel
 * @generated
 */
public class customerRelWrapper implements customerRel,
	ModelWrapper<customerRel> {
	public customerRelWrapper(customerRel customerRel) {
		_customerRel = customerRel;
	}

	public Class<?> getModelClass() {
		return customerRel.class;
	}

	public String getModelClassName() {
		return customerRel.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uId", getUId());
		attributes.put("customerId", getCustomerId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long uId = (Long)attributes.get("uId");

		if (uId != null) {
			setUId(uId);
		}

		String customerId = (String)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
		}
	}

	/**
	* Returns the primary key of this customer rel.
	*
	* @return the primary key of this customer rel
	*/
	public long getPrimaryKey() {
		return _customerRel.getPrimaryKey();
	}

	/**
	* Sets the primary key of this customer rel.
	*
	* @param primaryKey the primary key of this customer rel
	*/
	public void setPrimaryKey(long primaryKey) {
		_customerRel.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the u ID of this customer rel.
	*
	* @return the u ID of this customer rel
	*/
	public long getUId() {
		return _customerRel.getUId();
	}

	/**
	* Sets the u ID of this customer rel.
	*
	* @param uId the u ID of this customer rel
	*/
	public void setUId(long uId) {
		_customerRel.setUId(uId);
	}

	/**
	* Returns the customer ID of this customer rel.
	*
	* @return the customer ID of this customer rel
	*/
	public java.lang.String getCustomerId() {
		return _customerRel.getCustomerId();
	}

	/**
	* Sets the customer ID of this customer rel.
	*
	* @param customerId the customer ID of this customer rel
	*/
	public void setCustomerId(java.lang.String customerId) {
		_customerRel.setCustomerId(customerId);
	}

	public boolean isNew() {
		return _customerRel.isNew();
	}

	public void setNew(boolean n) {
		_customerRel.setNew(n);
	}

	public boolean isCachedModel() {
		return _customerRel.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_customerRel.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _customerRel.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _customerRel.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_customerRel.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _customerRel.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_customerRel.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new customerRelWrapper((customerRel)_customerRel.clone());
	}

	public int compareTo(com.bank.model.customerRel customerRel) {
		return _customerRel.compareTo(customerRel);
	}

	@Override
	public int hashCode() {
		return _customerRel.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.bank.model.customerRel> toCacheModel() {
		return _customerRel.toCacheModel();
	}

	public com.bank.model.customerRel toEscapedModel() {
		return new customerRelWrapper(_customerRel.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _customerRel.toString();
	}

	public java.lang.String toXmlString() {
		return _customerRel.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_customerRel.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public customerRel getWrappedcustomerRel() {
		return _customerRel;
	}

	public customerRel getWrappedModel() {
		return _customerRel;
	}

	public void resetOriginalValues() {
		_customerRel.resetOriginalValues();
	}

	private customerRel _customerRel;
}