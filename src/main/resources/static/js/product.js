$(document).ready(function () {
    showDropdown();
    hideDropdown();
    autoActiveCategoryCheckbox();
    showCustomize();
    showItemDetail();
})



function showDropdown() {
    $('.show-dropdown-menu').click(function () {
        $(this).closest(".select-category").find('.dropdown-menu-custom-container').css({
            'height': '220px'
        });
        $(this).closest(".select-watch-size").find('.dropdown-menu-custom-container').css({
            'height': '100px'
        });
        $(this).closest(".select-color").find('.dropdown-menu-custom-container').css({
            'height': '70px'
        });
        $(this).closest(".select-sunglasses-type").find('.dropdown-menu-custom-container').css({
            'height': '250px'
        });
        $(this).closest(".select-material").find('.dropdown-menu-custom-container').css({
            'height': '200px'
        });
        $(this).closest(".dropdown").find('.dropdown-menu-custom').css({
            'top': '0px'
        });
        $(this).closest(".dropdown").find('.show-dropdown-menu').css({
            'display': 'none',
        });
        $(this).closest(".dropdown").find('.hide-dropdown-menu').css({
            'display': 'block'
        });
    })
}

function hideDropdown() {
    $('.hide-dropdown-menu').click(function () {
        $(this).closest(".dropdown").find('.dropdown-menu-custom-container').css({
            'height': '0'
        });
        $(this).closest(".dropdown").find('.dropdown-menu-custom').css({
            'top': '-50px'
        });
        $(this).closest(".dropdown").find('.show-dropdown-menu').css({
            'display': 'block'
        });
        $(this).closest(".dropdown").find('.hide-dropdown-menu').css({
            'display': 'none'
        });
    })
}
function autoActiveCategoryCheckbox() {
    //Nếu user chọn size đồng hồ => đồng hồ ở category active
    $('.select-watch-size .tgl-flip').click(function () {
        var isChecked = $(this).is(':checked');
        if (isChecked) {
            $('.select-category #watches').prop('checked', true);
        }
    });

    //Nếu user bỏ chọn đồng hồ trong category => Remove all option in select watch-size
    $('.select-category #watches').click(function () {
        var isChecked = $(this).is(':checked');
        if (!isChecked) {
            $('.select-watch-size .tgl-flip').prop('checked', false);
        }
    });

    //Nếu user chọn kiểu kính râm => kính râm ở category active
    $('.select-sunglasses-type .checkbox-input').click(function () {
        var isChecked = $(this).is(':checked');
        if (isChecked) {
            $('.select-category #sunglasses').prop('checked', true);
        }
    });
    //Nếu user bỏ chọn kính râm trong category => Remove all option in select sunglasses type
    $('.select-category #sunglasses').click(function () {
        var isChecked = $(this).is(':checked');
        if (!isChecked) {
            $('.select-sunglasses-type .checkbox-input').prop('checked', false);
        }
    });
}

function showCustomize() {
    $('.btn-customize').click(function () {
        $('.select-item-type-containner').css({
            'display': 'flex',
            'transform': 'translateX(0)',
        })
    })
    $('.out-customize-icon').click(function () {
        $('.select-item-type-containner').css({
            'transform': 'translateX(-100%)',
        })
    })
    $('.select-item-type-background').click(function () {
        $('.select-item-type-containner').css({
            'transform': 'translateX(-100%)',
        })
    })
}

function showItemDetail() {
    $('.products .card img').click(function () {
        $('.item-details-container').css({
            'transform': 'translateY(0)',
        })
    })
    $('.out-item-detail-icon').click(function () {
        $('.item-details-container').css({
            'transform': 'translateY(-100%)',
        })
    })
    $('.item-detail-background').click(function () {
        $('.item-details-container').css({
            'transform': 'translateY(-100%)',
        })
    })
}