# cordova-plugin-canvas-to-image-file
cordova plugin to save html5 canvas to image file (.png/.jpg) from your cordova android app

### Tested on:

- NodeJS  	      : 19.4.0
- Cordova 	      : 11.1.0
- cordova-android : 11.0 
- Java 11  

### How to use

install from github repository using this command
```
cordova plugin add https://github.com/tauhidcp/cordova-plugin-canvas-to-image-file.git
```
or install from npmjs package using this command 
```
cordova plugin add id.my.tauhidslab.canvas2imagefile
```

uninstall using this command
```
cordova plugin rm id.my.tauhidslab.canvas2imagefile
```

### Save HTML5 Canvas to Image File 

use example code below to save HTML5 Canvas to Image File (.png/.jpg) from your cordova android app  

``` 
function saveImg(){
	
	var canvas = document.getElementById('canvas'); // html5 canvas element
	var name = "myCanvas_"+Math.floor(Math.random() * 1000000)+".png"; // save to png or jpg
	var dest = "/storage/emulated/0/Download/"; // destination folder on android device 
	//var dest = "/storage/emulated/0/Pictures/";
	
	cordova.plugins.Canvas2ImageFile.save2ImageFile(name, canvas, dest, onSuccess, onError);
	
	function onSuccess(s){
		
		alert("Saved to "+s);
		
	}
	
	function onError(e){
	 
		alert(e);
  		
	}
	
}
```
