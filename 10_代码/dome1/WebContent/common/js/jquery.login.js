$(function() {
  $(".ReloadCode").click(function() {
	 var checkcode = $("#numpic").get(0);
	 var dt = new Date();
	 checkcode.src = "randNum.action?t=" + dt;
  });
  $("#loginForm").submit(function(){
	  var userid = $("#userid").val();
	  var passwd = $("#passwd").val();
	  $.post("./login.action", {
		  userid: userid,
		  passwd: passwd
		  },function(data){
			  if(data == "input"){
				  $("#pageLinks").css("visibility", "visible");
//				  $("#userid").attr({ value: ""});
//				  $("#passwd").attr({ value: ""});
//				  $("#inputimg").attr({ value: ""});
			  } else {
				  window.location.replace("init.action");
			  }
			  });
		return false;
	});
  $("#inputimg").click(function() {
	  var userid = $("#userid").val();
	  var passwd = $("#passwd").val();
	  if(userid != "" && passwd != ""){
		  $("#pageLinks").css("visibility", "hidden");
	  }
  });
});