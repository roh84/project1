//@ts-nocheck

//채울래
function fillPostData3(userInfo3: string, titleInfo3: string, contentInfo3: string) {
    let userNickname3 = document.getElementById('userNickname3');
    let viewTitle3 = document.getElementById('viewTitle3');
    let viewTextarea3 = document.getElementById('viewTextarea3');

    //바꿔 없으면 기존 거 출력됨
    if (userNickname3 && viewTitle3 && viewTextarea3) {
        userNickname3.innerText =  userInfo3;
        viewTitle3.innerText = titleInfo3;
        viewTextarea3.innerText =contentInfo3;
    }
}


let clickedPostId3 = valueId;// 클릭한 게시글의 ID


let userCheck:String = sessionUser; //ID로 작성자를 받아올 예정

let writer = "";            //함수로 글쓴이 받아올 예정

console.log("유저 데이터 체크" + userCheck);

///////

function addEditButtonsIfMatch3() {
    // 작성자와 사용자가 같을 경우
    if (writer === userCheck) {
        // 수정 버튼 생성
        let editButton3 = document.createElement("button");
        editButton3.type = "button";
        editButton3.innerText = "수정";
        editButton3.onclick = function() {
            location.href = `/app/editPost3.jsp?id=${clickedPostId3}`;
        };

        // 삭제 버튼 생성
        let deleteButton3 = document.createElement("button");
        deleteButton3.type = "button";
        deleteButton3.innerText = "삭제";
        deleteButton3.onclick = function() {
            deletePost3(clickedPostId3);
        };

        // 버튼들을 추가할 부모 요소 가져오기
        let buttonContainer3 = document.getElementById("buttonContainer3");

        // 부모 요소에 버튼들 추가
        if (buttonContainer3) {
            buttonContainer3.appendChild(editButton3);
            buttonContainer3.appendChild(deleteButton3);
        }
    }
}

// writerSearch 함수 내에서 호출
function writerSearch3() {
    fetch(`/api/writerSearch3?boardListNum3=${clickedPostId3}`, {
        method: "GET"
    })
    .then(response => response.text())
    .then(data => {
        writer = data; // 작성자 정보 업데이트
        console.log("작성자 : " + writer);
        console.log("로그인 : " + userCheck);

        // 작성자와 사용자가 같으면 버튼 추가 함수 호출
        addEditButtonsIfMatch3();
    })
    .catch(error => {
        console.error('리스폰스 됐니?', error);
    });
}

writerSearch3();


function PostInfo3() {
    fetch(`/api/showPost3?boardListNum3=${clickedPostId3}`,{
    method: "GET"  
})
    .then(response => response.json())
        .then(data => {
            fillPostData3(data.userNickname3, data.title3, data.mainContents3);
        })
        .catch(error => {
            console.error('게시글 정보를 가져오지 못했습니다.', error);
        });
}
window.onload = function() {
    PostInfo3();
};



function editPost3() {
    
    let form: HTMLFormElement | null = document.getElementById("editForm3") as HTMLFormElement | null;
   
        form.submit();
    
   // location.href="/boardList.jsp";
}


// 이미지 불러오기
function getImagePaths3() {
    fetch(`/api/getImagePaths3?boardListNum3=${clickedPostId3}`, {
        method: "GET"
    })
    .then(response => response.json()
    )
    .then(data => {
        // 이미지를 표시할 함수 호출
        console.log(data.paths3);

        displayImages3(data.paths3);
    })
    .catch(error => {
        console.error('이미지 경로를 가져오지 못했습니다.', error);
    });
}

// 이미지를 표시하는 함수
function displayImages3(imagePaths3) {
    let imageContainer3 = document.getElementById("imageContainer3");
    console.log(imagePaths3);
    // 이미지를 표시할 div에 이미지 경로 넣음
    //imagePaths.paths.forEach(imagePath => {
        imagePaths3.forEach(imagePath => {
        let img = document.createElement("img");
        img.src = `/resources/${imagePath}`; //경로 /*/*/가져온 이름

        imageContainer3.appendChild(img);
    });
}


getImagePaths3();








function deletePost3(boardListNum3: number) {
    fetch(`/api/deletePost3?boardListNum3=${boardListNum3}`, {
        method: "POST"
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            console.log("게시글 삭제 성공");
            // 삭제 성공 시 필요한 작업 수행
        } else {
            console.error("게시글 삭제 실패:", data.message);
        }
    })
    .catch(error => {
        console.error('게시글 삭제 중 오류 발생:', error);
        alert('게시글 삭제 중 오류 발생');
    });

    location.href="/app/boardlist3.jsp";
}
