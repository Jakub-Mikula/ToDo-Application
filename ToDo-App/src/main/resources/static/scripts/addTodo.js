let form = document.querySelector('form')

form.addEventListener('submit', (event) => {
    event.preventDefault();
    let requestBody = {
        name: form.name.value,
        content: form.content.value,
        type: form.type.value
    }
    fetch("http://localhost:8080/api/todo",{
        method: "POST",
        headers:{
            "Content-type": "application/json"
        },
        body: JSON.stringify(requestBody)
    })
        .then(res => res.json())
        .then(data => {
            if(data.error === "Please fill in the name of the todo" || data.error === "Please fill some content to this todo") {
                console.log(data.error)
            }else {
                window.location.replace("http://localhost:8080")
            }
        })
})