/**
 * Created by User on 10.04.2017.
 */
$(document).ready(function () {
    
    
    $(".if-empty1").blur(function(){
        if( ($(".if-empty1").val().length > 0) && ($(".if-empty2").val().length > 0 ) ){
            $('.no-click-btn').css("cursor", "default");
        }
        
    });
    
    $(".if-empty2").blur(function(){
        if( ($(".if-empty1").val().length > 0) && ($(".if-empty2").val().length > 0 ) ){
            $('.no-click-btn').css("cursor", "default");
        }
        
    });
    
    /*$(".my-link").attr("target", "_blank");
    var tmp_str = $(".my-link").html();
    tmp_str = tmp_str.replace('https://www.','Оставить отзыв на ');
    var to = tmp_str.search('/'); 
    tmp_str = tmp_str.substring(0,to);
    $(".my-link").html(tmp_str);*/
    
    var topH = $(".header").height();
    $(".content-margin").css("height",topH);
    
    $(window).resize(function (){
        var topH = $(".header").height();
        $(".content-margin").css("height",topH);
    });
    $(".to-top").click(function(){
        $("body").animate({scrollTop:0}, '700');
    })


        $(".navbar-nav li").hover(
            function () {
                $(this).find("ul").slideDown(300);
                $(this).find("ul").clearQueue();
            },
            function () {
                $(this).find("ul").slideUp(300);
                $(this).find("ul").clearQueue();
            }
        );
    
    

        
    
    $(".glyphicon-search").on("click", function () {
        var header_b = $(".header").offset().top;
        var header_h = $(".header").height();
        var pos_form = header_b + header_h;
        $("#search").offset({top: pos_form});
        $("#search").slideDown();
    });
    $(".glyphicon-remove").on("click", function () {
        $("#search").slideUp();
    });
    $(window).scroll(function () {
        if ($(window).scrollTop() > $(".header-top").height()) {
            /*$(".header-top").clearQueue();
            $(".header-top").css("display", "none");*/
            $(".to-top").fadeIn(300);
            $(".header > .container").addClass("header-fix-container");
            $(".fix-logo").css("display", "block");
            $(".navbar-nav").addClass("fix-navbar-nav");
            return;
        }else {
            /*$(".header-top").clearQueue();
            $(".header-top").css("display", "block");*/
            $(".to-top").fadeOut(300);
            $(".header > .container").removeClass("header-fix-container");
            $(".fix-logo").css("display", "none");
            $(".navbar-nav").removeClass("fix-navbar-nav");
            return;
        }

    });
    
    $(document).scroll(function () {
        s_top = $("body").scrollTop();
        if($(".new-bottom:nth-child(2)").length){
            yes = $(".new-bottom:nth-child(2)").offset().top;
            if(s_top > yes){
                $(".modal1").fadeIn(600);
                $(document).unbind('scroll');
            }
        }
    });
    
    $(".fa-bars").click(function(){
        $(".link-effect-2").slideToggle();
    });
    
    $("#myCarousel .item").click(function(){
       $('html, body').animate({
            scrollTop: $(".advantages").offset().top - 200
        }, 1000);
    });
    
    $(".scrolltoContent").click(function(){
       $('html, body').animate({
            scrollTop: $(".content-text").offset().top
        }, 1000);
    });
    
    
    
    $(".fancybox").fancybox();

    $(".phone_mask").mask("+375-(99)-999-99-99", {placeholder : "+375-(..)-...-..-.."});

    $(".head_question").on("click",function () {
        if($(this).parent().hasClass("active")){
            $(this).next().slideUp();
            $(this).parent().removeClass("active");
        }else{
            $(this).parent().addClass("active");
            $(this).next().slideDown();
        }
    });
    
    
    $(".call-me-btn").click(function(){
        $(".modal1").fadeIn(600);
    });
    
    $(".call-me-btn2").click(function(){
        $(".modal3").fadeIn(600);
    });
    
    $(".close-modal1").click(function(){
        $(".modal1").fadeOut(600);
    });
    
    $(".close-modal3").click(function(){
        $(".modal3").fadeOut(600);
    });
    
    $("body").click(function(){
        $(".modal2").fadeOut(600);
    });

    if(getUrlVars()["success"]==1){
        $(".modal1").fadeOut(600);
        $(".modal3").fadeOut(600);
        $(".modal2").fadeIn(600);
        
        $(".modal2").delay(3000).fadeOut(600);
    }
    
    $(document).mouseup(function (e) {
        var container = $(".modal");
        if (container.has(e.target).length === 0){
            $(".modal").fadeOut(600);
        }
    });
    
    
    $(document).ready(function(){
        $(".banner-bottom > div > div").on("click","a", function (event) {
            event.preventDefault();
            var id  = $(this).attr('href'),
                top = $(id).offset().top - 70;
            $('body,html').animate({scrollTop: top}, 1300);
        });
    });


});





function initMap() {
    var myLatLng = {lat: 53.888852,lng:27.543606};
    // Create a map object and specify the DOM element for display.
    var map = new google.maps.Map(document.getElementById('map-canvas'), {
        center: myLatLng,
        scrollwheel: false,
        zoom: 13,
        streetViewControl: true,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    var addr1= {lat: 53.888852, lng: 27.543606};
    // Create a marker and set its position.
    var marker1 = new google.maps.Marker({
        map: map,
        position: addr1,
    });

    google.maps.event.addListener(marker1, 'click', function() {
        infowindow1.open(map,marker1);
    });
    $('#addr1').click(function(){
        map.setCenter(addr1);
        map.setZoom(17);          //управляем зумом
    });
}


function getUrlVars()
{

    var vars = [], hash;

    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');

    for(var i = 0; i < hashes.length; i++)

    {

        hash = hashes[i].split('=');

        vars.push(hash[0]);

        vars[hash[0]] = hash[1];

    }

    return vars;
}


    

