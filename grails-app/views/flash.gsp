<!doctype html>
<html>
    <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
      <asset:stylesheet src="application.css"/>
      <asset:stylesheet src="jquery-ui.css"/>
    </head>
    <body class="spashPage">
      <div class="container">
        <div class="slider">
            <div class="slideTextWrap text-center clearfix cycle-slideshow"
            data-cycle-fx="scrollHorz"
            data-cycle-timeout="3000"
            data-cycle-swipe="true"
            data-cycle-swipe-fx="scrollHorz"
            data-cycle-slides="> .slide"
            >
                <div class="slide">
                  <i><img src="/assets/splash-icon1.png" alt=""/></i>
                  <div class="sliderText">
                   <p>Safe road design is now about providing a road environment which ensures vehicle speeds will be within the human tolerances for serious injury and death wherever conflict points exist.</p>
                  </div>
                </div>

                <div class="slide">
                  <i><img src="/assets/splash-icon2.png" alt=""/></i>
                  <div class="sliderText">
                   <p>Safe road design is now about providing a road environment which ensures vehicle speeds will be within the human tolerances for serious injury and death wherever conflict points exist.</p>
                  </div>
                </div>

                <div class="slide">
                  <i><img src="/assets/splash-icon3.png" alt=""/></i>
                  <div class="sliderText">
                   <p>Safe road design is now about providing a road environment which ensures vehicle speeds will be within the human tolerances for serious injury and death wherever conflict points exist.</p>
                  </div>
                </div>

            </div>
        </div>
      </div>
      <div class="skipWrapper">
        <a class="btn btn-primary" href="/dashboard">SKIP</a>
      </div>
      <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js"></script>
      <script src="http://malsup.github.io/jquery.cycle2.js"></script>
    </body>
</html>
