//@ts-nocheck
interface Reply {
  userNickname3: string;
  replyContents3: string;
  regDate3: string;
  replyNum3: number;
}

document.addEventListener("DOMContentLoaded", () => {
  loadReply3();

  let addReplyBtn3 = document.getElementById(
    "addReplyBtn3"
  ) as HTMLButtonElement;
  if (addReplyBtn3) {
    addReplyBtn3.addEventListener("click", addReply3);
  }

  document.addEventListener("click", (event) => {
    if (event.target && event.target.className == "deleteReply3") {
      let replyNum3 = parseInt(
        (event.target as HTMLElement).getAttribute("data-replynum") || "",
        10
      );
      // console.log(replyNum);
      if (!isNaN(replyNum3)) {
        deleteReply3(replyNum3);
      }
    }
  });
});

async function loadReply3() {
  try {
    let boardListNumInput3 = document.getElementById(
      "boardListNumInput3"
    ) as HTMLInputElement;
    let boardListNum3 = boardListNumInput3.value;

    let formData = new FormData();
    formData.append("boardListNum3", boardListNum3);

    let response = await fetch(
      `/api/replylist3?${new URLSearchParams(formData)}`,
      {
        method: "GET",
        headers: {
          "Cache-Control": "no-cache",
        },
      }
    );

    if (!response.ok) {
      throw new Error("댓글 불러오기 실패");
    }

    let replyList3: { replyList3: Reply[] } = await response.json();
    displayReply3(replyList3);
  } catch (error) {
    console.error(error);
  }
}



// 댓글작성자
let currentUser3: String = sessionUser; // 실제 기본값으로 설정하세요

function displayReply3(replies3: { replyList3: Reply[] }) {
  let replyContainer3 = document.querySelector("#replyContainer3");
  let template: HTMLTemplateElement | null = document.querySelector(
    "#replyContainer3 template"
  );
  if (template && replyContainer3) {
    replyContainer3.innerHTML = "";

    for (let data of replies3.replyList3) {
      let clone = document.importNode(template.content, true);

      clone.querySelector(".userNickname3").innerHTML = data.userNickname3;
      clone.querySelector(".replyContents3").innerHTML = data.replyContents3;
      clone.querySelector(".regDate3").innerHTML = data.regDate3;
      if (currentUser3 === data.userNickname3) {
        // 맞다면 삭제 버튼을 활성화
        clone
          .querySelector(".deleteReply3")
          .setAttribute("data-replynum", data.replyNum3.toString());
      }else{
        clone.querySelector(".deleteReply3").style.display = "none";
      }
      console.log(currentUser3, data.userNickname3);

      replyContainer3.appendChild(clone);
    }
  }
}

async function addReply3() {
  try {
    let formData = new FormData(document.querySelector("#replyForm3"));
    let response = await fetch("/api/addReply3", {
      method: "POST",
      cache: "no-cache",
      body: new URLSearchParams(formData).toString(),
      headers: { "Content-Type": "application/x-www-form-urlencoded" },
    });

    if (!response.ok) {
      throw new Error("댓글 등록 실패");
    }

    let replyList3: { success: boolean } = await response.json();

    if (replyList3.success) {
      clearReplyInput3();
      loadReply3();
      location.href = "/app/postview3.jsp?id=" + formData.get("boardListNum3");
    }
  } catch (error) {
    console.error("Fetch 오류:", error);
  }
}

function clearReplyInput3() {
  let replyContentsInput3 = document.getElementById(
    "replyContents3"
  ) as HTMLTextAreaElement;
  if (replyContentsInput3) {
    replyContentsInput3.value = "";
  }
}

async function deleteReply3(replyNum3: number) {
  try {
    console.log(replyNum3);
    let response3 = await fetch(`/api/deleteReply3?replyNum3=${replyNum3}`, {
      method: "POST",
    });

    if (!response3.ok) {
      throw new Error("댓글 삭제 실패");
    }

    let replyList3: { success: boolean } = await response3.json();

    if (replyList3.success) {
      console.log("댓글 삭제 성공");
      loadReply3();
      location.href =
        "/app/postview3.jsp?id=" +
        document.getElementById("boardListNumInput3").value;
    } else {
      console.error("댓글 삭제 실패:", replyList3.success);
    }
  } catch (error) {
    console.error("댓글 삭제 중 오류 발생:", error);
    alert("댓글 삭제 중 오류 발생");
  }
}

