package com.vae.wuyunxing.vae_repositories.widget.view.edittext;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

public class DivisionEditText extends EditText {

	private Integer mEachLength = 4;
	/**
	 * the separator
	 */
	private String  mDelimiter  = " ";

	public DivisionEditText(Context context) {
		super(context);
		init();
	}

	public DivisionEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();

	}

	public DivisionEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	/**
	 * init listener
	 */
	public void init() {

		/** listener the content */
		this.addTextChangedListener(new DivisionTextWatcher());
		/** focus listener */
		this.setOnFocusChangeListener(new DivisionFocusChangeListener());
	}

	/**
	 * Text listener
	 *
	 * @author Administrator
	 */
	private class DivisionTextWatcher implements TextWatcher {

		@Override
		public void afterTextChanged(Editable s) {
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			/** get count */
			int len = s.length();
			if (len < mEachLength) {
				return;
			}
			if (count > 1) {
				return;
			}
			/** clean space */
			char[] chars = s.toString().replace(" ", "").toCharArray();
			len = chars.length;
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < len; i++) {
				if (i % mEachLength == 0 && i != 0)
				{
					sb.append(mDelimiter);
					sb.append(chars[i]); /** add char */
				} else {
					sb.append(chars[i]); /** add char */
				}
			}
			String text = sb.toString();
			setText(text);
			setSelection(text.length());
		}
	}

	/**
	 * get focus listener
	 *
	 * @author Administrator
	 */
	private class DivisionFocusChangeListener implements OnFocusChangeListener {

		@Override
		public void onFocusChange(View v, boolean hasFocus) {
			if (hasFocus) {
				/** set focus */
				setSelection(getText().toString().length());
			}
		}
	}

	/**
	 * get each group length
	 */
	public Integer getmEachLength() {
		return mEachLength;
	}

	/**
	 * set each group length
	 */
	public void setmEachLength(Integer mEachLength) {
		this.mEachLength = mEachLength;
	}

	/**
	 * get division char
	 */
	public String getmDelimiter() {
		return mDelimiter;
	}

	/**
	 * set division char
	 */
	public void setmDelimiter(String mDelimiter) {
		this.mDelimiter = mDelimiter;
	}
}
