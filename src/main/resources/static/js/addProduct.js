$(document).ready(function () {
    showAddImg();
})

function showAddImg() {
    $('#productImgUrl').on('change', function () {
        // Xóa img cũ
        $('.add-product-img img').remove();
        //xóa label cũ
        $('.label-product-img-input').text('Choose file...');
        const file = this.files[0];
        var img = $('<img>', {
            src: URL.createObjectURL(file),
            alt: "img-not-found"
        });
        $('.add-product-img').append(img);
        $('.label-product-img-input').text(file.name);
    })
}