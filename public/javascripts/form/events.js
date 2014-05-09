$(document).ready(function () {
    $("form").live("submit", function(e) {
        $("#loader-a").attr("style","display:inline;");
        e.preventDefault();
        var _data = $(e.currentTarget).serialize();
        var _uri = $(e.currentTarget).data().uri;
        $.ajax({
            type: e.currentTarget.method,
            url: e.currentTarget.action,
            data: _data,
            success: function(data) {
                $(e.currentTarget).find("div.message p").html(data.message);
                $("#loader-a").attr("style","display:none;");
                $(e.currentTarget).find("div.message").show();
                setTimeout(function () {
                    $(e.currentTarget).find("div.message").hide();
                    window.location = _uri;
                }, 3000);
                $(e.currentTarget).get(0).reset();
            },
            error: function(xhr, textStatus, errorThrown) {
                var em = jQuery.parseJSON(xhr.responseText)
                $(e.currentTarget).find("div.message p").html(em.message);
                $("#loader-a").attr("style","display:none;");
                $(e.currentTarget).find("div.message").show();
                setTimeout(function () {
                    $(e.currentTarget).find("div.message").hide();
                }, 5000);
                $(e.currentTarget).get(0).reset();
            }
        });
        return false;
    });
});