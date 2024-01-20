/**
 * 
 */

 
const modalBtn = document.getElementById("open-modal");
const modal = document.getElementById("modal");
const closeModalBtn = document.getElementById("close-modal");

modalBtn.addEventListener("click", () => {
  modal.style.display = "block";
});

closeModalBtn.addEventListener("click", () => {
  modal.style.display = "none";
});

const receptionBtn = document.querySelector(".notebtn1");
const firstView = document.querySelector(".note-reception");
const sendBtn = document.querySelector(".notebtn2");
const sendView = document.querySelector(".note-sendview");
const writeBtn = document.querySelector(".notebtn3");
const writeView = document.querySelector(".note-write");

receptionBtn.addEventListener("click", () => {
  firstView.style.display = "block";
  writeView.style.display = "none";
  sendView.style.display = "none";
});

sendBtn.addEventListener("click", () => {
  firstView.style.display = "none";
  writeView.style.display = "none";
  sendView.style.display = "block";
});

writeBtn.addEventListener("click", () => {
  writeView.style.display = "block";
  firstView.style.display = "none";
  sendView.style.display = "none";
});


