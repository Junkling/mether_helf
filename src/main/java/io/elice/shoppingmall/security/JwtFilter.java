package io.elice.shoppingmall.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        return Arrays.stream(jwtUtil.allowedUrls).anyMatch(item -> path.startsWith(item) && !path.equals("/project")); // true면 fileter 안 탐
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException,IOException {
        try {
            //access 유효성
            String jwt = jwtUtil.extractJwtFromRequest(request);

            if (jwt != null && jwtUtil.validateToken(jwt)) {

                String userId = jwtUtil.extractUsername(jwt);

                if(!jwtUtil.isAccess(jwt)) {
                    response.setStatus(418);
                } else{
                    Authentication authentication = new UsernamePasswordAuthenticationToken(
                        Integer.parseInt(userId), null, null); // You might need to implement your own UserDetails here.

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (Exception e) {
            response.setStatus(401);
        }

        filterChain.doFilter(request, response);
    }
}