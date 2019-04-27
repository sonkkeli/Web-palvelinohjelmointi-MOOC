var url = contextRoot + "tasks"

var http = new XMLHttpRequest()

http.onreadystatechange = function() {
    if (this.readyState != 4 || this.status != 200) {
        return
    }
    
    response = JSON.parse(this.responseText)
    
    //tyhjennetään tasklist
    document.getElementById("tasklist").innerHTML = "";
    
    // päivitetään tasklist
    for (var i = 0; i < response.length; i++) {
        var task = document.createElement("p")
        task.appendChild(document.createTextNode(response[i].name))
        
        document.getElementById("tasklist").appendChild(task)
    }    
}
    
function listTasks() {
    http.open("GET", url)
    http.send()
}

var httpAdd = new XMLHttpRequest()

httpAdd.onreadystatechange = function() {
    if (this.readyState != 4) {
        return
    }
    
    document.getElementById("task").innerHTML = this.responseText
}

function addTask() {    
    var task = {
        name: document.getElementById("task").value
    }
    
    httpAdd.open("POST", url)
    httpAdd.setRequestHeader("Content-Type", "application/json");
    httpAdd.send(JSON.stringify(task))
}