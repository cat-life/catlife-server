package com.catlife.controller;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

/**
 * Created by Wholanz on 2017/10/29.
 */
@Path("/")
public class TestController {
    @Get("test")
    public String test() {
        return "@HelloWorld!";
    }
}
