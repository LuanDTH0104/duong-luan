$(document).ready(function () {
    scrollNavBar();
    calculateTotalPrice();
    countProduct();
    showCard();
    showSearch();
});
// js for nav-bar 
function scrollNavBar() {
    $(window).scroll(function () {
        if ($(this).scrollTop()) {
            $('header').addClass('sticky');
        } else {
            $('header').removeClass('sticky');
        }
    })
}

//Js show search bar
function showSearch() {
    var isSearchIconClicked = false;
    $('.search-icon').click(function () {
        if (!isSearchIconClicked) {
            $('.search-input').css({
                'display': 'block',
                'padding-left': '10px',
                'padding-right': '40px',
                'width': '250px'

            });
            $('.search-icon').addClass('icon-active');
            isSearchIconClicked = true;
        } else {
            $('.search-input').css({
                'width': '0',
                'padding': '0',
            });
            $('.search-icon').removeClass('icon-active');
            isSearchIconClicked = false;
        }
    });
}
//Js show card
function showCard() {
    $('.fa-shopping-cart').click(function () {
        $('.cart-container').css({
            'display': 'flex',
            'transform': 'translateX(0)',
        })
    })
    $('.out-cart-icon').click(function () {
        $('.cart-container').css({
            'transform': 'translateX(100%)',
        })

    })
    $('.cart-background').click(function () {
        $('.cart-container').css({
            'transform': 'translateX(100%)',
        })
    })
}

//js count number product in cart
function countProduct() {
    $(".decrease-product").click(function () {
        // Xử lý khi nhấp vào nút "-"
        var numberProduct = parseInt($(this).closest(".pagination").find(".number-product p").text()) - 1;
        // Thực hiện các thao tác Ajax hoặc thay đổi số ở đây
        if (numberProduct === 0) {
            numberProduct = 1;
        }
        $(this).closest(".pagination").find(".number-product p").text(numberProduct);
        calculateTotalPrice();
    });

    $(".increase-product").click(function () {
        // Xử lý khi nhấp vào nút "+"
        var numberProduct = parseInt($(this).closest(".pagination").find(".number-product p").text()) + 1;
        // Thực hiện các thao tác Ajax hoặc thay đổi số ở đây
        $(this).closest(".pagination").find(".number-product p").text(numberProduct);
        calculateTotalPrice();
    });
}
//js for total price product in cart
function calculateTotalPrice() {
    var totalPrice = 0;
    $(".cart-item").each(function () {
        var priceString = $(this).find(".cart-item-detail .price").text();
        var price = parseFloat(priceString.replace(/[^\d.]/g, ''));
        var quantity = parseInt($(this).find(".cart-number-product .number-product p.page-link").text());

        totalPrice += price * quantity;
    });


    var discount = parseFloat($('#discount').text());
    totalPrice = Math.ceil(totalPrice * 1000000 * (100 - discount) / 100);
    var formattedString = totalPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
    $('#total-price').text(formattedString)
}

