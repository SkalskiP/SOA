$(document).ready(function(){
    $("#submit-button").on("click", function(e){
        var parametersCount = $("#parameters-count").val();
        console.log(parametersCount);
        var form = $("#numbers-form");
        for (var i = 0; i < parametersCount; i++) {
            var label = "<h5>" + "number: " + i + "</h5>";
            var input = "<input type='text' name='numbers'><br>";
            var labelElement = $(label);
            var inputElement = $(input);
            form.append(labelElement);
            form.append(inputElement);
        }
        form.append($("<input type='submit'>"))
    })
});