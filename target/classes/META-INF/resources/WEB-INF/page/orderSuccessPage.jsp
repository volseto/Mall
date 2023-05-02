<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="include/header.jsp" %>
<head>
    <link href="${pageContext.request.contextPath}/res/css/fore/fore_orderSuccessPage.css" rel="stylesheet"/>
    <title>交易成功 - mall.com</title>
</head>
<body>
<nav>
    <%@ include file="include/navigator.jsp" %>
</nav>
<div class="header">
    <div id="mallLogo">
        <a href="${pageContext.request.contextPath}"><img
                src="${pageContext.request.contextPath}/res/images/fore/WebsiteImage/tmallLogoA.png"></a>
    </div>
    <div class="shopSearchHeader">
        <form action="${pageContext.request.contextPath}/product" method="get">
            <div class="shopSearchInput">
                <input type="text" class="searchInput" name="product_name" placeholder="搜索 天猫 商品/品牌/店铺"
                       maxlength="50">
                <input type="submit" value="搜 索" class="searchBtn">
            </div>
        </form>
    </div>
</div>
<div class="content">
    <div class="take-delivery">
        <div class="summary-status">
            <h2>交易已经成功，卖家将收到您的货款。</h2>
            <c:if test="${requestScope.product != null}">
            </c:if>
            <p>您可以查看：<a href="${pageContext.request.contextPath}/order/0/10">已买到的宝贝</a></p>
        </div>
    </div>
</div>
</body>