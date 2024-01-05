$(document).ready(function () {
    openDetail();
})


function openDetail() {
    $('.data td .view-detail').click(function () {
        $('.detail-container ').css({
            'transform': 'scale(1)',
        });
    })

    $('.card-header i').click(function () {
        $('.detail-container').css({
            'transform': 'scale(0)',
        })
    })
    $('.detail-background').click(function () {
        $('.detail-container').css({
            'transform': 'scale(0)',
        })
    })
}
