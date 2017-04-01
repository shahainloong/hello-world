<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
        <script language="javascript">
           function userDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/user?type=userDel&id="+id;
               }
           }
           function userAdd()
           {
                 var url="<%=path %>/admin/user/userAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="9" background="<%=path %>/img/tbg.gif">&nbsp;用户&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="10%">姓名</td>
					<td width="10%">性别</td>
					<td width="10%">年龄</td>
					<td width="15%">电话</td>
					<td width="10%">住址</td>
					<td width="10%">登录账号</td>
					<td width="10%">登录密码</td>
					<td width="15%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.userList}" var="user">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${user.name}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${user.sex}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${user.age}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${user.tel}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${user.address}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${user.loginName}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${user.loginPw}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="userDel(${user.id})" class="pn-loperator">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
