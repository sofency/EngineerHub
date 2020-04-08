<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/css/bootstrap.css">
	<link rel="stylesheet" href="/css/font-awesome.min.css">
	<style>
		#container_small_tip{
			background:#EBEEF7;
			position:relative;
			overflow:hidden;
			height:36px;
			line-height:36px;
			margin-bottom: 20px;
		}
		#content_small_tip{
			position:absolute;
			left:0;
			top:0;
			white-space:nowrap;
			color: #EBEEF7;/*与背景颜色相同，先隐藏，需要时再变颜色*/
		}
		.card-img{height: 200px;border-radius:calc(.25rem - 1px);
			margin-right: 0;margin: auto;
		}
	</style>
</head>
<body>
<%@include file="../common/headerindex.jspf"%>
<div class="container">
	<div class="row text-center mb-1">
	   	<h1 class="col-md-12" style="color:#99DAF3;">OUR TEAM</h1>
	   	<p class="text-muted col-md-12">程序员，年二十有三，头秃，始从文，连考而不中。遂习武，练武场上发一矢，中鼓吏，逐之出。<br>改学IT，自撰一函数，用之，堆栈溢出</p>
	</div>
	<div id="container_small_tip">
		<div id="content_small_tip"></div>
	</div>
	<c:forEach items="${EngineerSomeInfo}" var="item">
		<div style="width:100%;background-color: rgb(247,248,250);margin-bottom: 20px">
			<div style="margin-left:0;" class="col-lg-3">
		      <img  src="${item.engineerImgPath }" class="card-img img-responsive" width="100%" alt="暂无图片">
		    </div>
		    <div  style="flex-grow: 1">
		      <div class="card-body">
		      	<div class="row" style="margin-left: 0;margin-right: 0">
			        <blockquote class="blockquote col-md-8 col-sm-8 col-xs-8">
					  <h4 class="mb-0">${item.engineerName}</h4>
					  <footer style="font-size: 18px">${item.majorName}</footer>
					</blockquote>
					<div class="col-md-1 col-sm-1 col-xs-1">
						<div class="pull-right" style="margin-top: 8px">
							<a href="${item.engineerGit}" title="github"><i class="fa fa-github" aria-hidden="true" style="font-size: 1.5em;margin-right: 10px;color:gray;"></i></a>
							<a href="${item.engineerEmail}" title="email"><i class="fa fa-envelope-o" aria-hidden="true" style="font-size: 1.5em;color:gray;"></i></a>
						</div>
					</div>
				</div>
				<hr/>
				<div class="row"  style="margin-left: 0;margin-right: 0">
					 <p class="card-text col-md-12">${item.engineerMotto}</p>
				</div>
		      </div>
		    </div>
		</div>
	</c:forEach>
</div>
<script src="/js/jquery-3.2.1.js"></script>
<script src="/js/bootstrap.js"></script>
<script>
	$("#content_small_tip")[0].innerHTML = "期待你的加入";
	(function ($) {
		$.fn.extend({
			roll: function (options) {
				var defaults = {
					speed: 1
				};
				var options = $.extend(defaults, options);
				var speed = (document.all) ? options.speed : Math.max(1, options.speed - 1);
				if ($(this) == null) return;
				var $container = $(this);
				var $content = $("#content_small_tip");
				var init_left = $container.width();
				$content.css({ left: parseInt(init_left) + "px" });
				var This = this;
				var time = setInterval(function () { This.move($container, $content, speed); }, 20); //setInterval会改变this指向，即使加了This=this，也要用匿名函数封装

				$container.bind("mouseover", function () {
					clearInterval(time);
				});
				$container.bind("mouseout", function () {
					time = setInterval(function () { This.move($container, $content, speed); }, 20);
				});
				// setTimeout(function () { $("#container").slideUp(); }, 30000);  //毫秒单位，显示30s后消失
				return this;
			},
			move: function ($container, $content, speed) {
				var container_width = $container.width();
				var content_width = $content.width();
				if (parseInt($content.css("left")) + content_width > 0) {
					$content.css({ left: parseInt($content.css("left")) - speed + "px" });
					$content.css({color:"#02A0E9"})//改变字体颜色
				}
				else {
					$content.css({ left: parseInt(container_width) + "px" });
					$content.css({color:"#02A0E9"})//改变字体颜色
				}
			}
		});
	})(jQuery);
	$(document).ready(
			function () {
				$("#container_small_tip").roll({ speed: 2 });
			}
	);

</script>
</body>
</html>