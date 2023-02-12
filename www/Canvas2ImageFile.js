var exec = require('cordova/exec');

exports.save2ImageFile = function (imgname, canvas, dest, success, error) {
	
	var extension = "."+imgname.split('.').pop();
	var imageData = canvas.toDataURL().replace(/data:image\/png;base64,/,'');
	var param = [imageData, extension, imgname, dest];
	
    exec(success, error, 'Canvas2ImageFile', 'save2ImageFile', param);
};
