
// let activeUser = localStorage.getItem("active-user");

// if (activeUser == null) {
//     document.getElementById('add-button').style.display = 'none';
//     document.getElementById('username-button').style.display = 'none';
// } else {
//     document.getElementById('login-button').style.display = 'none';
//     document.getElementById('registration-button').style.display = 'none';
//     var user = JSON.parse(localStorage.getItem('active-user'));

//     document.getElementById('username').innerText = user.username;
// }

new Splide('.splide1', {
    type: 'fade',
    rewind: true,
    autoplay: true,
    pagination: false,
    interval: 4000,
    arrows: false
}).mount();

console.log(screen.width);

if (screen.width >= 1245) {
    new Splide('.splide2', {
        type: 'loop',
        drag: 'free',
        snap: true,
        focus: 'center',
        autoplay: true,
        interval: 3000,
        perPage: 5,
        arrows: false,
        pagination: false
    }).mount();
    
    new Splide('.splide3', {
        type: 'loop',
        drag: 'free',
        snap: true,
        focus: 'center',
        autoplay: true,
        interval: 3000,
        perPage: 5,
        arrows: false,
        pagination: false
    }).mount();
} else if (screen.width >= 840) {
    new Splide('.splide2', {
        type: 'loop',
        drag: 'free',
        snap: true,
        focus: 'center',
        autoplay: true,
        interval: 3000,
        perPage: 3,
        arrows: false,
        pagination: false
    }).mount();
    
    new Splide('.splide3', {
        type: 'loop',
        drag: 'free',
        snap: true,
        focus: 'center',
        autoplay: true,
        interval: 3000,
        perPage: 3,
        arrows: false,
        pagination: false
    }).mount();
} else {
    new Splide('.splide2', {
        type: 'loop',
        drag: 'free',
        snap: true,
        focus: 'center',
        autoplay: true,
        interval: 3000,
        perPage: 2,
        arrows: false,
        pagination: false
    }).mount();
    
    new Splide('.splide3', {
        type: 'loop',
        drag: 'free',
        snap: true,
        focus: 'center',
        autoplay: true,
        interval: 3000,
        perPage: 2,
        arrows: false,
        pagination: false
    }).mount();
}

function changeComp(id) {
    var selectedComp = {};
    array.forEach(c => {
        if (c.id === id) {
            
        }
    });
}

// function logout() {
//     localStorage.removeItem("active-user");
//     location.replace("./login.html");
// }