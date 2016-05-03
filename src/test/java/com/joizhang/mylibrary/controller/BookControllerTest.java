package com.joizhang.mylibrary.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import com.joizhang.mylibrary.model.vo.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Administrator on 2016/4/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath*:/spring*.xml"})
//当然 你可以声明一个事务管理 每个单元测试都进行事务回滚 无论成功与否
//@TransactionConfiguration(defaultRollback = true)
//@Transactional
public class BookControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(BookControllerTest.class);

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void testAddBook() throws Exception {
        String book = "{\"bookName\":\"123\", \"description\":\"123\"}";
        mockMvc
                .perform(post("/book/addBook").contentType(MediaType.APPLICATION_JSON).content(book))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testAddBook1() throws Exception {
        mockMvc
                .perform((get("/book/addBook1")))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testLogin() throws Exception {
        mockMvc.perform((post("/book/loginTest").param("userName", "admin").param("password", "1")))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testBookList() throws Exception {
        String page = "{\"currentPage\":\"1\", \"itemsPerPages\":\"12\"}";
        String page2 = "[" +
                "{name:'currentPage',value:'1'}," +
                "{name:'itemsPerPages',value:'5'}" +
                "]";
        mockMvc.perform(post("/book/bookList").param("currentPage","1").param("itemsPerPages","5"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}