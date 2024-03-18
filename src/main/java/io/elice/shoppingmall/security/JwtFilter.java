package io.elice.shoppingmall.security;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    private final JwtProvider jwtProvider;

    private AuthenticationManager authenticationManager;

    @PostConstruct
    public void init() {
        this.authenticationManager = new ProviderManager(jwtProvider);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return Arrays.stream(jwtUtil.allowedUrls).anyMatch(item -> item.equalsIgnoreCase(request.getServletPath())); // true면 fileter 안 탐
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            //access 유효성
            String token = jwtUtil.extractJwtFromRequest(request);

            if (token != null && jwtUtil.validateToken(token)) {
                MyTokenAuthentication authenticateRequest = new MyTokenAuthentication(token);
                Authentication authenticationResult = authenticationManager.authenticate(authenticateRequest);

                if (!authenticateRequest.isAuthenticated()) {
                    throw new BadCredentialsException("인증이 실패하였습니다.");
                }
                SecurityContextHolder.getContext().setAuthentication(authenticationResult);
            }

        } catch (ExpiredJwtException e) {
            SecurityContextHolder.clearContext();

            response.sendError(401, e.getMessage());
            return;
        }catch (Exception e) {
            SecurityContextHolder.clearContext();

            response.setStatus(400);
            return;
        }


        filterChain.doFilter(request, response);
    }
}