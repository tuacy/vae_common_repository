package com.vae.wuyunxing.vae_repositories.file;

import java.util.Calendar;

public interface FileInfo {

	public String getName();

	public String getPath();

	public String getParent();

	public boolean isDir();

	public boolean isFile();

	public Calendar createTime();

	public Calendar lastModified();

	public long size();

	public boolean canRead();

	public boolean canWrite();

	public boolean exists();

    public String suffix();
    
    public FileCategory category();

}
