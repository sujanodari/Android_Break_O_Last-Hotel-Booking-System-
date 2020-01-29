package com.sujan.break_o_last;

import com.sujan.break_o_last.bll.RegistrationBll;
import com.sujan.break_o_last.url.BaseUrl;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
public class RegistrationTest{
    @Before
    public  void setUp(){
        BaseUrl.Base_Url ="http://127.0.1.1:3012/api/v1/";

    }
    @Test
    public void registrationTest(){
        RegistrationBll registrationBll = new RegistrationBll();
        registrationBll.registerUser("Sujan Odari","98091000057","Gatthaghar","odarisujan12@gmail.com","Sujan","Sujan","male","sujan.jpeg");
        assertEquals("success",BaseUrl.Status);
    }
}