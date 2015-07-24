package com.vae.wuyunxing.vae_repositories.file.filter;


import com.vae.wuyunxing.vae_repositories.file.FileInfo;
import com.vae.wuyunxing.vae_repositories.file.FileCategory;

/**
 * Get video file
 */
public class VideoFilter implements FileFilter {

	@Override
	public boolean accept(FileInfo file) {
		return file.isDir() || file.category() == FileCategory.VIDEO;
	}
}
