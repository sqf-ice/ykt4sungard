<%@ include file="/html/extcommon/init.jsp" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.kingstargroup.ecard.hibernate.upload.UploadFiles" %>
<%@ page import="org.apache.struts.validator.DynaValidatorForm" %>
<%@ page import="com.kingstargroup.ecard.hibernate.information.EcardInformation" %>
<%@ page import="com.kingstargroup.ecard.hibernate.util.ResultPage" %>
<%@ page import="com.kingstargroup.ecard.hibernate.util.InformationUtil" %>
<%@ page import="com.kingstargroup.ecard.hibernate.util.UploadFileUtil" %>
<%@ page import="com.kingstargroup.ecard.util.EcardConstants" %>
<%@ page import="com.kingstargroup.ecard.util.PermissionUtil" %>
<%@ page import="com.kingstargroup.ecard.exceptions.FileSizeException" %>
<%@ page import="com.kingstargroup.ecard.exceptions.FileNameException" %>
<%@ page import="com.kingstargroup.ecard.util.DateFormatUtil" %>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.util.servlet.SessionErrors"%>
<%@page import="com.kingstargroup.ecard.portlet.information.service.EcardInformationServiceUtil"%>
<%@page import="com.kingstargroup.ecard.portlet.uploadfile.service.UploadFileServiceUtil"%>
<portlet:defineObjects />