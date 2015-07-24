package com.vae.wuyunxing.vae_repositories.file.utils;

import java.text.DecimalFormat;

public class FileSizeConvertUtils {

	private final static long SIZE_B = 1024L;
	private final static long SIZE_K = 1048576L;
	private final static long SIZE_M = 1073741824L;
	private final static long SIZE_G = 1099511627776L;

	/**
	 * byte to (K, M, G, T)
	 * @param filebyte: file byte
	 * @return
	 */
	public static String formatFileSizeUnit(long filebyte) {
		DecimalFormat df = new DecimalFormat("#.00");
		String fileSizeString = "";
		if (filebyte < SIZE_B) {
			fileSizeString = df.format((double) filebyte) + "B";
		} else if (filebyte < SIZE_K) {
			fileSizeString = df.format((double) filebyte / SIZE_B) + "K";
		} else if (filebyte < SIZE_M) {
			fileSizeString = df.format((double) filebyte / SIZE_K) + "M";
		} else if (filebyte < SIZE_G){
			fileSizeString = df.format((double) filebyte / SIZE_M) + "G";
		} else {
			fileSizeString = df.format((double) filebyte / SIZE_G) + "T";
		}
		return fileSizeString;
	}
}
