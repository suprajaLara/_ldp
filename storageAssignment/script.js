if(!localStorage.getItem('localStorageScore')){
    localStorage.setItem('localStorageScore',0);
}
if(!sessionStorage.getItem('sessionStorageScore')){
    sessionStorage.setItem('sessionStorageScore',0);
}

var localScore = document.getElementById("localScore");
var sessionScore = document.getElementById("sessionScore");

localScore.innerHTML = localStorage.getItem('localStorageScore');
sessionScore.innerHTML = localStorage.getItem('sessionStorageScore');
if(!sessionScore.innerHTML) sessionScore.innerHTML="0";

function localClick(){
    localStorage.setItem('localStorageScore',parseInt(localStorage.getItem('localStorageScore'))+1);
    localScore.innerHTML = localStorage.getItem('localStorageScore');
}

function sessionClick(){
    sessionStorage.setItem('sessionStorageScore',parseInt(sessionStorage.getItem('sessionStorageScore'))+1);
    sessionScore.innerHTML = sessionStorage.getItem('sessionStorageScore');
}

