var select = function(s){
  return document.querySelector(s);
};

var popup = select('.popup'),
    bttn = select('.gio'),
    close = select('#close'),
    cont = select('.pitch');

bttn.onclick = function() {
  cont.style.filter = "blur(10px)";
  popup.classList.add("visible");
};

close.onclick = function() {
  popup.classList.remove("visible");
  cont.style.filter = "none";
};