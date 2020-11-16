<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/JavaScript" src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<!-- <script>kakao.init('a2bcde41fb4d95530b2f5fbcf6cf48c0');</script> -->

<script>
var url = location.href;

function shareFacebook(){
	var facebook = 'http://www.facebook.com/sharer/sharer.php?u='+decodeURIComponent(url);
	window.open(facebook, '', 'width=500, height=550, top=100, left=100');
}

function shareKakao(){
	alert('kakao');
}

function shareTwitter(){
	alert('twitter');
}
</script>

<!-- Footer-->
<footer class="footer text-center">
	<div class="container">
    	<div class="row">
        	<!-- Footer Location-->
            <div class="col-lg-4 mb-5 mb-lg-0">
            	<h4 class="text-uppercase mb-4">Location</h4>
                <p class="lead mb-0">2215 John Daniel Drive<br/>Clark, MO 65243</p>
            </div>
            <!-- Footer Social Icons-->
            <div class="col-lg-4 mb-5 mb-lg-0">
            	<h4 class="text-uppercase mb-4">Share</h4>
                <a onclick="shareFacebook()" class="btn btn-outline-light btn-social mx-1" href="#!"><i class="fab fa-fw fa-facebook-f"></i></a>
                <a onclick="shareTwitter()" class="btn btn-outline-light btn-social mx-1" href="#!"><i class="fab fa-fw fa-twitter"></i></a>
                <a onclick="shareKakao()" class="btn btn-outline-light btn-social mx-1" href="#!"><i class="fab fa-kickstarter-k"></i></a>
            </div>
            <!-- Footer About Text-->
            <div class="col-lg-4">
            	<h4 class="text-uppercase mb-4">About Freelancer</h4>
                <p class="lead mb-0">
                	Freelance is a free to use, MIT licensed Bootstrap theme created by
                    <a href="http://startbootstrap.com">Start Bootstrap</a>
                    .
                </p>
			</div>
		</div>
    </div>
</footer>
<!-- Copyright Section-->
<div class="copyright py-4 text-center text-white">
	<div class="container"><small>Copyright © My Website 2020</small></div>
</div>