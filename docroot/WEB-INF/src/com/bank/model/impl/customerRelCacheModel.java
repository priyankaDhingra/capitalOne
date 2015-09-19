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

package com.bank.model.impl;

import com.bank.model.customerRel;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing customerRel in entity cache.
 *
 * @author priyanka
 * @see customerRel
 * @generated
 */
public class customerRelCacheModel implements CacheModel<customerRel>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{uId=");
		sb.append(uId);
		sb.append(", customerId=");
		sb.append(customerId);
		sb.append("}");

		return sb.toString();
	}

	public customerRel toEntityModel() {
		customerRelImpl customerRelImpl = new customerRelImpl();

		customerRelImpl.setUId(uId);

		if (customerId == null) {
			customerRelImpl.setCustomerId(StringPool.BLANK);
		}
		else {
			customerRelImpl.setCustomerId(customerId);
		}

		customerRelImpl.resetOriginalValues();

		return customerRelImpl;
	}

	public long uId;
	public String customerId;
}