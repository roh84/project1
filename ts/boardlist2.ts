//@ts-nocheck
async function ajax2(url: string, option?: any) {
  console.log("ajax 로딩 중~~~~~");
  return fetch(url, option).then((res) => res.json());
}

window.onload = submitSearch2();

// 검색 폼 제출 시 호출되는 함수
function submitSearch2() {
  console.log("전송되었습니다");
  try {
    let formData = new FormData(document.querySelector("#searchform2"));

    ajax2("/api/boardList2", {
      method: "POST",
      cache: "no-cache",
      body: new URLSearchParams(formData).toString(),
      headers: { "Content-Type": "application/x-www-form-urlencoded" },
    }).then((json) => {
      console.log(json);

      let boards2: HTMLElement | null = document.querySelector("#boards2");
      let template: HTMLTemplateElement | null =
        document.querySelector("#boards2 template");

      let pagesContainer2: HTMLElement | null =
        document.querySelector("#pages2");
      let pageTemplate: HTMLTemplateElement | null =
        document.querySelector("#pages2 template");

      // 기존의 게시글 목록을 지우고 새로운 검색 결과를 표시
      if (template) {
        boards2.innerHTML = "";

        if (json.data.length === 0) {
          alert("일치하는 결과가 없습니다. 리스트로 돌아갑니다.");
          location.reload(); // 페이지를 강제로 다시 로드
          return;
        }

        for (let data of json.data) {
          template.content.querySelector(".boardListNum2").innerHTML =
            data.boardListNum2;
          template.content
            .querySelector(".boardListNum2")
            ?.setAttribute(
              "href",
              `/app/postview2.jsp?id=${data.boardListNum2}`
            );
          template.content.querySelector(".title2").innerHTML = data.title2;
          template.content
            .querySelector(".title2")
            ?.setAttribute(
              "href",
              `/app/postview2.jsp?id=${data.boardListNum2}`
            );
          template.content.querySelector(".mainContents2").innerHTML =
            data.mainContents2;
          template.content.querySelector(".userNickname2").innerHTML =
            data.userNickname2;
          template.content.querySelector(".hitCount2").innerHTML =
            data.hitCount2;
          template.content.querySelector(".regDate2").innerHTML = data.regDate2;

          let a: HTMLElement | null = document.createElement("div");

          a.innerHTML = template.innerHTML;
          if (boards2) {
            boards2.appendChild(template);
            boards2.appendChild(a);
          }
        }
      }

      if (pageTemplate && pagesContainer2) {
        pagesContainer2.innerHTML = "";

        for (let i = 1; i <= json.totalPages2; i += 1) {
          let span = document.createElement("span");
          span.innerText = i;
          span.onclick = function () {
            pageChange2(i);
          };
          pagesContainer2.appendChild(pageTemplate);
          pagesContainer2.appendChild(span);
        }
      }
    });
  } catch (error) {
    console.error("Fetch 오류:", error);
  }
}

// 페이지 링크 동기화 안되었음 일단 클릭하면 이동은 가능함
function pageChange2(page2) {
  document.querySelector("#searchform2 #page2").value = page2;
  submitSearch2();
}
