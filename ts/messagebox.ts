//@ts-nocheck

async function messgeajax(url: string, option?: any) {
    return fetch(url, option).then((res) => res.json());
   
  } 


async function messgedelet(notenum: String, endpoint: String) {
  let Sendform: FormData = document.querySelector(`#${endpoint}form${notenum}`);
  console.log(Sendform);
  let formData = new FormData(Sendform);
  let jsonData = {
    seenum: formData.get("seenum"),
    notenum: formData.get("notenum"),
    // 다른 필드들 추가
  };
  await messgeajax(`/Deletmessage/${endpoint}`, {  
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(jsonData),
  });
}


async function messgedeletAll(endpoint: String) {
  let Sendform: FormData = document.querySelector(`#${endpoint}form`);
  let formData = new FormData(Sendform);
  let jsonData = {
    seenums: formData.get("seenums"),
    notenums: formData.get("notenums"),
    // 다른 필드들 추가
  };
  await messgeajax(`/Deletmessage/${endpoint}`, {  
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(jsonData),
  });
}


async function sendDelet(notenum:String){

  let summaryElement = document.querySelector(`#sendsum${notenum}`);
    summaryElement.parentNode.style.display = 'none';
    await messgedelet(notenum,"send");
}

async function recieveDelet(notenum:String){
 
  let summaryElement = document.querySelector(`#receivesum${notenum}`);
    summaryElement.parentNode.style.display = 'none';
    await messgedelet(notenum,"recieve");
}


async function sendDeletAll(notenumString:String){ 
  let notenumArray = JSON.parse(notenumString);

  // 배열의 각 원소에 대해 반복
  for (let i = 0; i < notenumArray.length; i++) {
      let currentNotenum = notenumArray[i];

      // 작업 수행
      let summaryElement = document.querySelector(`#sendsum${currentNotenum}`);
      if (summaryElement) {
          summaryElement.parentNode.style.display = 'none';      
      }
  }
    await messgedeletAll("sendAll");
}

async function recieveDeletAll(notenumString:String){ 

  let notenumArray = JSON.parse(notenumString);
  for (let i = 0; i < notenumArray.length; i++) {
      let currentNotenum = notenumArray[i];
      let summaryElement = document.querySelector(`#receivesum${currentNotenum}`);
      if (summaryElement) {
          summaryElement.parentNode.style.display = 'none';      
      }
  }
    await messgedeletAll("receiveAll");
}

async function writemessage(){
   Nicknamecheck();

}

////////////////////////////////////////


let intervalId;

function startInterval() {
    intervalId = setInterval(function() {
       location.reload();
    }, 10000); // 10초마다 실행
}


function stopInterval() {
  clearInterval(intervalId); // 현재 타이머를 중지
}

// 마우스가 특정 화면 위에 있을 때
document.getElementById("modal").addEventListener('mouseover', function() {
    stopInterval();
    startInterval();   
});

// 마우스가 특정 화면 위에서 벗어날 때
document.getElementById("modal").addEventListener('mouseout', function() {
  stopInterval();
  startInterval();
});

// 채팅 입력 중일 때 
document.getElementById("modal").addEventListener('input', function() {
  stopInterval();
 startInterval();
});

// 채팅 입력이 끝났을 때 
document.getElementById("modal").addEventListener('blur', function() {
    stopInterval();
    startInterval();  
});

// 초기에 setInterval 시작
startInterval();

////////////////////////////////////////////////////////////////////////////////
let form: FormData = new FormData();
async function loginajax(url: string, option?: any) {
    return fetch(url, option).then((res) => res.json());
  } 

async function Nicknamecheck(){
  loginajax("/api/select/checkapi.jsp",{
  method: "POST",
  body: form,
}).then((json) => {   
  let userNicknames = json.userNicknames.map(datas => datas.userNickname); 
  let inputForUserNickname = document.querySelector(".note-receiver").value;
  let checkNmae = userNicknames.find(lang=>lang === inputForUserNickname);    
     if(checkNmae == undefined){
     return  Swal.fire({
         title: '',
         text: inputForUserNickname+"님은 존재하지 않습니다",
         icon: 'warning',
     });
     }else{
      let writeform: FormData = document.querySelector(`#writemessage`);
      let writeformData = new FormData(writeform);
      let writejsonData = {
        sender: writeformData.get("sender"),
        receiver: writeformData.get("receiver"),
        content: writeformData.get("content")
      };
       messgeajax("/MessageServlet",{  
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(writejsonData),
      });   
      setTimeout(() => {
        location.reload();
      }, 200);
     }
});
}

// let writeform: FormData = document.querySelector(`#writemessage`);
// let writeformData = new FormData(writeform);
// let writejsonData = {
//   sender: writeformData.get("sender"),
//   receiver: writeformData.get("receiver"),
//   content: writeformData.get("content")
// };
//  messgeajax("/MessageServlet",{  
//   method: "POST",
//   headers: {
//     "Content-Type": "application/json"
//   },
//   body: JSON.stringify(writejsonData),
// });

// setTimeout(() => {
//   location.reload();
// }, 200);








