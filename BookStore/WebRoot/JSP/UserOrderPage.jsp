<%@ page language="java" import="java.util.*,beans.*,dao.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>UserOrderPage.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
  Boolean isInit=(Boolean)session.getAttribute("UserOrderPage_isInit");
  List<OrderBean> oList=null;
  if(isInit==null||isInit==false){//说明没有被初始化,所以要发请求到MainServlet去
  session.setAttribute("UserOrderPage_isInit",true);
  session.setAttribute("UserOrderPage_pageNum",1);
  session.setAttribute("UserOrderPage_pageSize",2);
  session.setAttribute("UserOrderPage_UserID",3);
  response.sendRedirect("servlet/UserOrderServlet");
  }
  else{
  //走到这里说明初始化
  int pageNum=(Integer)session.getAttribute("UserOrderPage_pageNum");
  int pageSize=(Integer)session.getAttribute("UserOrderPage_pageSize");
  oList=(List<OrderBean>)session.getAttribute("UserOrderPage_OrderList");
  }
   %>
  <body>
  Show Orders:<br>
    <%if(oList!=null){ %>
    <%for(int i=0;i<oList.size();i++){ %>
    <%=oList.get(i).getoID()+"-" %>
    <%} %>
    <%="   <br>最多"+session.getAttribute("UserOrderPage_pageMaxNum")+"个" %>
    <%} %>
  <br>  
  Show Books:<br>
  <%List<BookBean> blist=(List<BookBean>)session.getAttribute("blist"); %>
    <%if(blist!=null){ %>
    <%for(int i=0;i<blist.size();i++){ %>
    <%=blist.get(i).getbTitle()%>
    <%} %>
    <%} %>
  </body>
</html>
