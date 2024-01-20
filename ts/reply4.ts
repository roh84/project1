//@ts-nocheck
interface Reply {
  userNickname4: string;
  replyContents4: string;
  regDate4: string;
  replyNum4: number;
}

document.addEventListener("DOMContentLoaded", () => {
  loadReply4();

  let addReplyBtn4 = document.getElementById(
    "addReplyBtn4"
  ) as HTMLButtonElement;
  if (addReplyBtn4) {
    addReplyBtn4.addEventListener("click", addReply4);
  }

  document.addEventListener("click", (event) => {
    if (event.target && event.target.className == "deleteReply4") {
      let replyNum4 = parseInt(
        (event.target as HTMLElement).getAttribute("data-replynum") || "",
        10
      );
      // console.log(replyNum);
      if (!isNaN(replyNum4)) {    
        deleteReply4(replyNum4);
      }
    }
  });
});

async function loadReply4() {
  try {
    let boardListNumInput4 = document.getElementById(
      "boardListNumInput4"
    ) as HTMLInputElement;
    let boardListNum4 = boardListNumInput4.value;

    let formData = new FormData();
    formData.append("boardListNum4", boardListNum4);

    let response = await fetch(
      `/api/replylist4?${new URLSearchParams(formData)}`,
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

    let replyList4: { replyList4: Reply[] } = await response.json();
    displayReply4(replyList4);
  } catch (error) {
    console.error(error);
  }
}

// 댓글작성자
let currentUser4: String = sessionUser; // 실제 기본값으로 설정하세요

function displayReply4(replies4: { replyList4: Reply[] }) {
  let replyContainer4 = document.querySelector("#replyContainer4");
  let template: HTMLTemplateElement | null = document.querySelector(
    "#replyContainer4 template"
  );
  if (template && replyContainer4) {
    replyContainer4.innerHTML = "";

    for (let data of replies4.replyList4) {
      let clone = document.importNode(template.content, true);

      clone.querySelector(".userNickname4").innerHTML = data.userNickname4;
      clone.querySelector(".replyContents4").innerHTML = data.replyContents4;
      clone.querySelector(".regDate4").innerHTML = data.regDate4;
      if (currentUser4 === data.userNickname4) {
        // 맞다면 삭제 버튼을 활성화
        clone
          .querySelector(".deleteReply4")
          .setAttribute("data-replynum", data.replyNum4.toString());
      }else{
        clone.querySelector(".deleteReply4").style.display = "none";
      }
      console.log(currentUser4, data.userNickname4);

      replyContainer4.appendChild(clone);
    }
  }
}

async function addReply4() {
  try {
    let formData = new FormData(document.querySelector("#replyForm4"));
    let response = await fetch("/api/addReply4", {
      method: "POST",
      cache: "no-cache",
      body: new URLSearchParams(formData).toString(),
      headers: { "Content-Type": "application/x-www-form-urlencoded" },
    });

    if (!response.ok) {
      throw new Error("댓글 등록 실패");
    }

    let replyList4: { success: boolean } = await response.json();

    if (replyList4.success) {
      clearReplyInput4();
      loadReply4();
      location.href = "/app/postview4.jsp?id=" + formData.get("boardListNum4");
    }
  } catch (error) {
    console.error("Fetch 오류:", error);
  }
}

function clearReplyInput4() {
  let replyContentsInput4 = document.getElementById(
    "replyContents4"
  ) as HTMLTextAreaElement;
  if (replyContentsInput4) {
    replyContentsInput4.value = "";
  }
}

async function deleteReply4(replyNum4: number) {
  try {
    console.log(replyNum4);
    let response4 = await fetch(`/api/deleteReply4?replyNum4=${replyNum4}`, {
      method: "POST",
    });

    if (!response4.ok) {
      throw new Error("댓글 삭제 실패");
    }

    let replyList4: { success: boolean } = await response4.json();

    if (replyList4.success) {
      console.log("댓글 삭제 성공");
      loadReply4();
      location.href =
        "/app/postview4.jsp?id=" +
        document.getElementById("boardListNumInput4").value;
    } else {
      console.error("댓글 삭제 실패:", replyList4.success);
    }
  } catch (error) {
    console.error("댓글 삭제 중 오류 발생:", error);
    alert("댓글 삭제 중 오류 발생");
  }
}
