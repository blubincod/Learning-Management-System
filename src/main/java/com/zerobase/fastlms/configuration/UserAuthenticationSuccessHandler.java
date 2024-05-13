package com.zerobase.fastlms.configuration;

import com.zerobase.fastlms.member.entity.LoginHistory;
import com.zerobase.fastlms.member.repository.LoginHistoryRepository;
import com.zerobase.fastlms.member.repository.MemberRepository;
import com.zerobase.fastlms.member.service.MemberService;
import com.zerobase.fastlms.util.RequestUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class UserAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final LoginHistoryRepository loginHistoryRepository;
    private final MemberRepository memberRepository;
    private final MemberService memberService;

    public UserAuthenticationSuccessHandler(LoginHistoryRepository loginHistoryRepository, MemberRepository memberRepository, MemberService memberService) {
        this.loginHistoryRepository = loginHistoryRepository;
        this.memberRepository = memberRepository;
        this.memberService = memberService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) principal;


        System.out.println("로그인에 성공하였습니다.");

        String userId = userDetails.getUsername();
        String clientIp = RequestUtils.getClientIp(request);
        String userAgent = RequestUtils.getUserAgent(request);
        LocalDateTime currentTime = LocalDateTime.now();

        LoginHistory loginHistory = LoginHistory.builder()
                .userId(userId)
                .loginDate(currentTime)
                .clientIp(clientIp)
                .userAgent(userAgent)
                .build();
        loginHistoryRepository.save(loginHistory);

        memberService.updateLastLogin(userId, currentTime);

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
