package com.beardnote.jnote.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;

import jodd.util.SystemUtil;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

import com.beardnote.jnote.gui.common.JNConstans;
import com.beardnote.jnote.gui.core.CloseTabPanel;
import com.beardnote.jnote.gui.util.ComponentUtil;

public class JNTodoBtnActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JTabbedPane tabbedPane = (JTabbedPane) ComponentUtil
				.getComponent("tabbedPane");
		JNConstans.CUR_SELECT_UUID = "jntodo";
		int index = JNTabListener.isOpenTab("jntodo");
		if (index < 0) {
			CloseTabPanel closeTabPanel = new CloseTabPanel("jntodo",
					tabbedPane);
			tabbedPane.addTab("jntodo", getMarkdownEditor());
			int size = tabbedPane.getTabCount() - 1;
			tabbedPane.setSelectedIndex(size);
			tabbedPane.setTabComponentAt(size, closeTabPanel);
			JNConstans.CUR_SELECT_TAB_INDEX = size;
			JNTabListener.addTab("jntodo");
		} else {
			tabbedPane.setSelectedIndex(index);
			JNConstans.CUR_SELECT_TAB_INDEX = index;
		}

	}

	public JComponent getMarkdownEditor() {

		final JWebBrowser webBrowser = new JWebBrowser();
		webBrowser.setBarsVisible(false);
		webBrowser.setStatusBarVisible(false);
		webBrowser.setBorder(BorderFactory.createEmptyBorder());
		try {
			String pagedownPath = SystemUtil.getWorkingFolder() + "/todo";
			webBrowser.navigate(pagedownPath + "/index.html");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return webBrowser;
	}

}
