package com.sujan.break_o_last;

import com.sujan.break_o_last.bll.LoginBll;
import com.sujan.break_o_last.url.BaseUrl;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LoginTest {
    @Before
    public  void setUp(){
        BaseUrl.Base_Url ="http://127.0.1.1:3012/api/v1/";

    }
    @Test
    public void loginTest(){
        LoginBll loginBll = new LoginBll();
        loginBll.checkUser("9815040894","Sujan");
        assertThat(BaseUrl.Token,is(IsNull.notNullValue()));
        //assertEquals(expectedResult,actualResult);
    }
}
