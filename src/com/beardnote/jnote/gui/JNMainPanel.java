package com.beardnote.jnote.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.beardnote.jnote.gui.util.ComponentUtil;
import com.beardnote.jnote.gui.util.GUIUtil;

public class JNMainPanel extends JPanel {
	private JFrame frame = null;
	// 默认窗体大小
	private static final int DEFAULT_PANEL_WIDTH = 1000;
	private static final int DEFAULT_PANE_HEIGHT = 700;

	public JNMainPanel(GraphicsConfiguration gc) {
		_initFrame(gc);
		_initMenu();

	}

	/**
	 * 初始化窗体设置
	 * 
	 * @param gc
	 */
	private void _initFrame(GraphicsConfiguration gc) {
		frame = new JFrame(gc);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(100, 100));
		// frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 设置为最大化
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(DEFAULT_PANEL_WIDTH, DEFAULT_PANE_HEIGHT));
		frame.setTitle("jnote");
		
		ComponentUtil.setComponent("mainpanel", this);
		
		frame.getContentPane().add(this, BorderLayout.CENTER);
		frame.pack();
		GUIUtil.setFrameCenter(frame);
		JNStatusPanel.setStatusMessage("初始化完毕！");
		new JNTray(frame);
	}

	private void _initMenu() {
		// menu pan
		// JNMenuBar menuBar = new JNMenuBar(this);
		// frame.setJMenuBar(menuBar.getMenuBar());

		// toolbar 
		JNToolBar toolBarPanel = new JNToolBar();
		add(toolBarPanel.getToolbar(), BorderLayout.NORTH);

		// // container panel
		JNContainerPanel containerPanel = new JNContainerPanel(this);
		add(containerPanel.getContainerPanel(), BorderLayout.CENTER);

		// status panel
		JNStatusPanel statusPanel = new JNStatusPanel(this);
		add(statusPanel.getStatusPanel(), BorderLayout.SOUTH);
		_showFrame();// 显示窗体
		containerPanel.setDividerLocation();

	}

	/**
	 * 显示窗体
	 */
	private void _showFrame() {
		getFrame().setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

}
