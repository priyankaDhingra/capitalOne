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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bank.service.http.customerRelServiceSoap}.
 *
 * @author    priyanka
 * @see       com.bank.service.http.customerRelServiceSoap
 * @generated
 */
public class customerRelSoap implements Serializable {
	public static customerRelSoap toSoapModel(customerRel model) {
		customerRelSoap soapModel = new customerRelSoap();

		soapModel.setUId(model.getUId());
		soapModel.setCustomerId(model.getCustomerId());

		return soapModel;
	}

	public static customerRelSoap[] toSoapModels(customerRel[] models) {
		customerRelSoap[] soapModels = new customerRelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static customerRelSoap[][] toSoapModels(customerRel[][] models) {
		customerRelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new customerRelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new customerRelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static customerRelSoap[] toSoapModels(List<customerRel> models) {
		List<customerRelSoap> soapModels = new ArrayList<customerRelSoap>(models.size());

		for (customerRel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new customerRelSoap[soapModels.size()]);
	}

	public customerRelSoap() {
	}

	public long getPrimaryKey() {
		return _uId;
	}

	public void setPrimaryKey(long pk) {
		setUId(pk);
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

	private long _uId;
	private String _customerId;
}