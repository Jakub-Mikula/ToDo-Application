let allButton = document.querySelector('#allButton')
let shoppingButton = document.querySelector('#shoppingButton')
let friendsButton = document.querySelector('#friendsButton')
let jobButton = document.querySelector('#jobButton')
let houseButton = document.querySelector('#houseButton')
let removeButton = document.querySelectorAll('.noteButton')

let main = document.querySelector('main')
let todo = document.querySelector('.todo')

console.log("It works")

fetch("http://localhost:8080/api/todos")
    .then(res => res.json())
    .then(data => {
        console.log(data)
        let i = 0;
        let allTodos = document.querySelectorAll('.todo')
        removeAllChildTodos(allTodos)
        data.forEach((todo) => {
            createTodo(data, i)
            i++;
        })
    })
allButton.addEventListener('click', () => {
    fetch("http://localhost:8080/api/todos")
        .then(res => res.json())
        .then(data => {
            console.log(data)
            let i = 0;
            let allTodos = document.querySelectorAll('.todo')
            removeAllChildTodos(allTodos)
            data.forEach((todo) => {
                createTodo(data, i)
                i++;
            })
        })
})

shoppingButton.addEventListener('click', () => {
    fetch("http://localhost:8080/api/todo?type=shopping")
        .then(res => res.json())
        .then(data => {
            let i = 0;
            let allTodos = document.querySelectorAll('.todo')
            removeAllChildTodos(allTodos)
            data.forEach((todo) => {
                createTodo(data, i)
                i++;
            })
        })
})

friendsButton.addEventListener('click', () => {
    fetch("http://localhost:8080/api/todo?type=friends")
        .then(res => res.json())
        .then(data => {
            let i = 0;
            let allTodos = document.querySelectorAll('.todo')
            removeAllChildTodos(allTodos)
            data.forEach((todo) => {
                createTodo(data, i)
                i++;
            })
        })
})

houseButton.addEventListener('click', () => {
    fetch("http://localhost:8080/api/todo?type=house")
        .then(res => res.json())
        .then(data => {
            console.log(data)
            let i = 0;
            let allTodos = document.querySelectorAll('.todo')
            removeAllChildTodos(allTodos)
            data.forEach((todo) => {
                createTodo(data, i)
                i++;
            })
        })
})

jobButton.addEventListener('click', () => {
    fetch("http://localhost:8080/api/todo?type=job")
        .then(res => res.json())
        .then(data => {
            console.log(data)
            let i = 0;
            let allTodos = document.querySelectorAll('.todo')
            removeAllChildTodos(allTodos)
            data.forEach((todo) => {
                createTodo(data, i)
                i++;
            })
        })
})


function removeAllChildTodos(allTodos) {
    for (let j = 0; j < allTodos.length; j++)
        main.removeChild(allTodos[j])
}

function createTodo(data, i){
    let div = document.createElement('div')
    div.setAttribute("class", "todo")
    let h3 = document.createElement('h3')
    h3.innerHTML = data[i][2]
    let p = document.createElement('p')
    p.innerHTML = data[i][1]
    let removeButton = document.createElement('button')
    removeButton.innerHTML = "Remove"
    removeButton.setAttribute("class", "todoButton")
    removeButton.setAttribute("id", data[i][0])
    removeButton.addEventListener('click', (event) =>{
        let requestBody = {
            id: removeButton.id
        }
        console.log(event.target.getAttribute("id"))
        fetch("http://localhost:8080/api/todo/"+data[i][0],{
            method: "DELETE",
            headers:{
                "Content-type": "application/json"
            },
            body: JSON.stringify(requestBody)
        })
        window.location.replace("http://localhost:8080")
    })
    div.appendChild(h3)
    div.appendChild(p)
    div.appendChild(removeButton)
    main.appendChild(div)
}