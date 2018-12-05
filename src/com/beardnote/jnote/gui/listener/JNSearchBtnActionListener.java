package com.beardnote.jnote.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JNSearchBtnActionListener  implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		new JNNoteTableListener().getSearchNoteTable();
	}

}
