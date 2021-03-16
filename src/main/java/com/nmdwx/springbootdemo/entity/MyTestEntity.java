package com.nmdwx.springbootdemo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @author: wangxiao
 * @date: 2021-03-12 16:06
 **/
@Document(indexName = "item", shards = 1, replicas = 0)
public class MyTestEntity {
    @Id
    private Long id;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String username;
    @Field(type = FieldType.Keyword)
    private Date createDate;

}
