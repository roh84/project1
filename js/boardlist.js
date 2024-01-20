"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
//@ts-nocheck
function ajax(url, option) {
    return __awaiter(this, void 0, void 0, function* () {
        console.log("ajax 로딩 중~~~~~");
        return fetch(url, option).then((res) => res.json());
    });
}
window.onload = submitSearch();
// 검색 폼 제출 시 호출되는 함수
function submitSearch() {
    console.log("전송되었습니다");
    try {
        let formData = new FormData(document.querySelector("#searchform"));
        ajax("/api/boardList", {
            method: "POST",
            cache: "no-cache",
            body: new URLSearchParams(formData).toString(),
            headers: { "Content-Type": "application/x-www-form-urlencoded" },
        }).then((json) => {
            var _a, _b;
            console.log(json);
            let boards = document.querySelector("#boards");
            let template = document.querySelector("#boards template");
            let pagesContainer = document.querySelector("#pages");
            let pageTemplate = document.querySelector("#pages template");
            // 기존의 게시글 목록을 지우고 새로운 검색 결과를 표시
            if (template) {
                boards.innerHTML = "";
                if (json.data.length === 0) {
                    alert("일치하는 결과가 없습니다. 리스트로 돌아갑니다.");
                    location.reload(); // 페이지를 강제로 다시 로드
                    return;
                }
                for (let data of json.data) {
                    template.content.querySelector(".boardListNum").innerHTML =
                        data.boardListNum;
                    (_a = template.content
                        .querySelector(".boardListNum")) === null || _a === void 0 ? void 0 : _a.setAttribute("href", `/app/postview.jsp?id=${data.boardListNum}`);
                    template.content.querySelector(".title").innerHTML = data.title;
                    (_b = template.content
                        .querySelector(".title")) === null || _b === void 0 ? void 0 : _b.setAttribute("href", `/app/postview.jsp?id=${data.boardListNum}`);
                    template.content.querySelector(".mainContents").innerHTML =
                        data.mainContents;
                    template.content.querySelector(".userNickname").innerHTML =
                        data.userNickname;
                    template.content.querySelector(".hitCount").innerHTML = data.hitCount;
                    template.content.querySelector(".regDate").innerHTML = data.regDate;
                    let a = document.createElement("div");
                    a.innerHTML = template.innerHTML;
                    if (boards) {
                        boards.appendChild(template);
                        boards.appendChild(a);
                    }
                }
            }
            if (pageTemplate && pagesContainer) {
                pagesContainer.innerHTML = "";
                for (let i = 1; i <= json.totalPages; i += 1) {
                    let span = document.createElement("span");
                    span.innerText = i;
                    console.log("??" + i);
                    span.onclick = function () {
                        pageChange(i);
                        console.log("???" + i);
                    };
                    pagesContainer.appendChild(pageTemplate);
                    pagesContainer.appendChild(span);
                }
            }
        });
    }
    catch (error) {
        console.error("Fetch 오류:", error);
    }
}
// 페이지 링크 동기화 안되었음 일단 클릭하면 이동은 가능함
function pageChange(page) {
    document.querySelector("#searchform #page").value = page;
    submitSearch();
}
