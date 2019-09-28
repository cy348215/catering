package com.catering;

import com.catering.mapper.PermissionMapper;
import com.catering.pojo.StorePermission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CateringDpApplicationTests {
    @Autowired
    private PermissionMapper permissionMapper;
   /* @Test
    public void contextLoads() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<StorePermission> permissions = permissionMapper.findByid(list);
        System.out.println(permissions);
    }*/

}
