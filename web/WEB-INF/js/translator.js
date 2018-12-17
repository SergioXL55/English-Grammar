function translateWord(id) {
        $.ajax({
            type: "POST",
            url: "${pageContext.servletContext.contextPath}/trans",
            success: function (data) {
                document.getElementById(id).title = data.toString();
            }
        });
    }
