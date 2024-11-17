var compid = document.getElementById('computer-id');
var compuser = document.getElementById('computer-user');
var compname = document.getElementById('computer-name');
var producer = document.getElementById('computer-producer');
var newc = document.getElementById('computer-new');
var price = document.getElementById('computer-price');
var description = document.getElementById('computer-description');
var ram = document.getElementById('computer-ram');
var cpu = document.getElementById('computer-cpu');
var rom = document.getElementById('computer-rom');
var romType = document.getElementById('computer-rom-type');
var os = document.getElementById('computer-os');
var gpu = document.getElementById('computer-gpu');
var image = document.getElementById('computer-img');

var cardName = document.getElementById("card-name");
var cardProducer = document.getElementById('card-producer');
var cardPrice = document.getElementById('card-price');
var cardImage = document.getElementById('card-image');
var cardCpu = document.getElementById('card-cpu');
var cardRam = document.getElementById('card-ram');
var cardRom = document.getElementById('card-rom');
var cardGpu = document.getElementById('card-gpu');
var cardOs = document.getElementById('card-os');
var cardRomType = document.getElementById('card-rom-type');


var oldBadge = document.getElementById('old-badge');
var newBadge = document.getElementById('new-badge');

var computerId;

oldBadge.style.display = 'none';
newBadge.style.display = 'none';


if (compsString != null) {
    comps = JSON.parse(compsString);

    for (let i = 0; i < comps.length; i++) {
        console.log(user.id);
    }
}


function fillNameCard() {
    if (compname.value.length >= 1) {
        cardName.innerText = compname.value;
    } else {
        cardName.innerText = 'Name';
    }
}

function fillProducerCard() {
    if (producer.value.length >= 1) {
        cardProducer.innerText = producer.value;
    } else {
        cardProducer.innerText = 'Name';
    }
}

function fillNewCard() {
    if (newc.value === 'New') {
        oldBadge.style.display = 'none';
        newBadge.style.display = 'inline';
    } else {
        oldBadge.style.display = 'inline';
        newBadge.style.display = 'none';
    }
}

function fillPriceCard() {
    if (price.value.length > 1) {
        cardPrice.innerText = price.value + '$';
    }
}

function fillRamCard() {
    if (ram.value.length > 1) {
        cardRam.innerText = ram.value + ' GB';
    }
}

function fillCpuCard() {
    cardCpu.innerText = cpu.value;
}

function fillRomCard() {
    if (rom.value.length > 1) {
        cardRom.innerText = rom.value + ' GB';
    }
}

function fillRomTypeCard() {
    cardRomType.innerText = ', ' + romType.value;
}

function fillImageLinkCard() {
    cardImage.setAttribute('src', image.value);
}

function fillOSCard() {
    cardOs.innerText = os.value;
}

function fillGpuCard() {
    if (gpu.value.length > 1) {
        cardGpu.innerText = gpu.value + ' GB';
    }
}

function submitForm() {    
    const formData = getFormData();
    console.log(JSON.stringify(formData))
    fetch("/computer/save", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("Success:", data);
        alert("Worker saved successfully!");
      })
      .catch((error) => {
        console.error("Error:", error);
        alert('Failed to save worker.');
        // window.location.href = "/hr/main";
      });
  }
  
  function getFormData() {
	const producerData = {
		id: producer.value,
		name: null
	}
	const cpuData = {
		id: cpu.value,
		name: null,
		generation: null,
		power: null,
		core: null
	} 
	
	const osData = {
		id: os.value,
		name: null,
		version: null
	}
	
	const gpuData = {
		id: gpu.value,
		name: null,
		prototype: null,
		memory: null
	}
	
	const user = {
		id: null,
		username: compuser.value,
		name: null,
		surname: null,
		email: null,
		password: null
	}
	
    const computer = {
		id: compid.value,
		user: user,
        name: compname.value,
        producer: producerData,
        state: newc.value, 
        price: price.value,
        description: description.value,
        ram: ram.value,
        cpu: cpuData,
        rom: rom.value,
        romType: romType.value,
        os: osData,
        gpu: gpuData,
        imgURL: image.value
    };
    return computer;
}