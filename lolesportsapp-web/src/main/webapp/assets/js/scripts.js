function confirmAction() {
    var txt;
    var r = confirm("Are you sure you want to perform this action?");
    
    if (r == true) {
        txt = "You pressed OK!";
    } 
    
    else {
        txt = "You pressed Cancel!";
    }
    document.getElementById("demo").innerHTML = txt;
}