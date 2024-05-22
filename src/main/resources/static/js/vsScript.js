const ENCRYPTED_IMAGES = [
	"modified.png",
	"modified.png_cipher_magnified",
	"modified.png_cipher_print_ready",
	"modified.png_key",
	"modified.png_key_magnified",
	"modified.png_key_print_ready"
];


/*const ENCRYPTED_IMAGES = [
	
	"modified.png_cipher_magnified",
	"modified.png_cipher_print_ready",
	"modified.png_key",
	"modified.png_key_magnified",
	"modified.png_key_print_ready"
];
*/
const OUTPUT_FILE = "output";

function showImage(event) {
	var target = event.target;
	var files = target.files;
	
	if (!(files.length > 0)) {
		return;
	}
	
	var selectedFile = files[0];
	var url = URL.createObjectURL(selectedFile);
	
	var image = $("#originalImg");
	image.attr("src", url);
	
	image.show();
}

function uploadAndEncryptImg() {
	//$("#result").html('');
	
	
	//loading('result');
	uploadAndEncryptImgServerCall();
}

function uploadAndEncryptImgServerCall(){
	var form = $('#imageUploadfrm')[0];		 	
    var formdata = new FormData(form);
        
	$.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: 'uploadAndEncryptImg',
        data: formdata,
        //timeout: 1000000,
        cache: false,
        contentType: false,
        processData: false,
		success: function(response) {
			// console.log("response :" + response);
			// response = 'images/'+response;
			// console.log("src :" + response);
	    	// $("#originalImg").attr("src",response);
	    	// document.getElementById("originalImg").src = 'images/input.png';
	    	//$('#result').html('<div style="text-align: center"><img alt="loading" src="/images/loading.gif" /></div>' );
	    	displayOutputImages();
	    	//$("#result").html('');
		},
		error: function(response) {
			alert("Error :" + response);
		}
    });
}

function displayOutputImages() {
	var target = $("#encryptImagesDisplay");
	
	target.html("");
	var count = 0;
	for (var imageName of ENCRYPTED_IMAGES) {
		count ++;
		var div = document.createElement("div");
		div.style.margin = '15px';
		
		var lbl = document.createElement("label");
		lbl.innerHTML='Share_'+count;
		
		var img = document.createElement("img");
		img.style.height = "100px";
		img.src = '/images/' + imageName + ".png";
		
		$(div).append(lbl);
		$(div).append(img);
		target.append(div);
	}
}

function decryptImage(){
	$.ajax({
		type: "POST",
		url: "decryptImg",
		contentType: "application/x-www-form-urlencoded",
		success: function(response) {
			//$('#result').html('<div style="text-align: center"><img alt="loading" src="/images/loading.gif" /></div>' );
			displayDecryptedImage();
			//$("#result").html('');
		},
		error: function(response) {
			alert("Error :" + response.data);
		}
	});
}

function displayDecryptedImage() {
	var target = $("#outputImagesDisplay");
	
	target.html("");
	
	var div = document.createElement("div");
	div.style.margin = '15px';
	
	var img = document.createElement("img");
	img.style.height = "100px";
	img.style.border = '2px solid';
	img.src = '/images/' + OUTPUT_FILE + ".png";
	
	var lbl = document.createElement("label");
	lbl.innerHTML='Decrypted Image';
	$(div).append(lbl);	
	$(div).append(img);
	target.append(div);
}