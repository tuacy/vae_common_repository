package com.vae.wuyunxing.vae_repositories.file.filter;

import com.vae.wuyunxing.vae_repositories.file.FileInfo;

/**
 * File filter interface
 */
public interface FileFilter {

    public boolean accept(FileInfo file);
    
}
