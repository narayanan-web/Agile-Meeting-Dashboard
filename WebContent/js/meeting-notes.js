$(document).ready(function(){
	$('#multi-select')
        .dropdown();
    $("#Createmeeting").click(function () {
		var title=$("#title").val();
        var description=$('#description').val();
        var link=$('#link').val();
        var date=$('#date').val();
        var starttime=$('#starttime').val();
        var endtime=$('#endtime').val();
		var peoples = '';
		$.each($("#multi-select option:selected"), function(){            
            peoples += $('#multi-select').val()+',';
		});
		//alert(peoples);
		$.ajax({
			url : 'MeetingandMail',
			type: 'post',
			data : {title:title,description:description,link:link,date:date,starttime:starttime,endtime:endtime,peoples:peoples},
			dataType:"json",
			});
        alert("Meeting Created Successfully");
        alert("Notification email also sent successfully");
		});
});