"use strict";
//@ts-nocheck
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
//가입 체크를 위한 변수
let namecheck = false;
let idcheck = false;
let pwcheck = false;
//기본 패치 아작스 함수
let form = new FormData();
function loginajax(url, option) {
    return __awaiter(this, void 0, void 0, function* () {
        return fetch(url, option).then((res) => res.json());
    });
}
//아이디 중복확인
function logincheckID() {
    return __awaiter(this, void 0, void 0, function* () {
        loginajax("/api/select/checkapi.jsp", {
            method: "POST",
            body: form,
        }).then((json) => {
            let userIds = json.userids.map((data) => data.userId);
            let inputForUserId = document.querySelector("input[name='userid']").value;
            let checkID = userIds.find((lang) => lang === inputForUserId);
            if (inputForUserId.length <= 4) {
                idcheck = false;
                return Swal.fire({
                    title: "",
                    text: "5자 이상 적어주세요",
                    icon: "warning",
                });
            }
            if (checkID !== undefined) {
                idcheck = false;
                Swal.fire({
                    title: "",
                    text: "동일한 아이디가 있습니다",
                    icon: "warning",
                });
            }
            else {
                idcheck = true;
                Swal.fire({
                    title: "",
                    text: "사용가능한 아이디 입니다",
                    icon: "success",
                });
            }
        });
    });
}
//닉네임중복 확인
function logincheckName() {
    return __awaiter(this, void 0, void 0, function* () {
        loginajax("/api/select/checkapi.jsp", {
            method: "POST",
            body: form,
        }).then((json) => {
            let userNicknames = json.userNicknames.map((datas) => datas.userNickname);
            let inputForUserNickname = document.querySelector("input[name='nickname']").value;
            let checkNmae = userNicknames.find((lang) => lang === inputForUserNickname);
            if (inputForUserNickname.length <= 1) {
                idcheck = false;
                return Swal.fire({
                    title: "",
                    text: "2자 이상 적어주세요",
                    icon: "warning",
                });
            }
            if (checkNmae !== undefined) {
                namecheck = false;
                Swal.fire({
                    title: "",
                    text: "동일한 닉네임이 있습니다",
                    icon: "warning",
                });
            }
            else {
                namecheck = true;
                Swal.fire({
                    title: "",
                    text: "사용가능한 닉네임 입니다",
                    icon: "success",
                });
            }
        });
    });
}
// 비밀번호 일치 여부 확인
function checkPasswordMatch() {
    return __awaiter(this, void 0, void 0, function* () {
        let password = document.getElementById("password").value;
        let confirmPassword = document.getElementById("passwordcheck").value;
        let passwordMatchStatus = document.getElementById("passwordMatchStatus");
        if (password && confirmPassword) {
            if (password === confirmPassword) {
                passwordMatchStatus.innerText = "비밀번호 일치";
                passwordMatchStatus.style.color = "green";
                pwcheck = true;
            }
            else {
                passwordMatchStatus.innerText = "비밀번호 불일치";
                passwordMatchStatus.style.color = "red";
                pwcheck = false;
            }
        }
        else {
            passwordMatchStatus.innerText = "";
            pwcheck = false;
        }
    });
}
//닉네임
function checkAndDisableButton() {
    let name = document.getElementById("name").value;
    let nickname = document.getElementById("nickname").value;
    if (name && nickname && (idcheck && namecheck) === true) {
        document.getElementById("signupButton").disabled = true;
    }
    else {
        document.getElementById("signupButton").disabled = false;
    }
}
//올채크
document
    .getElementById("signupForm")
    .addEventListener("submit", function (event) {
    event.preventDefault();
    let name = document.getElementById("name").value;
    let nickname = document.getElementById("nickname").value;
    if (name && nickname && namecheck && idcheck && pwcheck) {
        this.submit();
    }
    else {
        let errorMessage = "";
        if (!name) {
            errorMessage += "이름이 올바르지 않습니다.\n";
        }
        if (!nickname) {
            errorMessage += "닉네임이 올바르지 않습니다.\n";
        }
        if (!namecheck) {
            errorMessage += "닉네임 중복 체크 해주세요.\n";
        }
        if (!idcheck) {
            errorMessage += "아이디 중복 체크 해주세요.\n";
        }
        if (!pwcheck) {
            errorMessage += "비밀번호 체크가 실패했습니다.\n";
        }
        Swal.fire({
            title: "",
            text: errorMessage,
            icon: "warning",
        });
    }
});
document.getElementById("nickname").addEventListener("input", () => {
    namecheck = false;
});
document.getElementById("userid").addEventListener("input", () => {
    idcheck = false;
});
document
    .getElementById("password")
    .addEventListener("input", checkPasswordMatch);
document
    .getElementById("passwordcheck")
    .addEventListener("input", checkPasswordMatch);
