package com.vae.wuyunxing.vae_repositories.swipebacklayout.mobile;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

import com.vae.wuyunxing.vae_repositories.log.MKLog;
import com.vae.wuyunxing.vae_repositories.swipebacklayout.SwipeBackActivity;

public class MobileBaseActivity extends SwipeBackActivity {

	private static final String TITLE_VIEW_TAG = "base_title_view";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onBackPressed() {
		scrollToFinishActivity();
	}

	protected void replaceFragment(int layoutId, Class<? extends Fragment> clz) {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		try {
			Fragment f;
			if ((f = fm.findFragmentByTag(clz.getName())) == null) {
				f = clz.newInstance();
			}
			ft.replace(layoutId, f, clz.getName()).show(f).commit();
		} catch (Exception e) {
			MKLog.e(MobileBaseActivity.class, e, "Cannot get new instance of %s . Throw: %s. Message: %s", clz.getName(), e,
					e.getMessage());
		}
	}

	protected void replaceFragment(int layoutId, Class<? extends Fragment> clz, Bundle args) {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		try {
			Fragment f;
			if ((f = fm.findFragmentByTag(clz.getName())) == null) {
				f = clz.newInstance();
			}
			f.setArguments(args);
			ft.replace(layoutId, f, clz.getName()).show(f).commit();
		} catch (Exception e) {
			MKLog.e(MobileBaseActivity.class, e, "Cannot get new instance of %s . Throw: %s. Message: %s", clz.getName(), e,
					e.getMessage());
		}
	}

	protected void addFragment(int layoutId, Class<? extends Fragment> clz) {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		try {
			Fragment f = clz.newInstance();
			ft.add(layoutId, f, clz.getName()).show(f).commit();
		} catch (Exception e) {
			MKLog.e(MobileBaseActivity.class, e, "Cannot get new instance of %s . Throw: %s. Message: %s", clz.getName(), e,
					e.getMessage());
		}
	}

	protected void addFragment(int layoutId, Class<? extends Fragment> clz, int enterAnim, int exitAnim) {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		try {
			Fragment f = clz.newInstance();
			ft.add(layoutId, f, clz.getName()).setCustomAnimations(enterAnim, exitAnim).show(f).commit();
		} catch (Exception e) {
			MKLog.e(MobileBaseActivity.class, e, "Cannot get new instance of %s . Throw: %s. Message: %s", clz.getName(), e,
					e.getMessage());
		}
	}

	protected void removeFragment(int layoutId, Class<? extends Fragment> clz) {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		Fragment f = fm.findFragmentByTag(clz.getName());
		if (f != null) {
			ft.remove(f).commit();
		}
	}


	/**
	 * toast
	 */
	public void toasts(int strId) {
		Toast.makeText(MobileBaseActivity.this, strId, Toast.LENGTH_SHORT).show();
	}

	public void toasts(int strId, int duration) {
		Toast.makeText(MobileBaseActivity.this, strId, duration).show();
	}

	public void toasts(String str) {
		Toast.makeText(MobileBaseActivity.this, str, Toast.LENGTH_SHORT).show();
	}

	public void toasts(String str, int duration) {
		Toast.makeText(MobileBaseActivity.this, str, duration).show();
	}

}
