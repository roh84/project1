//@ts-nocheck

//채울래
function fillPostData2(userInfo2: string, titleInfo2: string, contentInfo2: string) {
    let userNickname2 = document.getElementById('userNickname2');
    let viewTitle2 = document.getElementById('viewTitle2');
    let viewTextarea2 = document.getElementById('viewTextarea2');

    //바꿔 없으면 기존 거 출력됨
    if (userNickname2 && viewTitle2 && viewTextarea2) {
        userNickname2.innerText =  userInfo2;
        viewTitle2.innerText = titleInfo2;
        viewTextarea2.innerText =contentInfo2;
    }
}


let clickedPostId2 = valueId;// 클릭한 게시글의 ID


let userCheck:String = sessionUser; //ID로 작성자를 받아올 예정

let writer = "";            //함수로 글쓴이 받아올 예정

console.log("유저 데이터 체크" + userCheck);

///////

function addEditButtonsIfMatch2() {
    // 작성자와 사용자가 같을 경우
    if (writer === userCheck) {
        // 수정 버튼 생성
        let editButton2 = document.createElement("button");
        editButton2.type = "button";
        editButton2.innerText = "수정";
        editButton2.onclick = function() {
            location.href = `/app/editPost2.jsp?id=${clickedPostId2}`;
        };

        // 삭제 버튼 생성
        let deleteButton2 = document.createElement("button");
        deleteButton2.type = "button";
        deleteButton2.innerText = "삭제";
        deleteButton2.onclick = function() {
            deletePost2(clickedPostId2);
        };

        // 버튼들을 추가할 부모 요소 가져오기
        let buttonContainer2 = document.getElementById("buttonContainer2");

        // 부모 요소에 버튼들 추가
        if (buttonContainer2) {
            buttonContainer2.appendChild(editButton2);
            buttonContainer2.appendChild(deleteButton2);
        }
    }
}

// writerSearch 함수 내에서 호출
function writerSearch2() {
    fetch(`/api/writerSearch2?boardListNum2=${clickedPostId2}`, {
        method: "GET"
    })
    .then(response => response.text())
    .then(data => {
        writer = data; // 작성자 정보 업데이트
        console.log("작성자 : " + writer);
        console.log("로그인 : " + userCheck);

        // 작성자와 사용자가 같으면 버튼 추가 함수 호출
        addEditButtonsIfMatch2();
    })
    .catch(error => {
        console.error('리스폰스 됐니?', error);
    });
}

writerSearch2();


function PostInfo2() {
    fetch(`/api/showPost2?boardListNum2=${clickedPostId2}`,{
    method: "GET"  
})
    .then(response => response.json())
        .then(data => {
            fillPostData2(data.userNickname2, data.title2, data.mainContents2);
        })
        .catch(error => {
            console.error('게시글 정보를 가져오지 못했습니다.', error);
        });
}
window.onload = function() {
    PostInfo2();
};



function editPost2() {
    
    let form: HTMLFormElement | null = document.getElementById("editForm2") as HTMLFormElement | null;
   
        form.submit();
    
   // location.href="/boardList.jsp";
}




// 이미지 불러오기
function getImagePaths2() {
    fetch(`/api/getImagePaths2?boardListNum2=${clickedPostId2}`, {
        method: "GET"
    })
    .then(response => response.json()
    )
    .then(data => {
        // 이미지를 표시할 함수 호출
        console.log(data.paths2);
        console.log("11");
        displayImages2(data.paths2);
        console.log("22");
    })
    .catch(error => {
        console.error('이미지 경로를 가져오지 못했습니다.', error);
    });
}

// 이미지를 표시하는 함수
function displayImages2(imagePaths2) {
    let imageContainer2 = document.getElementById("imageContainer2");
    console.log(imagePaths2);
    console.log("33");
    // 이미지를 표시할 div에 이미지 경로 넣음
    //imagePaths.paths.forEach(imagePath => {
        imagePaths2.forEach(imagePath => {
        let img = document.createElement("img");
        img.src = `/resources/${imagePath}`; //경로 /*/*/가져온 이름
        console.log("44");
        imageContainer2.appendChild(img);
    });
}

getImagePaths2();






function deletePost2(boardListNum2: number) {
    fetch(`/api/deletePost2?boardListNum2=${boardListNum2}`, {
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

    location.href="/app/boardlist2.jsp";
}
