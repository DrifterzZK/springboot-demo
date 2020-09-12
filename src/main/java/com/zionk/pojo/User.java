package com.zionk.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
//在编译阶段会根据注解自动生成对应的方法：data包含get/set/hashcode/tostring等方法
@Data
@Table(name = "tb_user")
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)//主键回填
    private Long id;

    //@Column(name = "abc")类属性与数据库字段名一致或驼峰命名，此注解可不写！！！
    //user_name-->userName驼峰命名
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private Integer sex;
    private Date birthday;
    private String note;
    private Date created;
    private Date updated;
}
