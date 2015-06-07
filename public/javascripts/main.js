$(function(){

    var request;
    autosize($('textarea'));
    $('#sortJson').hide(); // auto sort enabled

    $('#fileJson').on('change', function(event){
        event.preventDefault();
        var fileSelected = $(this)[0].files[0];
        var fileReader = new FileReader();
        fileReader.onload = function (event) {
            try{
                request = JSON.parse(event.target.result);
                validJSON(request);
            } catch(error) {
                invalidJSON("file uploaded!");
            }
        };
        fileReader.readAsText(fileSelected);
        return false;
    });

    $('#customerList').on('blur', function(event){
        event.preventDefault();
        try{
            request = JSON.parse($('#customerList').val());
            validJSON(request);
        } catch(error) {
            invalidJSON("data in textarea!");
        }
    });

    function validJSON(json){
        $('#customerList').val(JSON.stringify(json, null, '  '));
        autosize.update($('#customerList'));
        $('#sortJson').trigger('click');
        $(window).scrollTop(0);
    }

    function invalidJSON(message){
        $('#customerListSorted').val('');
        $.bootstrapGrowl("Invalid JSON: "+ message, { type: 'danger' });
    }

    $('#sortJson').on('click', function(event){
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'api/customer/sort/duedate',
            data: JSON.stringify(request),
            success: function(response) {
                $('#customerListSorted').val(JSON.stringify(response, null, '  '));
                autosize.update($('#customerListSorted'));
                $.bootstrapGrowl("Sorted successfully!", { type: 'success' });
            },
            contentType: "application/json",
            dataType: 'json'
        });
    });

});