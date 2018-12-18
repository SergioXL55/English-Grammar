function translateWord(id) {
       if(document.getElementById(id).title.length===0) {
           var text=document.getElementById(id).outerText;
           $.ajax({
               type: "POST",
               url: "${pageContext.servletContext.contextPath}/trans?text="+text,
               success: function (data) {
                   document.getElementById(id).title = data.toString();
               }
           });
       }
    }