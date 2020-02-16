package com.sujan.break_o_last;

import com.sujan.break_o_last.bll.UpdatePasswordBll;
import com.sujan.break_o_last.url.BaseUrl;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class UpdatePasswordTest {
    @Before
    public  void setUp(){
        BaseUrl.Base_Url ="http://127.0.1.1:3012/api/v1/";

    }
    @Test
    public void loginTest(){
        UpdatePasswordBll updatePasswordBll = new UpdatePasswordBll();
        boolean res=updatePasswordBll.updatePassword("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Ijk4MTIzNDEyMzQiLCJ1c2VybGV2ZWwiOiJzdXBlcmFkbWluIiwiaWF0IjoxNTgxODQzMTc1LCJleHAiOjE1ODE4NzkxNzV9.FsVpATYex5oQUZLP3hb59KcbOiJseI3h46Q1TWaGDOY","Sujan123");
        assertTrue(res);

    }
}
