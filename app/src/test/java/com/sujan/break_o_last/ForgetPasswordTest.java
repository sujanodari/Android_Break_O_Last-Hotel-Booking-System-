package com.sujan.break_o_last;

import com.sujan.break_o_last.bll.ForgetPasswordBll;
import com.sujan.break_o_last.url.BaseUrl;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class ForgetPasswordTest {
    @Before
    public  void setUp(){
        BaseUrl.Base_Url ="http://127.0.1.1:3012/api/v1/";

    }
    @Test
    public void ForgetPasswordTest() {
        ForgetPasswordBll forgetPasswordBll = new ForgetPasswordBll();
        boolean res = forgetPasswordBll.forgetPassword("12341234", "Sujan123");
        assertTrue(res);

    }
}