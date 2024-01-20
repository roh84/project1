//@ts-nocheck
async function ajax4(url: string, option?: any) {
  console.log("ajax 로딩 중~~~~~");
  return fetch(url, option).then((res) => res.json());
}

window.onload = submitSearch4();

// 검색 폼 제출 시 호출되는 함수
function submitSearch4() {
  console.log("전송되었습니다");
  try {
    let formData = new FormData(document.querySelector("#searchform4"));

    ajax4("/api/boardList4", {
      method: "POST",
      cache: "no-cache",
      body: new URLSearchParams(formData).toString(),
      headers: { "Content-Type": "application/x-www-form-urlencoded" },
    }).then((json) => {
      console.log(json);

      let boards4: HTMLElement | null = document.querySelector("#boards4");
      let template: HTMLTemplateElement | null =
        document.querySelector("#boards4 template");

      let pagesContainer4: HTMLElement | null =
        document.querySelector("#pages4");
      let pageTemplate: HTMLTemplateElement | null =
        document.querySelector("#pages4 template");

      // 기존의 게시글 목록을 지우고 새로운 검색 결과를 표시
      if (template) {
        boards4.innerHTML = "";

        if (json.data.length === 0) {
          alert("일치하는 결과가 없습니다. 리스트로 돌아갑니다.");
          location.reload(); // 페이지를 강제로 다시 로드
          return;
        }

        for (let data of json.data) {
          template.content.querySelector(".boardListNum4").innerHTML =
            data.boardListNum4;
          template.content
            .querySelector(".boardListNum4")
            ?.setAttribute(
              "href",
              `/app/postview4.jsp?id=${data.boardListNum4}`
            );
          template.content.querySelector(".title4").innerHTML = data.title4;
          template.content
            .querySelector(".title4")
            ?.setAttribute(
              "href",
              `/app/postview4.jsp?id=${data.boardListNum4}`
            );
          template.content.querySelector(".mainContents4").innerHTML =
            data.mainContents4;
          template.content.querySelector(".userNickname4").innerHTML =
            data.userNickname4;
          template.content.querySelector(".hitCount4").innerHTML =
            data.hitCount4;
          template.content.querySelector(".regDate4").innerHTML = data.regDate4;

          let a: HTMLElement | null = document.createElement("div");

          a.innerHTML = template.innerHTML;
          if (boards4) {
            boards4.appendChild(template);
            boards4.appendChild(a);
          }
        }
      }

      if (pageTemplate && pagesContainer4) {
        pagesContainer4.innerHTML = "";

        for (let i = 1; i <= json.totalPages4; i += 1) {
          let span = document.createElement("span");
          span.innerText = i;
          span.onclick = function () {
            pageChange4(i);
          };
          pagesContainer4.appendChild(pageTemplate);
          pagesContainer4.appendChild(span);
        }
      }
    });
  } catch (error) {
    console.error("Fetch 오류:", error);
  }
}

// 페이지 링크 동기화 안되었음 일단 클릭하면 이동은 가능함
function pageChange4(page4) {
  document.querySelector("#searchform4 #page4").value = page4;
  submitSearch4();
}
