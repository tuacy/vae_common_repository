package com.vae.wuyunxing.vae_repositories.file.filter;


import com.vae.wuyunxing.vae_repositories.file.FileInfo;
import com.vae.wuyunxing.vae_repositories.file.FileCategory;

/**
 * Get document file
 */
public class DocumentFilter implements FileFilter {

	@Override
	public boolean accept(FileInfo file) {
		return file.isDir() || file.category() == FileCategory.DOCUMENT;
	}
}
