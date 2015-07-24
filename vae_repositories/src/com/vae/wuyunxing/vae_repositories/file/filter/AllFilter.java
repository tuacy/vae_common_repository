package com.vae.wuyunxing.vae_repositories.file.filter;

import com.vae.wuyunxing.vae_repositories.file.FileInfo;

/**
 * all filter get all file
 */
public class AllFilter implements FileFilter {

	@Override
	public boolean accept(FileInfo file) {
		return true;
	}
}
