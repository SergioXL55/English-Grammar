const answerCode = {
    OK: 1,
    NO: -1,
    FINISH: 0
};

function clickMe(row, i) {
    $.ajax({
        type: "post",
        url: "${pageContext.servletContext.contextPath}/check?id=" + row + "&num=" + i,
        success: function (answer) {
            $("#results").html(answer);
            var answer=document.getElementById("answer").value;
            if (answer == answerCode.OK) {
                addWordToSentece(row,i);
            }
            if (answer == answerCode.FINISH) {
                addWordToSentece(row,i);
                document.getElementById("row" + row).style.backgroundColor='#caffd6';
            }
        }

    });
}

function addWordToSentece(row,i){
    document.getElementById("row" + row).value += document.getElementById("link" + row + "word" + i).outerText + ' ';
    document.getElementById("link" + row + "word" + i).style.backgroundColor="#646464";
}

