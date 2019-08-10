package com.sculpture.sand.zheng.nie.ai.spi;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: niezheng1
 * @Date: 2019/8/1 15:29
 */
public class EsTest {

    @Test
    public void test1(){
        UserBase lables = new UserBase();
        lables.setOpdataBaseSex(1);
        List<Integer> opdataBaseAge = new ArrayList<>();
        opdataBaseAge.add(2);
        opdataBaseAge.add(3);
        lables.setOpdataBaseAge(opdataBaseAge);
        List<Integer> opdataBaseProvince = new ArrayList<>();
        opdataBaseProvince.add(1);
        opdataBaseProvince.add(2);
        lables.setOpdataBaseProvince(opdataBaseProvince);
        List<Integer> opdataBaseCity = new ArrayList<>();
        opdataBaseCity.add(5);
        opdataBaseCity.add(6);
        opdataBaseCity.add(7);
        lables.setOpdataBaseCity(opdataBaseCity);
        System.out.println(JSON.toJSONString(lables));
    }

    @Test
    public void test2(){
        String s = "{\"opdataBaseAge\":[2,3],\"opdataBaseCity\":[5,6,7],\"opdataBaseProvince\":[1,2],\"opdataBaseSex\":1}";
        System.out.println("========="+s.length());
        UserBase lables = JSON.parseObject(s, UserBase.class);
        System.out.println(lables);
        Integer opdataBaseSex = lables.getOpdataBaseSex();
        BoolQueryBuilder builder = QueryBuilders.boolQuery();

        BoolQueryBuilderExtend boolQuery = new BoolQueryBuilderExtend();
        builder.must(boolQuery);
        boolQuery.setGroup("test");
        //BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        if(opdataBaseSex != null && !"".equals(opdataBaseSex)){
            boolQuery.must(QueryBuilders.termQuery("opdata_base_sex",opdataBaseSex));
        }
        if(lables.getOpdataBaseAge() != null){
            boolQuery.must(QueryBuilders.termsQuery("opdata_base_age",lables.getOpdataBaseAge()));
        }
        if(lables.getOpdataBaseProvince() != null){
            boolQuery.must(QueryBuilders.termsQuery("opdata_base_province",lables.getOpdataBaseProvince()));
        }
        if(lables.getOpdataBaseCity() != null){
            boolQuery.must(QueryBuilders.termsQuery("opdata_base_city",lables.getOpdataBaseCity()));
        }
        BoolQueryBuilderExtend boolQuery1 = new BoolQueryBuilderExtend();
        boolQuery1.setGroup("tetst1");
        boolQuery1.must(QueryBuilders.termQuery("agggg",111));
        builder.must(boolQuery1);
        String s1 = builder.toString();
        System.out.println(s1);
        System.out.println(s1.length());
        String s3 = s1.replaceAll(" ", "");
        String s4 = s3.replaceAll("\n", "");
        System.out.println("s4======"+s4);


    }

}
