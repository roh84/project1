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
function ajax2(url, option) {
    return __awaiter(this, void 0, void 0, function* () {
        console.log("ajax 로딩 중~~~~~");
        return fetch(url, option).then((res) => res.json());
    });
}
window.onload = submitSearch2();
// 검색 폼 제출 시 호출되는 함수
function submitSearch2() {
    console.log("전송되었습니다");
    let form = document.getElementById("searchform2");
    if (form) {
        let formData = new FormData(form);
        ajax2("/api/boardList2", {
            method: "POST",
            body: formData,
        }).then((json) => {
            var _a, _b;
            console.log(json);
            let boards2 = document.querySelector("#boards2");
            let template = document.querySelector("#boards2 template");
            // 기존의 게시글 목록을 지우고 새로운 검색 결과를 표시
            if (template) {
                boards2.innerHTML = "";
                for (let data of json.data) {
                    template.content.querySelector(".boardListNum2").innerHTML = data.boardListNum2;
                    (_a = template.content.querySelector(".boardListNum2")) === null || _a === void 0 ? void 0 : _a.setAttribute("href", `/app/postview2.jsp?id=${data.boardListNum2}`);
                    template.content.querySelector(".title2").innerHTML = data.title2;
                    (_b = template.content.querySelector(".title2")) === null || _b === void 0 ? void 0 : _b.setAttribute("href", `/app/postview2.jsp?id=${data.boardListNum2}`);
                    template.content.querySelector(".mainContents2").innerHTML = data.mainContents2;
                    template.content.querySelector(".userNickname2").innerHTML = data.userNickname2;
                    template.content.querySelector(".hitCount2").innerHTML = data.hitCount2;
                    template.content.querySelector(".regDate2").innerHTML = data.regDate2;
                    let a = document.createElement("div");
                    a.innerHTML = template.innerHTML;
                    if (boards2) {
                        boards2.appendChild(template);
                        boards2.appendChild(a);
                    }
                }
            }
        });
    }
}
