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
            switch (answer){
                case answerCode.OK:
                    addWordToSentece(row,i);
                    break;
                case answerCode.FINISH:
                    addWordToSentece(row,i);
                    document.getElementById("row" + row).style.backgroundColor='#caffd6';
                    break;
            }
        }
    });
}

function addWordToSentece(row,i){
    document.getElementById("row" + row).value += document.getElementById("link" + row + "word" + i).outerText + ' ';
    document.getElementById("link" + row + "word" + i).style.backgroundColor="#646464";
}

