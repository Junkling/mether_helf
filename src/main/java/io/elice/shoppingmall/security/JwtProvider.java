package io.elice.shoppingmall.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@Slf4j
@RequiredArgsConstructor
public class JwtProvider implements AuthenticationProvider {
    private final JwtUtil tokenService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.debug("y토큰 인증을 수행합니다.");
        if (supports(authentication.getClass())) {
            MyTokenPayload verified = tokenService.verify(((MyTokenAuthentication) authentication).getToken());
            authentication.setAuthenticated(true);
            ((MyTokenAuthentication) authentication).setPayload(verified);
            return authentication;
        } else {
            throw new BadCredentialsException("지원하지 않는 인증입니다.");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return MyTokenAuthentication.class.equals(authentication);
    }
}