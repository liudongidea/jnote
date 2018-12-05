package com.beardnote.jnote.gui.listener;

import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import com.beardnote.jnote.bean.Category;
import com.beardnote.jnote.dao.CategoryDao;
import com.beardnote.jnote.gui.common.JNConstans;
import com.beardnote.jnote.gui.core.tree.CategoryNode;
import com.beardnote.jnote.gui.core.tree.CustomMutableTreeNode;
import com.beardnote.jnote.gui.util.ComponentUtil;

public class JNCategoryTreeListener implements TreeSelectionListener, TreeModelListener {

	/**
	 * 选择节点改变
	 */
	@Override
	public void valueChanged(TreeSelectionEvent e) {

		JTree jtree = (JTree) ComponentUtil.getComponent("categoryTree");
		CustomMutableTreeNode defaultNode = (CustomMutableTreeNode) jtree.getLastSelectedPathComponent();
		if (defaultNode == null) {
			return;
		}
		if (defaultNode != null) {
			CategoryNode cnode = (CategoryNode) defaultNode.getCusObject();
			int cid = -1;
			if(cnode!=null){
				cid = cnode.getId();
			}
			JNConstans.CUR_SELECT_CATEGORY_ID = cid;
			new JNNoteTableListener().getNoteTable();
			if (defaultNode.isRoot()) {
			} else {
				if (defaultNode.isLeaf()) {
				} else {

				}
			}
		}
	}

	/**
	 * 修改节点名称
	 */
	@Override
	public void treeNodesChanged(TreeModelEvent e) {
		TreePath treePath = e.getTreePath();
		CustomMutableTreeNode node = (CustomMutableTreeNode) treePath.getLastPathComponent();

		if (node.isRoot()) {
			return;
		}

		try {
			int[] index = e.getChildIndices();
			node = (CustomMutableTreeNode) node.getChildAt(index[0]);

			String newName = node.getUserObject() + "";
			CategoryNode updateCategoryNode = (CategoryNode) node.getCusObject();
			Category category = new Category(updateCategoryNode.getId(), newName, updateCategoryNode.getParentId());
			category = new CategoryDao().update(category);
			System.out.println(category.toString());
		} catch (NullPointerException exc) {
			exc.printStackTrace();
		}

	}

	@Override
	public void treeNodesInserted(TreeModelEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void treeNodesRemoved(TreeModelEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void treeStructureChanged(TreeModelEvent e) {
		// TODO Auto-generated method stub

	}

}
