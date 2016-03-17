package com.example.emojicondemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.rockerhieu.emojicon.EmojiconEditText;
import com.rockerhieu.emojicon.EmojiconGridFragment.OnEmojiconClickedListener;
import com.rockerhieu.emojicon.EmojiconTextView;
import com.rockerhieu.emojicon.EmojiconsFragment;
import com.rockerhieu.emojicon.EmojiconsFragment.OnEmojiconBackspaceClickedListener;
import com.rockerhieu.emojicon.emoji.Emojicon;

@SuppressLint("NewApi")
public class MainActivity extends FragmentActivity implements
		OnEmojiconClickedListener, OnEmojiconBackspaceClickedListener {

	EmojiconEditText mEditEmojicon;
	EmojiconTextView mTxtEmojicon;
	CheckBox mCheckBox;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mEditEmojicon = (EmojiconEditText) findViewById(R.id.editEmojicon);
		mTxtEmojicon = (EmojiconTextView) findViewById(R.id.txtEmojicon);
		mCheckBox = (CheckBox) findViewById(R.id.use_system_default);
		mEditEmojicon.addTextChangedListener(new TextWatcherAdapter() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				mTxtEmojicon.setText(s);
			}

		});
		mCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean b) {
				mEditEmojicon.setUseSystemDefault(b);
				mTxtEmojicon.setUseSystemDefault(b);
				setEmojiconFragment(b);
			}
		});
		setEmojiconFragment(false);
	}

	private void setEmojiconFragment(boolean useSystemDefault) {
		getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.emojicons,
						EmojiconsFragment.newInstance(useSystemDefault))
				.commit();
	}

	@Override
	public void onEmojiconClicked(Emojicon emojicon) {
		EmojiconsFragment.input(mEditEmojicon, emojicon);
	}

	@Override
	public void onEmojiconBackspaceClicked(View v) {
		EmojiconsFragment.backspace(mEditEmojicon);
	}
}
