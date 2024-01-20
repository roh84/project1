/**
 * 
 */

 const id = document.querySelector(".idsearch");
 const pwd = document.querySelector(".pwdsearch");
 const idbtn = document.querySelector(".idbtn");
 const pwdbtn = document.querySelector(".pwdbtn");
 const title = document.querySelector(".idpwdtitle");
 
 idbtn.addEventListener("click", () => {
	id.style.display = "block";
	pwd.style.display = "none";
	idbtn.style.backgroundColor = "#fa5"; 
	pwdbtn.style.backgroundColor = "white"; 
	title.innerHTML="아이디 찾기";
 });
 
 pwdbtn.addEventListener("click", () => {
	 pwd.style.display = "block";
	 id.style.display = "none";
	title.innerHTML="비밀번호 찾기";
	pwdbtn.style.backgroundColor = "#fa5"; 
	idbtn.style.backgroundColor = "white"; 
 })