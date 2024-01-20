//@ts-nocheck
interface Reply {
  userNickname: string;
  replyContents: string;
  regDate: string;
  replyNum: number;
}

document.addEventListener("DOMContentLoaded", () => {
  loadReply();

  let addReplyBtn = document.getElementById("addReplyBtn") as HTMLButtonElement;
  if (addReplyBtn) {
    addReplyBtn.addEventListener("click", addReply);
  }

  document.addEventListener("click", (event) => {
    if (event.target && event.target.className == "deleteReply") {
      let replyNum = parseInt(
        (event.target as HTMLElement).getAttribute("data-replynum") || "",
        10
      );
      // console.log(replyNum);
      if (!isNaN(replyNum)) {
        deleteReply(replyNum);
      }
    }
  });
});


async function loadReply () {
  try {
    let boardListNumInput  = document.getElementById(
      "boardListNumInput"
    ) as HTMLInputElement;
    let boardListNum  = boardListNumInput.value;

    let formData = new FormData();
    formData.append("boardListNum", boardListNum );

    let response = await fetch(
      `/api/replylist?${new URLSearchParams(formData)}`,
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

    let replyList: { replyList: Reply[] } = await response.json();
    displayReply(replyList);
  } catch (error) {
    console.error(error);
  }
}


// 댓글작성자
let currentUser: String = sessionUser; // 실제 기본값으로 설정하세요

function displayReply(replies: { replyList: Reply[] }) {
  let replyContainer = document.querySelector("#replyContainer");
  let template: HTMLTemplateElement | null = document.querySelector(
    "#replyContainer template"
  );
  if (template && replyContainer) {
    replyContainer.innerHTML = "";

    for (let data of replies.replyList) {
      let clone = document.importNode(template.content, true);

      clone.querySelector(".userNickname").innerHTML = data.userNickname;
      clone.querySelector(".replyContents").innerHTML = data.replyContents;
      clone.querySelector(".regDate").innerHTML = data.regDate;
      if (currentUser === data.userNickname) {
        // 맞다면 삭제 버튼을 활성화
        clone
          .querySelector(".deleteReply")
          .setAttribute("data-replynum", data.replyNum.toString());
      }else{
        clone.querySelector(".deleteReply").style.display = "none";
      }
      console.log(currentUser, data.userNickname);

      replyContainer.appendChild(clone);
    }
  }
}

async function addReply() {
  try {
      let formData = new FormData(document.querySelector('#replyForm'));
      let response = await fetch('/api/addReply', 
      {
          method:'POST',
          cache:'no-cache',
          body:new URLSearchParams(formData).toString(), 
          headers:{'Content-Type':'application/x-www-form-urlencoded'}
      });

      if (!response.ok) {
          throw new Error("댓글 등록 실패");
      }

      let replyList: { success: boolean } = await response.json();

      if (replyList.success) {
          clearReplyInput();
          loadReply();
          location.href = '/app/postview.jsp?id=' + formData.get("boardListNum");
      }
  } catch (error) {
      console.error("Fetch 오류:", error);
  }
}

function clearReplyInput() {
  let replyContentsInput = document.getElementById(
    "replyContents"
  ) as HTMLTextAreaElement;
  if (replyContentsInput) {
    replyContentsInput.value = "";
  }
}

async function deleteReply(replyNum: number) {
  try {
    console.log(replyNum);
    let response = await fetch(`/api/deleteReply?replyNum=${replyNum}`, {
      method: "POST",
    });

    if (!response.ok) {
      throw new Error("댓글 삭제 실패");
    }

    let replyList: { success: boolean } = await response.json();

    if (replyList.success) {
      console.log("댓글 삭제 성공");
      loadReply();
      location.href =
        "/app/postview.jsp?id=" +
        document.getElementById("boardListNumInput").value;
    } else {
      console.error("댓글 삭제 실패:", replyList.success);
    }
  } catch (error) {
    console.error("댓글 삭제 중 오류 발생:", error);
    alert("댓글 삭제 중 오류 발생");
  }
}
