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

import com.bank.service.customerRelLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author priyanka
 */
public class customerRelClp extends BaseModelImpl<customerRel>
	implements customerRel {
	public customerRelClp() {
	}

	public Class<?> getModelClass() {
		return customerRel.class;
	}

	public String getModelClassName() {
		return customerRel.class.getName();
	}

	public long getPrimaryKey() {
		return _uId;
	}

	public void setPrimaryKey(long primaryKey) {
		setUId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_uId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uId", getUId());
		attributes.put("customerId", getCustomerId());

		return attributes;
	}

	@Override
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

	public long getUId() {
		return _uId;
	}

	public void setUId(long uId) {
		_uId = uId;
	}

	public String getCustomerId() {
		return _customerId;
	}

	public void setCustomerId(String customerId) {
		_customerId = customerId;
	}

	public BaseModel<?> getcustomerRelRemoteModel() {
		return _customerRelRemoteModel;
	}

	public void setcustomerRelRemoteModel(BaseModel<?> customerRelRemoteModel) {
		_customerRelRemoteModel = customerRelRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			customerRelLocalServiceUtil.addcustomerRel(this);
		}
		else {
			customerRelLocalServiceUtil.updatecustomerRel(this);
		}
	}

	@Override
	public customerRel toEscapedModel() {
		return (customerRel)Proxy.newProxyInstance(customerRel.class.getClassLoader(),
			new Class[] { customerRel.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		customerRelClp clone = new customerRelClp();

		clone.setUId(getUId());
		clone.setCustomerId(getCustomerId());

		return clone;
	}

	public int compareTo(customerRel customerRel) {
		long primaryKey = customerRel.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		customerRelClp customerRel = null;

		try {
			customerRel = (customerRelClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = customerRel.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{uId=");
		sb.append(getUId());
		sb.append(", customerId=");
		sb.append(getCustomerId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.bank.model.customerRel");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uId</column-name><column-value><![CDATA[");
		sb.append(getUId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customerId</column-name><column-value><![CDATA[");
		sb.append(getCustomerId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _uId;
	private String _customerId;
	private BaseModel<?> _customerRelRemoteModel;
}