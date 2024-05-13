package com.zerobase.fastlms.util;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class RequestUtils {
    public static String getUserAgent(HttpServletRequest req) {
        String ip = req.getHeader("User-Agent");
        return ip;
    }

    public static String getClientIp(HttpServletRequest req) throws UnknownHostException {
        String ip = req.getHeader("X-FORWARDED-FOR");

        if (ip == null) {
            ip = req.getHeader("Proxy-Client-IP");
        }

        if (ip == null) {
            ip = req.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null) {
            ip = req.getHeader("HTTP_CLIENT_IP");
        }

        if (ip == null) {
            ip = req.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (ip == null) {
            ip = req.getRemoteAddr();
        }

        if (ip.equals("0:0:0:0:0:0:0:1") || ip.equals("127.0.0.1")) {
            InetAddress address = InetAddress.getLocalHost();
            ip = address.getHostAddress();
        }

        return ip;
    }
}
