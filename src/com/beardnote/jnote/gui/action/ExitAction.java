package com.beardnote.jnote.gui.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.beardnote.jnote.gui.JNMainPanel;

/**
 * 退出程序
 * 
 * @author Administrator
 * 
 */
public class ExitAction extends AbstractAction {
	JNMainPanel mainPanel;

	public ExitAction(JNMainPanel mainPanel) {
		super("ExitAction");
		this.mainPanel = mainPanel;
	}

	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
