
//@ts-nocheck
async function ajax3(url: string, option?: any) {
    console.log("ajax 로딩 중~~~~~");
    return fetch(url, option).then((res) => res.json());
  }
  
  window.onload = submitSearch3();
  
  
  // 검색 폼 제출 시 호출되는 함수
  function submitSearch3() {
    console.log("전송되었습니다");
    let form: HTMLFormElement | null = document.getElementById("searchform3");
  
    if (form) {
        let formData = new FormData(form);
  
        ajax3("/api/boardList3", {
            method: "POST",
            body: formData,
        }).then((json) => {
            console.log(json);
  
            let boards3: HTMLElement | null = document.querySelector("#boards3");
            let template: HTMLTemplateElement | null = document.querySelector("#boards3 template");
  
            let pagesContainer3: HTMLElement | null = document.querySelector("#pages3");
            let pageTemplate: HTMLTemplateElement | null = document.querySelector("#pages3 template");
  
  
  
            // 기존의 게시글 목록을 지우고 새로운 검색 결과를 표시
            if (template) {
                boards3.innerHTML = "";
  
                for (let data of json.data) {
                    template.content.querySelector(".boardListNum3").innerHTML = data.boardListNum3;
                    template.content.querySelector(".boardListNum3")?.setAttribute("href", `/app/postview3.jsp?id=${data.boardListNum3}`);
                    template.content.querySelector(".title3").innerHTML = data.title3;
                    template.content.querySelector(".title3")?.setAttribute("href", `/app/postview3.jsp?id=${data.boardListNum3}`);
                    template.content.querySelector(".mainContents3").innerHTML = data.mainContents3;
                    template.content.querySelector(".userNickname3").innerHTML = data.userNickname3;
                    template.content.querySelector(".hitCount3").innerHTML = data.hitCount3;
                    template.content.querySelector(".regDate3").innerHTML = data.regDate3;
   
                    let a: HTMLElement | null = document.createElement("div");
  
                    a.innerHTML = template.innerHTML;
                    if (boards3) {
                        boards3.appendChild(template);
                        boards3.appendChild(a);
                    }
                }
            }
  
        });
    }
  }

  
  
  