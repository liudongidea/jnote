package com.beardnote.jnote.common;

import java.io.File;

import jodd.util.SystemUtil;

public class DbFile {

    public static String getDbfilepath() {
        return SystemUtil.getWorkingFolder() + File.separator + "db" + File.separator + "jnote.db";
    }

}
