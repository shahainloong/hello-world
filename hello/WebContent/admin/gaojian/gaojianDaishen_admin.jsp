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
		<script type="text/javascript" src="<%=path %>/js/popup.js"></script>
        <script language="javascript">
           function down1(fujianPath,fujianYuashiMing)
           {
               var url="<%=path %>/updown/updown.jsp?fujianPath="+fujianPath+"&fujianYuashiMing="+fujianYuashiMing;
		       url=encodeURI(url); 
               url=encodeURI(url); 
               window.open(url,"_self");
           }
           
            function gaojianShePre_admin(id)
		    {
		        var url="<%=path %>/admin/gaojian/gaojianShePre_admin.jsp?id="+id;
		        var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:300});
	            pop.setContent("contentUrl",url);
	            pop.setContent("title","");
	            pop.build();
	            pop.show();
		    }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="63" background="<%=path %>/img/tbg.gif">&nbsp;稿件&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="20%">标题</td>
					<td width="20%">内容</td>
					<td width="8%">附件</td>
					<td width="8%">上传时间</td>
					
					<td width="10%">专家审核信息</td>
					<td width="10%">主编审核信息</td>
					<td width="5%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.gaojianList}" var="gaojian">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${gaojian.title}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${gaojian.content}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<c:if test="${gaojian.fujianYuanshiming==''}">
						   无附件
						</c:if>
						<c:if test="${gaojian.fujianYuanshiming!=''}">
						   ${gaojian.fujianYuanshiming}
						   <a href="#" style="color: red" onclick="down1('${gaojian.fujian}','${gaojian.fujianYuanshiming}')">下载</a>
						</c:if>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${gaojian.shijian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<c:if test="${gaojian.zhuanjiashenhebiaozhi=='shenhezhong'}">
						    专家审核中
						    <a href="#" style="color: red" onclick="gaojianShePre_zhuanjia(${gaojian.id})">审核</a>
						</c:if>
						<c:if test="${gaojian.zhuanjiashenhebiaozhi=='shenhetongguo'}">
						    专家审核通过(审核意见：${gaojian.zhuanjiashenheyijian})
						</c:if>
						<c:if test="${gaojian.zhuanjiashenhebiaozhi=='shenhetongguono'}">
						    专家审核未通过(审核意见：${gaojian.zhuanjiashenheyijian})
						</c:if>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<c:if test="${gaojian.zhubianshenhebiaozhi=='shenhezhong'}">
						    主编审核中
						    <a href="#" style="color: red" onclick="gaojianShePre_admin(${gaojian.id})">审核</a>
						</c:if>
						<c:if test="${gaojian.zhubianshenhebiaozhi=='shenhetongguo'}">
						    主编审核通过(审核意见：${gaojian.zhubianshenyijian})
						</c:if>
						<c:if test="${gaojian.zhubianshenhebiaozhi=='shenhetongguono'}">
						    主编审核未通过(审核意见：${gaojian.zhubianshenyijian})
						</c:if>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="删除" onclick="gaojianDel(${gaojian.id})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
