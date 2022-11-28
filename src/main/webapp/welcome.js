
    let commentsSection = document.querySelector(".comment-section")
    let commentBtn = document.querySelector("#commentBtn")
    let hideComment = document.querySelector(".hideComment");

    $(document).ready(function(){
        $(commentsSection).toggle();
        let showComment = function () {
            $(hideComment).toggle();
            $(hideComment).toggleClass("component");
            $(commentsSection).toggle();
        }
    });



