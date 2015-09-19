package com.bank.action;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.bank.model.customerRel;
import com.bank.service.customerRelLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class BankPortletAction
 */
public class BankPortletAction extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		User user = (User) renderRequest.getAttribute(WebKeys.USER);
		String cid = "";
		System.out.println("userId--->" + user.getUserId());
//		try {
//		customerRel customerRel = customerRelLocalServiceUtil
//		.createcustomerRel(10666);
//		customerRel.setCustomerId("54b604dfa520e02948a0f6da");
//		customerRelLocalServiceUtil.add(customerRel);
//
//
//
//	customerRel customerRel1 = customerRelLocalServiceUtil
//
//	.createcustomerRel(10691);
//
//	customerRel1.setCustomerId("54b604dfa520e02948a0f6e0");
//
//	
//		customerRelLocalServiceUtil.add(customerRel1);
//	} catch (SystemException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}


		try {
			for (long rid : user.getRoleIds()) {
				if (rid == 10664) {
					// if Customer
					System.out.println("customerId");
					cid = customerRelLocalServiceUtil.getcustomerRel(
							user.getUserId()).getCustomerId();
					renderRequest.setAttribute("cid", cid);
					renderResponse.setContentType("text/html");
					include("/html/bankportletaction/view.jsp", renderRequest,
							renderResponse);
					break;
				}
				if (rid == 10680) {
					// if bank
					for (customerRel cust : customerRelLocalServiceUtil
							.getcustomerRels(0, customerRelLocalServiceUtil
									.getcustomerRelsCount() - 1)) {
						System.out.println("banker====>" + cust);
						
					}
					renderResponse.setContentType("text/html");
					include("/html/bankportletaction/lists.jsp",
							renderRequest, renderResponse);
					break;
				}
			}

		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}

		//super.doView(renderRequest, renderResponse);
	}

}
