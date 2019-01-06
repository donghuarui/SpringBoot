package com.dhr.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.naming.Name;
import java.util.Date;

/**
 * @author Administrator
 * User实体
 */
@Data
public class User {
    private String id;
    private String username;
    private String password;
    private Date create_time;
    private Date update_time;
    private Character valid;
    private String creator_id;
    private String updater_id;
}
