package com.vvvtimes.handler;

import org.eclipse.jetty.server.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class IndexHandler {
    public static void indexHandler(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);

        // 拼接服务器地址
        String licenseUrl = request.getScheme() + "://" + request.getServerName();

        StringBuffer html = new StringBuffer();
        html.append("<h1>Hello，此地址是 Jrebel & JetBrains License Server!</h1>");
        html.append("<p>JetBrains许可服务器激活地址 ").append(licenseUrl);
        html.append("<p>JetBrains激活地址是: <span style='color:red'>").append(licenseUrl).append("/");
        html.append("<p>JRebel 7.1 及旧版本激活地址: <span style='color:red'>")
                .append(licenseUrl).append("/{tokenname}")
                .append("</span>, 以及任意邮箱地址。");
        html.append("<p>JRebel 2018.1+ 版本激活地址: ")
                .append(licenseUrl).append("/{guid}")
                .append("(例如：<span style='color:red'>")
                .append(licenseUrl).append("/").append(UUID.randomUUID().toString())
                .append("</span>), 以及任意邮箱地址。");
        html.append("<h3>欢迎访问涛哥博客主站：<a style='color:red' href='https://www.ltbk.net'>https://www.ltbk.net</a></h3>");
        response.getWriter().println(html);
    }
}