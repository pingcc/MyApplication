package com.example.java;

import java.util.HashMap;

/**
 * Created  on 2019/10/14.
 *
 * @author CPing
 * Email yy_cping@163.com
 * edit androidStudio
 */
public class TestDateJava {

    public static void main(String[] args) {
          String sql = "INSERT INTO `base`.`base_department`(`department_code`, `department_name`, `department_full_name`,  `department_level`, `ou_id`, `parent_department_id`, `date_from`, `date_to`, `enable_flag`, `biz_line_type`, `channel`, `department_type`,`inventory_enable` ,`creation_date`, `created_by`, `last_update_date`, `last_updated_by`, `last_update_login`, `delete_flag`, `version_num`) \n" +
                "values ([departmentCode],[departmentName],[departmentFullName],[departmentLevel],261,[parentDepartmentId],\n" +
                "DATE_FORMAT(NOW(),'%Y-%m-%d'),'2099-12-31','Y',20,10,[departmentType],'N',NOW()[createBy],NOW(),[lastUpdatedBy],NOW(),0,0);";
        HashMap<String, String> map = new HashMap();
        map.put("departmentId", 1024 + "");
        map.put("departmentCode", 102411 + "");
        map.put("departmentLevel", 1+"");
        map.put("parentDepartmentId", 1021+"");
        map.put("departmentName", "'广州露乐集团'");
        map.put("departmentFullName", "'广州露乐集团'");
        map.put("departmentType", 20+"");
        map.put("createBy", 1+"");
        map.put("lastUpdatedBy", 1+"");
        for (String key : map.keySet()) {
            String str = "\\[" + key + "]";

            sql = sql.replaceAll(str, map.get(key));
        }
        System.out.println(sql+"one");
    }


}
