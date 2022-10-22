//menu
$(window).on('scroll', function () {
    if ($(window).scrollTop()) {
        $('nav').addClass('black')
    } else {
        $('nav').removeClass('black')
    }
})
$('#carouselExampleFade').ready(function () {
    $('.carousel-inner').find('.carousel-item').first().addClass('active')
})

function choseImage(src) {
    var link = src
    document.getElementById("showTagImg").src = link
    document.getElementById("showTagA").href = link
}

//  active class menu
var selector = '.nav_menu_ul_li_item .nav_menu_ul_link';

$(selector).on('click', function(){
    $(selector).removeClass('active');
    $(this).addClass('active');
});

// scroll to top
$(document).ready(function () {
    //show or hidden button scroll
    $(window).scroll(function () {
        $('#scrollToTop').each(function (i) {
            if ($(window).scrollTop() > 260) {
                $(this).stop().animate({
                    'opacity': '1'
                }, 200);
            } else {
                $(this).stop().animate({
                    'opacity': '0'
                }, 200);
            }

        });
    })

    //smooth scrolling to top
    $('#scrollToTop').click(function () {
        $('html, body').animate({screenTop: 250}, 1000)

    });
})

//  active class nav_link_active
var selector = '.nav-item .nav_link_btn';

$(selector).on('click', function(){
    $(selector).removeClass('nav_link_active');
    $(this).addClass('nav_link_active');
});

//active class carouselExampleIndicators
$('#carouselExampleIndicators').ready(function(){
    $('.carousel-inner').find('.carousel-item').first().addClass('active')
})