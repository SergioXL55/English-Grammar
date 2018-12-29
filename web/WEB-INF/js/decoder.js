function encode() {
    if(notEmpty()) {
        $.ajax({
            type: 'post',
            url: '${pageContext.servletContext.contextPath}/encode?text='+document.getElementById("inputText").value,
            success: function (data) {
                $("#outputText").text(data);
            }
        })
    }
}

function decode() {
    if(notEmpty()) {
        $.ajax({
            type: 'post',
            url: '${pageContext.servletContext.contextPath}/decode?text='+document.getElementById("inputText").value,
            success: function (data) {
                $("#outputText").text(data);
            }
        })
    }
}

function notEmpty(){
    if(document.getElementById("inputText").value ==""){
        alert("Empty text");
        return false;
    }
   return true;
}