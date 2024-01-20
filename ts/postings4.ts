//@ts-nocheck

//채울래
function fillPostData4(userInfo4: string, titleInfo4: string, contentInfo4: string) {
    let userNickname4 = document.getElementById('userNickname4');
    let viewTitle4 = document.getElementById('viewTitle4');
    let viewTextarea4 = document.getElementById('viewTextarea4');

    //바꿔 없으면 기존 거 출력됨
    if (userNickname4 && viewTitle4 && viewTextarea4) {
        userNickname4.innerText =  userInfo4;
        viewTitle4.innerText = titleInfo4;
        viewTextarea4.innerText =contentInfo4;
    }
}


let clickedPostId4 = valueId;// 클릭한 게시글의 ID


let userCheck:String = sessionUser; //ID로 작성자를 받아올 예정

let writer = "";            //함수로 글쓴이 받아올 예정

console.log("유저 데이터 체크" + userCheck);

///////

function addEditButtonsIfMatch4() {
    // 작성자와 사용자가 같을 경우
    if (writer === userCheck) {
        // 수정 버튼 생성
        let editButton4 = document.createElement("button");
        editButton4.type = "button";
        editButton4.innerText = "수정";
        editButton4.onclick = function() {
            location.href = `/app/editPost4.jsp?id=${clickedPostId4}`;
        };

        // 삭제 버튼 생성
        let deleteButton4 = document.createElement("button");
        deleteButton4.type = "button";
        deleteButton4.innerText = "삭제";
        deleteButton4.onclick = function() {
            deletePost4(clickedPostId4);
        };

        // 버튼들을 추가할 부모 요소 가져오기
        let buttonContainer4 = document.getElementById("buttonContainer4");

        // 부모 요소에 버튼들 추가
        if (buttonContainer4) {
            buttonContainer4.appendChild(editButton4);
            buttonContainer4.appendChild(deleteButton4);
        }
    }
}

// writerSearch 함수 내에서 호출
function writerSearch4() {
    fetch(`/api/writerSearch4?boardListNum4=${clickedPostId4}`, {
        method: "GET"
    })
    .then(response => response.text())
    .then(data => {
        writer = data; // 작성자 정보 업데이트
        console.log("작성자 : " + writer);
        console.log("로그인 : " + userCheck);

        // 작성자와 사용자가 같으면 버튼 추가 함수 호출
        addEditButtonsIfMatch4();
    })
    .catch(error => {
        console.error('리스폰스 됐니?', error);
    });
}

writerSearch4();


function PostInfo4() {
    fetch(`/api/showPost4?boardListNum4=${clickedPostId4}`,{
    method: "GET"  
})
    .then(response => response.json())
        .then(data => {
            fillPostData4(data.userNickname4, data.title4, data.mainContents4);
        })
        .catch(error => {
            console.error('게시글 정보를 가져오지 못했습니다.', error);
        });
}
window.onload = function() {
    PostInfo4();
};



function editPost4() {
    
    let form: HTMLFormElement | null = document.getElementById("editForm4") as HTMLFormElement | null;
   
        form.submit();
    
   // location.href="/boardList.jsp";
}

// 이미지 불러오기
function getImagePaths4() {
    fetch(`/api/getImagePaths4?boardListNum4=${clickedPostId4}`, {
        method: "GET"
    })
    .then(response => response.json()
    )
    .then(data => {
        // 이미지를 표시할 함수 호출
        console.log(data.paths4);

        displayImages4(data.paths4);
    })
    .catch(error => {
        console.error('이미지 경로를 가져오지 못했습니다.', error);
    });
}

// 이미지를 표시하는 함수
function displayImages4(imagePaths4) {
    let imageContainer4 = document.getElementById("imageContainer4");
    console.log(imagePaths4);
    // 이미지를 표시할 div에 이미지 경로 넣음
    //imagePaths.paths.forEach(imagePath => {
        imagePaths4.forEach(imagePath => {
        let img = document.createElement("img");
        img.src = `/resources/${imagePath}`; //경로 /*/*/가져온 이름

        imageContainer4.appendChild(img);
    });
}


getImagePaths4();








function deletePost4(boardListNum4: number) {
    fetch(`/api/deletePost4?boardListNum4=${boardListNum4}`, {
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

    location.href="/app/boardlist4.jsp";
}
