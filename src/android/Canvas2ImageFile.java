package id.my.tauhidslab.canvas2imagefile;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;

/**
 * 
 * This class is adapted from https://github.com/liuxiaoy/cordova-plugin-canvas-to-image
 * Modified by. Ahmad Tauhid (http://www.tauhidslab.my.id/)
 * to Implemented in https://github.com/tauhidcp/cordova-plugin-canvas-to-image-file.git
 *
 **/
 
public class Canvas2ImageFile extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		
        if (action.equals("save2ImageFile")) {
			
            String base64     = args.getString(0);
			String extension  = args.getString(1);
			String imgname    = args.getString(2);
			String dest 	  = args.getString(3);;
			String destFolder = dest+imgname;
			
			if (base64.equals("")) callbackContext.error("empty base64 string!");
			
			byte[] decodedString = Base64.decode(base64, Base64.DEFAULT);
			Bitmap bmp = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
			if (bmp == null) {
				callbackContext.error("failed! could not decoded base64 image");
			
			} else {

				File imageFile = save2ImageFile(bmp, extension, destFolder);
				
				if (imageFile == null){
				
					callbackContext.error("error saving canvas to image!");
				
				} else {

				callbackContext.success(imageFile.toString());
				
				}
			}
			
			return true;
        }
        return false;
    }

	private File save2ImageFile(Bitmap bmp, String extension, String destFolder){
		
		File imgVal = null;
		
		try {
			
			File imageFile = new File(destFolder);
			CompressFormat compressFormat=(extension.equals(".jpg")) ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
			FileOutputStream out = new FileOutputStream(imageFile);
			bmp.compress(compressFormat, 100, out);
			out.flush();
			out.close();

			imgVal = imageFile;
			
		} catch(Exception e){ }
		
		return imgVal;
	}
}

