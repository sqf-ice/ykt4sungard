package com.kingstargroup.fdykt.trade;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.kingstargroup.fdykt.dao.DB2AccountDAO;
import com.kingstargroup.fdykt.dao.DB2CardDAO;
import com.kingstargroup.fdykt.dao.DB2TradeSerialDAO;
import com.kingstargroup.fdykt.dao.KSDaoSessionFactory;
import com.kingstargroup.fdykt.dto.CardDTO;

/**
 * <p>Title:Test</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: kingstargroup</p>
 * @author
 * @version 1.0
 */

public class GetSidyQueryAction extends Action {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(GetSidyQueryAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		KSDaoSessionFactory.createSession();
		ActionForward forward = doSidyLogin(mapping, request);
		try {
			KSDaoSessionFactory.commit();
		} catch (SQLException e) {
			logger.error("�ύ����ʧ��");
			e.printStackTrace();
		}
		return forward;
	}

	private ActionForward doSidyLogin(ActionMapping mapping, HttpServletRequest request) {
		DB2AccountDAO accdao = new DB2AccountDAO();
		String cardphyno = (String) request.getParameter("cardno");	//��������
		String sidyno = (String) request.getParameter("sidyno");//�������κ�
		String reqpage = request.getParameter("page");
		String hexcardno = Integer.toHexString(Integer.parseInt(cardphyno))
		.toUpperCase();
		ActionErrors errors = new ActionErrors();
		int deviceid = -2;
		try {
			String reqip = request.getRemoteAddr();
			System.out.print("������ȡip����"+reqip);
			deviceid = accdao.getdevidFromip(reqip);
			if (deviceid < 0) {
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionError(
						"deviceid.notregister"));
				saveErrors(request, errors);
				return mapping.findForward("failure");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionError(
					"deviceid.notregister"));
			saveErrors(request, errors);
			return mapping.findForward("failure");
		}
		for (int i = hexcardno.length(); i < 8; i++) {
			hexcardno = "0" + hexcardno;//pad left
		}
		if (cardphyno == null || "".equals(cardphyno))
			return mapping.findForward("logon");
		try {
			DB2CardDAO carddao = new DB2CardDAO();

			// ��ѯ��Ψһ�Ŀ�
			CardDTO card = carddao.getCardInfoById(hexcardno);
			
			if (card == null) {				
				return mapping.findForward("carderror");
			}else{
				DB2TradeSerialDAO tradeserialdao = new DB2TradeSerialDAO();		
				int count = tradeserialdao.getSidyCountByCardId(card.getCardno(),sidyno);			
				if(0==count){
					//û�в���
					return (mapping.findForward("null"));
				}else{
					ArrayList ttifsidys = new ArrayList();
					Integer page = new Integer(1);
					if(reqpage!=null){
						page = new Integer(reqpage);
					}
					
//					��ѯ�����е�δ��ȡ������һ����ȡ��ϡ�
					ttifsidys = tradeserialdao.getAssistanceSerial(card.getCardno(),sidyno,(page.intValue() - 1) * 10 + 1 );
					request.setAttribute("ttifsidys", ttifsidys);
					request.setAttribute("page", page);
					request.setAttribute("count", String.valueOf(count));
					request.setAttribute("cardphyno", cardphyno);			
					request.setAttribute("sidyno", sidyno);	
					request.setAttribute("cardno", String.valueOf(card.getCardno()));
				}
				return (mapping.findForward("success"));
			}
			
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionError(
			"function.error"));
			saveErrors(request, errors);
			e.printStackTrace();
			return (mapping.findForward("failure"));
		}
	}
}