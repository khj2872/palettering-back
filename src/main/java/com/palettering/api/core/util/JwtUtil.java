package com.palettering.api.core.util;

import com.palettering.api.palettering.user.user.domain.User;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    private static Long tokenExpiresInMillis;
    private static String jwtSecretKey = "145ADG39GGETT";

    @Value("${jwt.secretKey}")
    public void setJwtSecretKey(String value) {
        this.jwtSecretKey = value;
    }

    @Value("${token.expires.in.millis}")
    public void setTokenExpiresInMillis(Long value) {
        this.tokenExpiresInMillis = value;
    }

    public static String createToken(User user) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Date expireTime = new Date();
        Long nowTime = expireTime.getTime();

        System.out.println("expireTime ::: " + expireTime);
        //expireTime.setTime(expireTime.getTime() + tokenExpiresInMillis);
        //Long timeTime = expireTime.getTime();
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(jwtSecretKey);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        Map<String, Object> headerMap = new HashMap<>();

        headerMap.put("typ","JWT");
        headerMap.put("alg","HS256");

        Map<String, Object> map= new HashMap<>();

        map.put("email_verified", true);
        map.put("email", user.getEmail());
        map.put("uid", user.getUid()); //UID 넣어도대나?
        map.put("name", user.getName());
          map.put("iat", nowTime);
        //map.put("exp", expireTime.getTime());
        map.put("exp", expireTime);

        JwtBuilder builder = Jwts.builder().setHeader(headerMap)
                .setClaims(map)
                .setExpiration(expireTime)
                .signWith(signatureAlgorithm, signingKey);

        return builder.compact();
    }

}
