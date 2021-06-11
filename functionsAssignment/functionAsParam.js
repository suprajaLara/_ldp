function customWelcome(message){
    alert(message);
}

function welcome(func, name){
    func("Hello! "+name)
}

//customWelcome() passed into welcome() -> function passed as parameter to other function
welcome(customWelcome,"Supraja")