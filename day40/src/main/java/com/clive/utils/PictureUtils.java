package com.clive.utils;

import java.util.UUID;

public class PictureUtils {
	public static String getImageNmae(String pictureName) {
		String string = UUID.randomUUID().toString();
		String startName = string.replace("-","");
		String endName = pictureName.substring(pictureName.lastIndexOf("."));

		return startName+endName;

	}
}
