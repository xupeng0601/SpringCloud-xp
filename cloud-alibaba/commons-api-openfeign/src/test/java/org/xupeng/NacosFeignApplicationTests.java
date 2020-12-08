package org.xupeng;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NacosFeignApplicationTests {

    @Test(timeout = 10)
    public void contextLoads() {
    }


/*    public static void main(String[] args) {

        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();

//更具以上有关泛型的描述，我们可以思考一下这两个对象的class对象是否一致？
        System.out.println(l1.getClass() == l2.getClass());// 答案为true

    }*/

}
