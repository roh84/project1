//@ts-nocheck

//채울래
function fillPostData(userInfo: string, titleInfo: string, contentInfo: string) {
    let userNickname = document.getElementById('userNickname');
    let viewTitle = document.getElementById('viewTitle');
    let viewTextarea = document.getElementById('viewTextarea');

    //바꿔 없으면 기존 거 출력됨
    if (userNickname && viewTitle && viewTextarea) {
        userNickname.innerText =  userInfo;
        viewTitle.innerText = titleInfo;
        viewTextarea.innerText =contentInfo;
    }
}

let clickedPostId = valueId;// 클릭한 게시글의 ID


let userCheck:String = sessionUser; //ID로 작성자를 받아올 예정

let writer = "";            //함수로 글쓴이 받아올 예정

console.log("유저 데이터 체크" + userCheck);

///////

function addEditButtonsIfMatch() {
    // 작성자와 사용자가 같을 경우
    if (writer === userCheck) {
        // 수정 버튼 생성
        let editButton = document.createElement("button");
        editButton.type = "button";
        editButton.innerText = "수정";
        editButton.onclick = function() {
            location.href = `/app/editPost.jsp?id=${clickedPostId}`;
        };

        // 삭제 버튼 생성
        let deleteButton = document.createElement("button");
        deleteButton.type = "button";
        deleteButton.innerText = "삭제";
        deleteButton.onclick = function() {
            deletePost(clickedPostId);
        };

        // 버튼들을 추가할 부모 요소 가져오기
        let buttonContainer = document.getElementById("buttonContainer");

        // 부모 요소에 버튼들 추가
        if (buttonContainer) {
            buttonContainer.appendChild(editButton);
            buttonContainer.appendChild(deleteButton);
        }
    }
}

// writerSearch 함수 내에서 호출
function writerSearch() {
    fetch(`/api/writerSearch?boardListNum=${clickedPostId}`, {
        method: "GET"
    })
    .then(response => response.text())
    .then(data => {
        writer = data; // 작성자 정보 업데이트
        console.log("작성자 : " + writer);
        console.log("로그인 : " + userCheck);

        // 작성자와 사용자가 같으면 버튼 추가 함수 호출
        addEditButtonsIfMatch();
    })
    .catch(error => {
        console.error('리스폰스 됐니?', error);
    });
}

writerSearch();

function PostInfo() {
    fetch(`/api/showPost?boardListNum=${clickedPostId}`,{
    method: "GET"  
})
    .then(response => response.json())
        .then(data => {
            fillPostData(data.userNickname, data.title, data.mainContents);
        })
        .catch(error => {
            console.error('게시글 정보를 가져오지 못했습니다.', error);
        });
}
window.onload = function() {
    PostInfo();
};



function editPost() {
    
    let form: HTMLFormElement | null = document.getElementById("editForm") as HTMLFormElement | null;
   
        form.submit();
    
   // location.href="/boardList.jsp";
}

// 이미지 불러오기
function getImagePaths() {
    fetch(`/api/getImagePaths?boardListNum=${clickedPostId}`, {
        method: "GET"
    })
    .then(response => response.json()
    )
    .then(data => {
        // 이미지를 표시할 함수 호출
        console.log(data.paths);

        displayImages(data.paths);
    })
    .catch(error => {
        console.error('이미지 경로를 가져오지 못했습니다.', error);
    });
}

// 이미지를 표시하는 함수
function displayImages(imagePaths) {
    let imageContainer = document.getElementById("imageContainer");
    console.log(imagePaths);
    // 이미지를 표시할 div에 이미지 경로 넣음
    //imagePaths.paths.forEach(imagePath => {
        imagePaths.forEach(imagePath => {
        let img = document.createElement("img");
        img.src = `/resources/${imagePath}`; //경로 /*/*/가져온 이름

        imageContainer.appendChild(img);
    });
}


getImagePaths();






function deletePost(boardListNum: number) {
    fetch(`/api/deletePost?boardListNum=${boardListNum}`, {
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

    location.href="/app/boardlist.jsp";
}
s