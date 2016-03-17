package com.example.emojichatdemo;

import org.kymjs.chat.ChatActivity;
import org.kymjs.kjframe.KJActivity;

import com.rockerhieu.emojicon.EmojiconEditText;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends KJActivity {

	@Override
	public void setRootView() {
		setContentView(R.layout.activity_main);
		showActivity(aty, ChatActivity.class);
	}

}
