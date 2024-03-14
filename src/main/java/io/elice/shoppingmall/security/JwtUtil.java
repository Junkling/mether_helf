package io.elice.shoppingmall.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;
    private SecretKey secretKey;
    public final String[] allowedUrls = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            /* swagger v3 */
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/",
            "/api/users/**",
//            "/api/admin/**",
//            "/api/first-categories/**",
            "/api/second-categories/**",
            "/api/items/**",
            "/api/carts/**",
            "/api/orders/**",
            "/error"
    };


    @PostConstruct
    public void init() {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String generate(MyTokenPayload payload) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .claim("id", payload.getUserId())
                .claim("username", payload.getUsername())
                .claim("roles", payload.getRoles())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(secretKey)
                .compact();
    }

    public MyTokenPayload verify(String token) throws BadCredentialsException {
        try {
            Claims payload = Jwts.parserBuilder()
                    .setSigningKey(secret.getBytes(StandardCharsets.UTF_8))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();


            Long id = payload.get("id", Long.class);
            String username = payload.get("username", String.class);
            List<String> roles = (List<String>) payload.get("roles", List.class);

            MyTokenPayload myTokenPayload = new MyTokenPayload(id, username, roles);
            return myTokenPayload;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadCredentialsException("올바르지 않은 토큰입니다.");
        }
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            throw e;
        } catch (Exception e) {
            return false;
        }
    }

    public String extractJwtFromRequest(HttpServletRequest request) {
        // Extract JWT from the Authorization header
        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }

        return null;
    }
}