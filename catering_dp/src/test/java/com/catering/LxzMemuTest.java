package com.catering;

import com.catering.mapper.IndentMapperLxz;
import com.catering.mapper.MemberProfileMapperLxz;
import com.catering.mapper.MemuMapperLxz;
import com.catering.mapper.TagMapperLxz;
import com.catering.pojo.Memu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LxzMemuTest {
    @Autowired
    private MemuMapperLxz lxzMemuMapper;
    @Autowired
    private TagMapperLxz tagMapperLxz;
    @Autowired
    private IndentMapperLxz indentMapperLxz;
    @Autowired
    private MemberProfileMapperLxz memberProfileMapperLxz;
    @Test
    public void addMemu(){
        Memu memu=new Memu();
        memu.setDishId("zz");
        memu.setLabel("粤系");
        memu.setType(1);
        memu.setDishPrice(59.00);
        memu.setImg1("images/zz01.jpg");
        boolean bool=lxzMemuMapper.addMemu(memu);
        System.out.println(bool);
    }
    @Test
    public void findAllMemu(){
        System.out.println(lxzMemuMapper.findAllMemu());
    }
    @Test
    public void findCuisine(){
        System.out.println(tagMapperLxz.findCuisine());
    }
    @Test
    public void mechantId(){
        System.out.println(lxzMemuMapper.findAllMemu());
    }
   @Test
   public void findCount(){
       System.out.println(lxzMemuMapper.findCount());
   }
   @Test
    public void fingAllIndent(){
       System.out.println(indentMapperLxz.fingAllIndent());
   }
   @Test
    public void zz(){
       System.out.println(memberProfileMapperLxz.findMemberProfileById(1));
   }
   @Test
    public void findMemuByDid(){
       System.out.println(lxzMemuMapper.findMemuByDid(1));
   }
   @Test
    public void sumPrice(){
       System.out.println(lxzMemuMapper.sumPrice(1));
   }
   @Test
    public void findIndentByDid(){
       System.out.println(indentMapperLxz.findIndentByDid(1));
   }
}
