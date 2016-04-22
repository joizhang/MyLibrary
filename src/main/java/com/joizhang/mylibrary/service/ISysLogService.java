package com.joizhang.mylibrary.service;

/**
 * Created by Administrator on 2016/4/22.
 */
public interface ISysLogService {

    static final int CREATE = 1;
    static final int RETRIEVE = 2;
    static final int UPDATE = 3;
    static final int DELETE = 4;

    /**
     * 将保存
     *
     * @author joizhang
     * @param o 需要生成日志并保存的po对象
     * @param type 操作类型
     * */
    public void saveSysLog(Object o, int type);
}
