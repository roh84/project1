function ChartGraph(query, options){
	let target = document.querySelector("canvas" + query);
	target.innerHTML = "";
	info = {}
	info.type = options.type || "bar";
	info.title = options.title || "제목";
	info.label = options.label || "라벨";
	info.datas = options.datas || [10,20,30,40,50];
	info.labels = options.labels || ["1","2","3","4","5"];
	info.labels = info.labels.slice(0, info.datas.length);
	info.animation = {}
	info.animation.duration = options.animation && (options.animation.duration || 0); 
	switch(info.type){
		case "line":
			info.backColor = options.backColor || ["rgb(127, 199, 217, 0.5)"];
			break;
		case "bar":
			info.backColor = options.backColor || ["blue"];
			info.backColor = info.backColor.slice(0, info.datas.length);
			break;
	}
	new Chart(target, {
	    type: info.type,
	    data: {
	      labels: info.labels,
	      datasets: [
	        {
	          label: info.label,
			  borderColor: info.backColor,
	          backgroundColor: info.backColor,
	          data: info.datas
	        }
	      ]
	    },
	    options: {
		  animation:{
			  duration:info.animation.duration
		  },
	      //responsive: false, 내가 마음대로 크기 번경 하고 싶을때
	      maintainAspectRatio: false,// 부모테그에 붙어서 나온다
	      legend: { display: false },
	      title: {
	        display: true,
	        text: info.title
	      },
	      //y축
	      scales: {
	        yAxes: [{
	            ticks : {
					beginAtZero : true, // 0부터 시작
				 //	stepSize: 1   // 1 씩 증가
				}
	        }]
	    }
	    //y축
	    }
	});	
}


//////////////////////////////////////////////////////////////////////////////////그래프존

 function filterDay(users,  daysAgo = 0) {
	let currentDate = new Date();
	let targetDate = new Date(currentDate);

	targetDate.setDate(targetDate.getDate() - daysAgo);
  
	return users.filter((data) => {
	  let newUserJoinDay = new Date(data.userJoinDay);
  
	  return (	
		newUserJoinDay.getDate() === targetDate.getDate()
	  );
	});
  }
  function filtermonth(users, yearsAgo = 0) {
	let currentDate = new Date();
	let targetDate = new Date(currentDate);
	targetDate.setFullYear(targetDate.getFullYear() - yearsAgo);
	return users.filter((data) => {
	  let newUserJoinDay = new Date(data.userJoinDay);
  
	  return (
		newUserJoinDay.getFullYear() === targetDate.getFullYear()
	  );
	});
  }

  function filteryear(users,yearsAgo = 0) {
	let currentDate = new Date();
	let targetDate = new Date(currentDate);
	targetDate.setFullYear(targetDate.getFullYear() - yearsAgo);
	return users.filter((data) => {
	  let newUserJoinDay = new Date(data.userJoinDay);
  
	  return (
		newUserJoinDay.getFullYear() === targetDate.getFullYear()
	  );
	});
  }









  function getRecentDates(startDate, count, interval) {
	let recentDates = [];
	let currentDate = new Date(startDate);
  
	for (let i = 0; i < count; i++) {
	  recentDates.push(currentDate.toISOString().split('T')[0]); // 날짜만 추출
	  currentDate.setUTCDate(currentDate.getUTCDate() - interval);
	}
  
	return recentDates;
  }
  
  let today = new Date(); // 현재 날짜
  let recentDays = getRecentDates(today, 5, 1).reverse(); // 가장 최근일자로부터 5일
  let recentMonths = getRecentDates(today, 5, 30).reverse(); // 가장 최근달로부터 5달
  recentMonths = recentMonths.map(date => {
	return date.substring(0, 7);
  });
  let recentYears = getRecentDates(today, 5, 365).reverse(); // 가장 최근년도로부터 5년
  recentYears = recentYears.map(date => {
	return date.substring(0, 4);
  });


  let dateRanges = [4, 3, 2, 1, 0];
  let dateCounts = dateRanges.map((daysAgo) =>
	filterDay(users,daysAgo).length
  );

  let monthRanges = [4, 3, 2, 1, 0];
  let monthCounts = monthRanges.map((daysAgo) =>
	filtermonth(users, daysAgo).length
  );
  

  let yearRanges = [4, 3, 2, 1, 0];
  let yearCounts = yearRanges.map((daysAgo) =>
	filteryear(users,daysAgo).length
  );
 


  let btdate = document.querySelector("#btdate");
  btdate.addEventListener("click",()=>{
	document.querySelector("#bar-chart").innerHTML='';
	ChartGraph("#bar-chart", {datas:dateCounts,labels:recentDays,title:"일별",type:"line"});
 });
 let btmonth = document.querySelector("#btmonth");
 btmonth.addEventListener("click",()=>{
	document.querySelector("#bar-chart").innerHTML='';
	ChartGraph("#bar-chart", {datas:monthCounts,labels:recentMonths,title:"월별",type:"line", backColor:"rgb(158, 184, 217, 0.5)"});
 });
 let btyear = document.querySelector("#btyear");
 btyear.addEventListener("click",()=>{
	document.querySelector("#bar-chart").innerHTML='';
	ChartGraph("#bar-chart", {datas:yearCounts,labels:recentYears,title:"년별",type:"line", backColor:"rgb(41, 75, 41, 0.3)"});
 });


//로드하면 일다 이거 보여주고
  ChartGraph("#bar-chart", {datas:dateCounts,labels:recentDays,title:"일별",type:"line"});





  ///////////////////////////////////////////////
   // 버튼 클릭 이벤트 처리
   function deleteButtonClickHandler(button) {
    // 현재 클릭된 버튼의 value 값 가져오기
    let buttonValue = button.value;
	console.log(buttonValue);

    // AJAX를 사용하여 삭제 
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:4885/DeletUser/", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    
    xhr.send("buttonValue=" + encodeURIComponent(buttonValue));
	button.parentNode.parentNode.remove();
}