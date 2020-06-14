package com.example.java;


import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

/**
 * Created  on 2020/5/24.
 *
 * @author CPing
 * Email yy_cping@163.com
 * edit androidStudio
 */
public class Test {

    private static final String packageName ="com.dream.application.dao";
    private static final String path ="app/src/main/java";
    private static Schema schema;

    public static void main(String[] args) throws Exception {
        schema = new Schema(1,packageName);
        //添加所有实体
        addEntity();
        //调用DaoGenerator().generateAll方法自动生成代码到创建的目录下
        new DaoGenerator().generateAll(schema, path);
    }
    private static void addEntity()
    {
        //添加一个实体，自动生成实体Entity类
        Entity lawHead = schema.addEntity("LawHead");
        Entity lawHeadSecond = schema.addEntity("LawHeadSecond");
        Entity lawHeadThird = schema.addEntity("LawHeadThird");

        /* Account */
        lawHead.addLongProperty("id")
                .getProperty();
        lawHead.addStringProperty("title");



        lawHeadSecond.addLongProperty("id")
                .getProperty();
        lawHeadSecond.addStringProperty("headId");
        lawHeadSecond.addStringProperty("title");



        /* Moment */
        lawHeadThird.addLongProperty("id")
                .getProperty();
        lawHeadThird.addStringProperty("secondHeadId");
        lawHeadThird.addStringProperty("content");

    }

}
