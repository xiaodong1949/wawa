		<nav class="navbar navbar-default" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">WAWA Park</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><spring:message code="sys.navbar.mypark" /><b
							class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath }/initMyImage.do"><spring:message code="sys.navbar.mypark.img" /></a></li>
							<li class="divider"></li>
							<li><a href="${pageContext.request.contextPath }/initMyVideo.do"><spring:message code="sys.navbar.mypark.video" /></a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> <i class="glyphicon glyphicon-user"></i> <i>${account}</i>
							<i class="glyphicon glyphicon-chevron-down"></i>
					</a>
						<ul class="dropdown-menu">
							<li><a href='#' data-toggle="modal" data-target="#login"><spring:message code="sys.navbar.login" /></a></li>
							<li class="divider"></li>
							<li><a href='#' data-toggle="modal" data-target="#register"><spring:message code="sys.navbar.register" /></a></li>
						</ul></li>
				</ul>
			</div>
		</nav>