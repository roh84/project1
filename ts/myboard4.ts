
//@ts-nocheck
async function ajax4(url: string, option?: any) {
    console.log("ajax 로딩 중~~~~~");
    return fetch(url, option).then((res) => res.json());
  }
  
  window.onload = submitSearch4();

  
  // 검색 폼 제출 시 호출되는 함수
  function submitSearch4() {
    console.log("전송되었습니다");
    let form: HTMLFormElement | null = document.getElementById("searchform4");
  
    if (form) {
        let formData = new FormData(form);
  
        ajax4("/api/boardList4", {
            method: "POST",
            body: formData,
        }).then((json) => {
            console.log(json);
  
            let boards4: HTMLElement | null = document.querySelector("#boards4");
            let template: HTMLTemplateElement | null = document.querySelector("#boards4 template");

            // 기존의 게시글 목록을 지우고 새로운 검색 결과를 표시
            if (template) {
                boards4.innerHTML = "";

                for (let data of json.data) {
                    template.content.querySelector(".boardListNum4").innerHTML = data.boardListNum4;
                    template.content.querySelector(".boardListNum4")?.setAttribute("href", `/app/postview4.jsp?id=${data.boardListNum4}`);
                    template.content.querySelector(".title4").innerHTML = data.title4;
                    template.content.querySelector(".title4")?.setAttribute("href", `/app/postview4.jsp?id=${data.boardListNum4}`);
                    template.content.querySelector(".mainContents4").innerHTML = data.mainContents4;
                    template.content.querySelector(".userNickname4").innerHTML = data.userNickname4;
                    template.content.querySelector(".hitCount4").innerHTML = data.hitCount4;
                    template.content.querySelector(".regDate4").innerHTML = data.regDate4;
  
  
                    let a: HTMLElement | null = document.createElement("div");
  
                    a.innerHTML = template.innerHTML;
                    if (boards4) {
                        boards4.appendChild(template);
                        boards4.appendChild(a);
                    }
                }
            }
 
        });
    }
  }
  

  
  