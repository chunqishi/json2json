package org.lappsgrid.json2json;


import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.lappsgrid.json2json.jsonpath.JayWayJsonPath;

import java.io.File;

public class Json2JsonTest {
    JayWayJsonPath j2j = null;
    String json = null;
    long begin, end;

    @Before
    public void setup() throws Exception{
        File objFile = new File(Json2JsonTest.class.getResource("/obj.json").toURI());
        json = FileUtils.readFileToString(objFile);
        System.out.println("JSON length = " + json.length());
    }

    @After
    public void tear() {}

    @Test
    public void testTime() throws Exception{
        ////////////////////////////////////////////////////////
        begin = System.currentTimeMillis();
        j2j = new JayWayJsonPath();
        for(int i = 0; i < 100; i++) {
            String target = j2j.path(json, "$.Items.Item[2].ItemLinks");
//            System.out.println(target);
        }
        end = System.currentTimeMillis();
        System.out.print(JayWayJsonPath.class.getSimpleName() + "\t");
        System.out.println(end - begin);
        System.out.println();

        System.out.println(j2j.path(json, "$.@.xmlns"));
        ////////////////////////////////////////////////////////
//        begin = System.currentTimeMillis();
//        j2j = new Json2JsonNebhale();
//        for(int i = 0; i < 100; i++)
//            j2j.path(json, "$.Items.Item[2].ItemLinks");
//        end = System.currentTimeMillis();
//        System.out.print(Json2JsonNebhale.class.getSimpleName() + "\t");
//        System.out.println(end - begin);
//        System.out.println();
        ////////////////////////////////////////////////////////

    }
    
}