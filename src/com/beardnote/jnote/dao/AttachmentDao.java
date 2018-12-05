package com.beardnote.jnote.dao;

import java.util.ArrayList;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;

import com.beardnote.jnote.bean.Attachment;
import com.beardnote.jnote.common.DBFactory;

public class AttachmentDao {
	static Dao dao = new NutDao(DBFactory.getDataSource());

	public static void create() {
		dao.create(Attachment.class, true);
	}

	public static List<Attachment> get(String uuid) {
		List<Attachment> list = dao.query(Attachment.class,
				Cnd.where("noteUuid", "=", uuid));
		return list;
	}

	public static void save(List<Attachment> list) {
		String uuid = list.get(0).getNoteUuid();
		dao.clear(Attachment.class, Cnd.where("noteUuid", "=", uuid));
		dao.insert(list);
	}

}
