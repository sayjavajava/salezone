$(function() {
    $("#f_product-1").click(function(){
        imagePath = $("#memodel-render").attr('src',"room/female/model-layer-1.png");
        if(imagePath == "room/female/model-layer-1.png"){
            $("#recomended-1").attr("src", "room/female/dress-2.jpg");}else {
            $("#recomended-2").attr("src", "room/female/dress-10.jpg");
            $("#recomended-3").attr("src", "room/female/dress-16.jpg");

        }
        $('#recomended-1').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-1.png");
            return false;
        });
        $('#recomended-2').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-2.png");
            return false;
        });
        $('#recomended-3').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-3.png");
            return false;
        });

//rotate room

        $('#rotate-model-clockwise, #rotate-model-anticlockwise').on({
            'click': function() {
                var src = ($('#memodel-render').attr('src') === 'room/female/model-layer-1.png')
                    ? 'room/female/rotate-back-1.png'
                    : 'room/female/model-layer-1.png';
                $('#memodel-render').attr('src', src);

            }
        });

    });


    //--Second section
    $("#f_product-2").click(function(){
        imagePath = $("#memodel-render").attr('src',"room/female/model-layer-2.png");
        if(imagePath == "room/female/model-layer-2.png"){
        }else {
            $("#recomended-1").attr("src", "room/female/dress-4.jpg");
            $("#recomended-2").attr("src", "room/female/dress-6.jpg");
            $("#recomended-3").attr("src", "room/female/dress-13.jpg");

        }
        $('#recomended-1').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-2.1.png");
            return false;
        });
        $('#recomended-2').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-2.2.png");
            return false;
        });
        $('#recomended-3').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-2.3.png");
            return false;
        });

        //rotate room



    });

    //--Third section
    $("#f_product-3").click(function(){
        imagePath = $("#memodel-render").attr('src',"room/female/model-layer-3.png");
        if(imagePath == "room/female/model-layer-3.png"){

            $("#recomended-1").attr("style", "display:none");
            $("#recomended-2").attr("style", "display:none");
            $("#recomended-3").attr("style", "display:none");

        }
    });


    //--Fourth section
    $("#f_product-4").click(function(){
        imagePath = $("#memodel-render").attr('src',"room/female/model-layer-4.png");
        if(imagePath == "room/female/model-layer-4.png"){
        }else {
            $("#recomended-1").attr("src", "room/female/dress-2.jpg");
            $("#recomended-2").attr("src", "room/female/dress-9.jpg");
            $("#recomended-3").attr("src", "room/female/dress-10.jpg");

        }
        $('#recomended-1').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-2.1.png");
            return false;
        });
        $('#recomended-2').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-4.1.png");
            return false;
        });
        $('#recomended-3').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-4.2.png");
            return false;
        });
    });

    //--Fifth section
    $("#f_product-5").click(function(){
        imagePath = $("#memodel-render").attr('src',"room/female/model-layer-5.png");
        if(imagePath == "room/female/model-layer-5.png"){

            $("#recomended-1").attr("style", "display:none");
            $("#recomended-2").attr("style", "display:none");
            $("#recomended-3").attr("style", "display:none");

        }
    });

    //--Sixth section
    $("#f_product-6").click(function(){
        imagePath = $("#memodel-render").attr('src',"room/female/model-layer-6.png");
        if(imagePath == "room/female/model-layer-6.png"){
        }else {
            $("#recomended-1").attr("src", "room/female/dress-2.jpg");
            $("#recomended-2").attr("src", "room/female/dress-9.jpg");
            $("#recomended-3").attr("src", "room/female/dress-10.jpg");

        }
        $('#recomended-1').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-2.2.png");
            return false;
        });
        $('#recomended-2').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-6.1.png");
            return false;
        });
        $('#recomended-3').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-6.2.png");
            return false;
        });
    });

    //--Seventh section
    $("#f_product-7").click(function(){
        imagePath = $("#memodel-render").attr('src',"room/female/model-layer-7.png");
        if(imagePath == "room/female/model-layer-7.png"){
        }else {
            $("#recomended-1").attr("src", "room/female/dress-3.jpg");
            $("#recomended-2").attr("src", "room/female/dress-7.jpg");
            $("#recomended-3").attr("src", "room/female/dress-8.jpg");

        }
        $('#recomended-1').click(function(){
            $("#memodel-render").attr('src',"room/female/model-layer-3.png");
            return false;
        });
        $('#recomended-2').click(function(){
            $("#memodel-render").attr('src',"room/female/model-layer-7.png");
            return false;
        });
        $('#recomended-3').click(function(){
            $("#memodel-render").attr('src',"room/female/model-layer-8.png");
            return false;
        });
    });

    //--Eight section
    $("#f_product-8").click(function(){
        imagePath = $("#memodel-render").attr('src',"room/female/model-layer-8.png");
        if(imagePath == "room/female/model-layer-8.png"){
        }else {
            $("#recomended-1").attr("src", "room/female/dress-3.jpg");
            $("#recomended-2").attr("src", "room/female/dress-7.jpg");
            $("#recomended-3").attr("src", "room/female/dress-8.jpg");

        }
        $('#recomended-1').click(function(){
            $("#memodel-render").attr('src',"room/female/model-layer-3.png");
            return false;
        });
        $('#recomended-2').click(function(){
            $("#memodel-render").attr('src',"room/female/model-layer-7.png");
            return false;
        });
        $('#recomended-3').click(function(){
            $("#memodel-render").attr('src',"room/female/model-layer-8.png");
            return false;
        });
    });

    //--Ninth section
    $("#f_product-9").click(function(){
        imagePath = $("#memodel-render").attr('src',"room/female/model-layer-9.png");
        if(imagePath == "room/female/model-layer-9.png"){
        }else {
            $("#recomended-1").attr("src", "room/female/dress-4.jpg");
            $("#recomended-2").attr("src", "room/female/dress-6.jpg");
            $("#recomended-3").attr("src", "room/female/dress-11.jpg");

        }
        $('#recomended-1').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-4.1.png");
            return false;
        });
        $('#recomended-2').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-6.2.png");
            return false;
        });
        $('#recomended-3').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-9.1.png");
            return false;
        });
    });

    //--Eleventh section
    $("#f_product-11").click(function(){
        imagePath = $("#memodel-render").attr('src',"room/female/model-layer-11.png");
        if(imagePath == "room/female/model-layer-11.png"){
        }else {
            $("#recomended-1").attr("src", "room/female/dress-4.jpg");
            $("#recomended-2").attr("src", "room/female/dress-6.jpg");
            $("#recomended-3").attr("src", "room/female/dress-11.jpg");

        }
        $('#recomended-1').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-4.1.png");
            return false;
        });
        $('#recomended-2').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-6.2.png");
            return false;
        });
        $('#recomended-3').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-9.1.png");
            return false;
        });
    });

    //--Twelth section
    $("#f_product-12").click(function(){
        imagePath = $("#memodel-render").attr('src',"room/female/model-layer-12.png");
        if(imagePath == "room/female/model-layer-12.png"){
        }else {
            $("#recomended-1").attr("src", "room/female/dress-3.jpg");
            $("#recomended-2").attr("src", "room/female/dress-7.jpg");
            $("#recomended-3").attr("src", "room/female/dress-12.jpg");

        }
        $('#recomended-1').click(function(){
            $("#memodel-render").attr('src',"room/female/model-layer-3.png");
            return false;
        });
        $('#recomended-2').click(function(){
            $("#memodel-render").attr('src',"room/female/model-layer-7.png");
            return false;
        });
        $('#recomended-3').click(function(){
            $("#memodel-render").attr('src',"room/female/model-layer-12.png");
            return false;
        });
    });

    //--Thirteen section
    $("#f_product-13").click(function(){
        imagePath = $("#memodel-render").attr('src',"room/female/model-layer-13.png");
        if(imagePath == "room/female/model-layer-13.png"){
        }else {
            $("#recomended-1").attr("src", "room/female/dress-2.jpg");
            $("#recomended-2").attr("src", "room/female/dress-6.jpg");
            $("#recomended-3").attr("src", "room/female/dress-9.jpg");

        }
        $('#recomended-1').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-2.3.png");
            return false;
        });
        $('#recomended-2').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-6.2.png");
            return false;
        });
        $('#recomended-3').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-12.1.png");
            return false;
        });
    });

    //--Fourteen section
    $("#f_product-14").click(function(){
        imagePath = $("#memodel-render").attr('src',"room/female/model-layer-14.png");
        if(imagePath == "room/female/model-layer-14.png"){
        }else {
            $("#recomended-1").attr("src", "room/female/dress-3.jpg");
            $("#recomended-2").attr("src", "room/female/dress-7.jpg");
            $("#recomended-3").attr("src", "room/female/dress-12.jpg");

        }
        $('#recomended-1').click(function(){
            $("#memodel-render").attr('src',"room/female/model-layer-3.png");
            return false;
        });
        $('#recomended-2').click(function(){
            $("#memodel-render").attr('src',"room/female/model-layer-12.png");
            return false;
        });
        $('#recomended-3').click(function(){
            $("#memodel-render").attr('src',"room/female/model-layer-14.png");
            return false;
        });
    });

    //--Fifteen section
    $("#f_product-15").click(function(){
        imagePath = $("#memodel-render").attr('src',"room/female/model-layer-15.png");
        if(imagePath == "room/female/model-layer-15.png"){
        }else {
            $("#recomended-1").attr("src", "room/female/dress-5.jpg");
            $("#recomended-2").attr("src", "room/female/dress-12.jpg");
            $("#recomended-3").attr("src", "room/female/dress-15.jpg");

        }
        $('#recomended-1').click(function(){
            $("#memodel-render").attr('src',"room/female/model-layer-5.png");
            return false;
        });
        $('#recomended-2').click(function(){
            $("#memodel-render").attr('src',"room/female/model-layer-12.png");
            return false;
        });
        $('#recomended-3').click(function(){
            $("#memodel-render").attr('src',"room/female/model-layer-15.png");
            return false;
        });
    });

    //--Sixteen section
    $("#f_product-16").click(function(){
        imagePath = $("#memodel-render").attr('src',"room/female/model-layer-16.png");
        if(imagePath == "room/female/model-layer-16.png"){
        }else {
            $("#recomended-1").attr("src", "room/female/dress-1.jpg");
            $("#recomended-2").attr("src", "room/female/dress-13.jpg");
            $("#recomended-3").attr("src", "room/female/dress-15.jpg");

        }
        $('#recomended-1').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-3.png");
            return false;
        });
        $('#recomended-2').click(function(){
            $("#memodel-render").attr('src',"room/female/rec-16.1.png");
            return false;
        });
        $('#recomended-3').click(function(){
            $("#memodel-render").attr('src',"room/female/model-layer-15.png");
            return false;
        });
    });

    //Male Modeling Code

    //--First section
    $("#m_product-1").click(function(){
        imagePath = $("#memodel-render").attr('src',"room/male/model-male-1.png");
        if(imagePath == "room/male/model-male-1.png"){
        }else {
            $("#recomended-1").attr("src", "room/male/shirt-1.jpg");
            $("#recomended-2").attr("src", "room/male/shirt-2.jpg");
            $("#recomended-3").attr("src", "room/male/jeans-1.jpg");

        }
        $('#recomended-1').click(function(){
            $("#memodel-render").attr('src',"room/male/model-male-1.png");
            return false;
        });
        $('#recomended-2').click(function(){
            $("#memodel-render").attr('src',"room/male/model-male-2.png");
            return false;
        });
        $('#recomended-3').click(function(){
            $("#memodel-render").attr('src',"room/male/model-male-4.png");
            return false;
        });
    });
    //rotate room

    $('#rotate-model-clockwise, #rotate-model-anticlockwise').on({
        'click': function() {
            var src = ($('#memodel-render').attr('src') === 'room/male/model-male-1.1.png')
                ? 'room/male/model-male-1.png'
                : 'room/male/model-male-1.1.png';
            $('#memodel-render').attr('src', src);

        }
    });

    //--2nd section
    $("#m_product-2").click(function(){
        imagePath = $("#memodel-render").attr('src',"room/male/model-male-2.png");
        if(imagePath == "room/male/model-male-2.png"){
        }else {
            $("#recomended-1").attr("src", "room/male/shirt-2.jpg");
            $("#recomended-2").attr("src", "room/male/shirt-1.jpg");
            $("#recomended-3").attr("src", "room/male/jeans-1.jpg");

        }
        $('#recomended-1').click(function(){
            $("#memodel-render").attr('src',"room/male/model-male-2.png");
            return false;
        });
        $('#recomended-2').click(function(){
            $("#memodel-render").attr('src',"room/male/model-male-1.png");
            return false;
        });
        $('#recomended-3').click(function(){
            $("#memodel-render").attr('src',"room/male/model-male-5.png");
            return false;
        });
    });
    //rotate room

    $('#rotate-model-clockwise, #rotate-model-anticlockwise').on({
        'click': function() {
            var src = ($('#memodel-render').attr('src') === 'room/male/model-male-5.1.png')
                ? 'room/male/model-male-2.png'
                : 'room/male/model-male-5.1.png';
            $('#memodel-render').attr('src', src);

        }
    });

    //--3rd section
    $("#m_product-3").click(function(){
        imagePath = $("#memodel-render").attr('src',"room/male/model-male-3.png");
        if(imagePath == "room/male/model-male-3.png"){
        }else {
            $("#recomended-1").attr("src", "room/male/shirt-1.jpg");
            $("#recomended-2").attr("src", "room/male/shirt-2.jpg");
            $("#recomended-3").attr("src", "room/male/jeans-1.jpg");

        }
        $('#recomended-1').click(function(){
            $("#memodel-render").attr('src',"room/male/model-male-1.png");
            return false;
        });
        $('#recomended-2').click(function(){
            $("#memodel-render").attr('src',"room/male/model-male-2.png");
            return false;
        });
        $('#recomended-3').click(function(){
            $("#memodel-render").attr('src',"room/male/model-male-6.png");
            return false;
        });
    });
    //rotate room

    $('#rotate-model-clockwise, #rotate-model-anticlockwise').on({
        'click': function() {
            var src = ($('#memodel-render').attr('src') === 'room/male/model-male-6.1.png')
                ? 'room/male/model-male-3.png'
                : 'room/male/model-male-6.1.png';
            $('#memodel-render').attr('src', src);

        }
    });

    //--4th section
    $("#m_product-4").click(function(){
        imagePath = $("#memodel-render").attr('src',"room/male/model-male-7.png");
        if(imagePath == "room/male/model-male-7.png"){
        }else {
            $("#recomended-1").attr("src", "room/male/shirt-1.jpg");
            $("#recomended-2").attr("src", "room/male/shirt-2.jpg");
            $("#recomended-3").attr("src", "room/male/shirt-3.jpg");

        }
        $('#recomended-1').click(function(){
            $("#memodel-render").attr('src',"room/male/model-male-4.png");
            return false;
        });
        $('#recomended-2').click(function(){
            $("#memodel-render").attr('src',"room/male/model-male-5.png");
            return false;
        });
        $('#recomended-3').click(function(){
            $("#memodel-render").attr('src',"room/male/model-male-6.png");
            return false;
        });
    });
    //rotate room

    $('#rotate-model-clockwise, #rotate-model-anticlockwise').on({
        'click': function() {
            var src = ($('#memodel-render').attr('src') === 'room/male/model-male-7.1.png')
                ? 'room/male/model-male-7.png'
                : 'room/male/model-male-7.1.png';
            $('#memodel-render').attr('src', src);

        }
    });






});