// let eModalImage = document.getElementsByClassName("modal-car-image");

const BASE_URL_CLOUD_IMAGE = "https://res.cloudinary.com/dw3x98oui/image/upload";
const BASE_SCALE_IMAGE = "c_limit,w_50,h_50,q_100";

let urlImages;

let idImages = [];

function clearForm() {
    idImages = [];

    const imgEle = document.getElementById("images");
    const imageOld = imgEle.querySelectorAll('img');
    for (let i = 0; i < imageOld.length; i++) {
        imgEle.removeChild(imageOld[i])
    }
    const avatarDefault = document.createElement('img');
    avatarDefault.src = '/assets/inputicon.png';
    avatarDefault.classList.add('avatar-preview');
    imgEle.append(avatarDefault)
    // carForm.reset();
    // carSelected = {};
}

function showImgInForm(images) {
    const imgEle = document.getElementById("images");
    const imageOld = imgEle.querySelectorAll('img');
    for (let i = 0; i < imageOld.length; i++) {
        imgEle.removeChild(imageOld[i])
    }
    const avatarDefault = document.createElement('img');
    images.forEach((img, index) => {
        let image = document.createElement('img');
        image.src = img;
        image.classList.add('avatar-preview');
        imgEle.append(image)
    })
    avatarDefault.src = '/assets/inputicon.png';
    avatarDefault.classList.add('avatar-preview');
    imgEle.append(avatarDefault)

}

async function previewImage(evt) {
    if (evt.target.files.length === 0) {
        return;
    }
    idImages = [];

    const imgEle = document.getElementById("images");
    const imageOld = imgEle.querySelectorAll('img');
    for (let i = 0; i < imageOld.length; i++) {
        imgEle.removeChild(imageOld[i])
    }

    // When the image is loaded, update the img element's src
    const files = evt.target.files

    for (let i = 0; i < files.length; i++) {
        toastr.info(`Uploading  ${i+1} / ${files.length} . . . `, '', {timeOut: 1000})
        const file = files[i];
        await previewImageFile(file, i);
        if (file) {
            disableSaveChangesButton();
            // Create a new FormData object and append the selected file
            const formData = new FormData();
            formData.append("avatar", file);
            formData.append("fileType", "image");
            try {
                // Make a POST request to upload the image
                const response = await fetch("/api/image", {
                    method: "POST",
                    body: formData,
                });
                if (response.ok) {
                    const result = await response.json();
                    if (result) {
                        const id = result.id;
                        idImages.push(id);

                    } else {
                        toastr.error('Image ID not found in the response.');
                    }
                } else {
                    // Handle non-OK response (e.g., show an error message)
                    toastr.error('Failed to upload image:', response.statusText);
                }
            } catch (error) {
                // Handle network or other errors
                console.error('An error occurred:', error);
            }

            enableSaveChangesButton();
        }
    }
    renderUploadIcon();
    toastr.success("Upload completed!");
}

async function previewImageFile(file) {
    const reader = new FileReader();
    reader.onload = function () {
        const imgEle = document.getElementById("images");
        const img = document.createElement('img');
        img.src = reader.result;
        img.classList.add('avatar-preview');
        imgEle.append(img);

    };
    reader.readAsDataURL(file);
}
function renderUploadIcon() {
    const imgEle = document.getElementById("images");
    const img = document.createElement('img');
    img.src =  '/assets/inputicon.png';
    img.classList.add('avatar-preview');
    imgEle.append(img);
}


// 2 hàm để tự động Disable nút SaveChange khi tải ảnh lên
function disableSaveChangesButton() {
    const saveChangesButton = document.getElementById('saveChangesButton');
    saveChangesButton.disabled = true;
}

function enableSaveChangesButton() {
    const saveChangesButton = document.getElementById('saveChangesButton');
    saveChangesButton.disabled = false;
}


