function submitForm() {
    const formData = getFormData();
    console.log(JSON.stringify(formData))
    fetch("/cart/add", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
    })
        .then((response) => response.json())
        .then((data) => {
            console.log("Success:", data);
            alert("Added to Cart successfully");
            window.location.href = "/cart";
        })
        .catch((error) => {
            console.error("Error:", error);
            // alert('Failed to add to cart.');
            window.location.href = "/cart";
        });
}

var i = 15;
i = 15.5;


function getFormData() {
    const user = {
        id: null,
        username: document.getElementById('usernameField').value,
        name: null,
        surname: null,
        email: null,
        password: null
    }

    const comp = {
        id: document.getElementById('productId').value,
        user: null,
        name: null,
        producer: null,
        state: null,
        price: null,
        description: null,
        ram: null,
        cpu: null,
        rom: null,
        romType: null,
        os: null,
        gpu: null,
        imgURL: null
    }

    const cardItem = {
        id: null,
        computer: comp,
        quantity: document.getElementById('quantity').value,
        user: user
    }

    return cardItem;
}