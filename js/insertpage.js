/**
 * 
 */
 document.addEventListener("DOMContentLoaded", function() {
            moveurl('insert.jsp');
        });
        
 function moveurl(url) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("options").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", url, true);
    xhttp.send();
};

function delOk(){
	if(confirm("취소하시겠습니까?")){
		alert("취소되었습니다.");
    	location.href="insertpage.jsp" 
    	
	}else{
		alert("취소 실패");
	}
}