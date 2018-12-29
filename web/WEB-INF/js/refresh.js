function ref() {
    var dd;
    $.ajax({
        type: "GET",
        url: "${pageContext.servletContext.contextPath}/word",
        success: function (data) {
            if (data.status == 'OK'){
                alert('Person has been added'+data.copyright);
            }
            else alert('Failed adding person: ' + data.status + ', ' + data.errorMessage);
        }
    });
}