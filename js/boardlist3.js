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
function ajax3(url, option) {
    return __awaiter(this, void 0, void 0, function* () {
        console.log("ajax 로딩 중~~~~~");
        return fetch(url, option).then((res) => res.json());
    });
}
window.onload = submitSearch3();
// 검색 폼 제출 시 호출되는 함수
function submitSearch3() {
    console.log("전송되었습니다");
    try {
        let formData = new FormData(document.querySelector("#searchform3"));
        ajax3("/api/boardList3", {
            method: "POST",
            cache: "no-cache",
            body: new URLSearchParams(formData).toString(),
            headers: { "Content-Type": "application/x-www-form-urlencoded" },
        }).then((json) => {
            var _a, _b;
            console.log(json);
            let boards3 = document.querySelector("#boards3");
            let template = document.querySelector("#boards3 template");
            let pagesContainer3 = document.querySelector("#pages3");
            let pageTemplate = document.querySelector("#pages3 template");
            // 기존의 게시글 목록을 지우고 새로운 검색 결과를 표시
            if (template) {
                boards3.innerHTML = "";
                if (json.data.length === 0) {
                    alert("일치하는 결과가 없습니다. 리스트로 돌아갑니다.");
                    location.reload(); // 페이지를 강제로 다시 로드
                    return;
                }
                for (let data of json.data) {
                    template.content.querySelector(".boardListNum3").innerHTML =
                        data.boardListNum3;
                    (_a = template.content
                        .querySelector(".boardListNum3")) === null || _a === void 0 ? void 0 : _a.setAttribute("href", `/app/postview3.jsp?id=${data.boardListNum3}`);
                    template.content.querySelector(".title3").innerHTML = data.title3;
                    (_b = template.content
                        .querySelector(".title3")) === null || _b === void 0 ? void 0 : _b.setAttribute("href", `/app/postview3.jsp?id=${data.boardListNum3}`);
                    template.content.querySelector(".mainContents3").innerHTML =
                        data.mainContents3;
                    template.content.querySelector(".userNickname3").innerHTML =
                        data.userNickname3;
                    template.content.querySelector(".hitCount3").innerHTML =
                        data.hitCount3;
                    template.content.querySelector(".regDate3").innerHTML = data.regDate3;
                    let a = document.createElement("div");
                    a.innerHTML = template.innerHTML;
                    if (boards3) {
                        boards3.appendChild(template);
                        boards3.appendChild(a);
                    }
                }
            }
            if (pageTemplate && pagesContainer3) {
                pagesContainer3.innerHTML = "";
                for (let i = 1; i <= json.totalPages3; i += 1) {
                    let span = document.createElement("span");
                    span.innerText = i;
                    span.onclick = function () {
                        pageChange3(i);
                    };
                    pagesContainer3.appendChild(pageTemplate);
                    pagesContainer3.appendChild(span);
                }
            }
        });
    }
    catch (error) {
        console.error("Fetch 오류:", error);
    }
}
// 페이지 링크 동기화 안되었음 일단 클릭하면 이동은 가능함
function pageChange3(page3) {
    document.querySelector("#searchform3 #page3").value = page3;
    submitSearch3();
}
