<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<head>
<meta charset="UTF-8">
<title>欢迎注册</title>
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/resource/css/cms.css" />
<link rel="stylesheet"  type="text/css"  href="/resource/css/jquery/screen.css">
<style type="text/css">
.form-inline label {
	display: inline-block;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/top.jsp"></jsp:include>
	
	<!-- 登录注册页面 -->
	<div style="height: 50px;"></div>
	
	<div class="container">
		<div class="row passport_bg">
			<div class="col-md-6">
				<div class="passport_panel">
					<div class="card">
						<div class="card-header">欢迎注册</div>
						<div class="card-body">
						
							<form action="/user/register" method="post" id="valiateform">
									<p class="w-100" align="center" style="color: red">${errorMsg}</p>
									<div class="form-group">
										<label for="username">用户名:</label> <input type="text"
											class="form-control" name="username" 
											required="true"
											maxlength="12"
											minlength="3"
											remote="/user/checkExist"
											placeholder="请输入用户名">
									</div>
									<div class="form-group">
										<label for="password">密码:</label> <input type="password"
											class="form-control" name="password" id="password"
											required="true"
											maxlength="12"
											minlength="3"
											placeholder="请输入密码">
									</div>
									
									<div class="form-group">
										<label for="gender">性别:</label> <input class="radio"
											type="radio" class="form-control" name="gender" id="gender"
											value="1" checked="checked">男 <input type="radio"
											class="radio" name="gender" class="form-control" id="gender"
											value="2">女
									</div>
	
									<div class="form-group">
										<button type="submit" class="btn btn-info">注册</button>
										<p class="w-100" align="right">
											如果已有帐号，请<a href="/user/login">点这里登录</a>
										</p>
									</div>
	
								</form>
						</div>
					</div>
				</div>
			</div>
			
			<div class="col-md-6">
				<div class="passport_r">
					<h3>最新加入的用户：</h3>
					<p align="center">
						<img src="/resource/images/guest.jpg" alt="..."
							class="rounded-circle img-thumbnail" /> &nbsp;&nbsp;&nbsp;&nbsp;
						<img src="/resource/images/guest1.jpg" alt="..."
							class="rounded-circle img-thumbnail" />
					</p>
				</div>
			</div>
		</div>
	</div>
	
	<div>
		<br /> <br />
	</div>
	
	<jsp:include page="/WEB-INF/view/common/footer.jsp" />
	
	<script type="text/javascript">
		$("#valiateform").validate();
	</script>
</body>
</html>