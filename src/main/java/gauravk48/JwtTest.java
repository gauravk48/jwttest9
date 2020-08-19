package gauravk48;

import io.jsonwebtoken.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Date;

public class JwtTest {
    public static void main(String args[]) {
        System.out.println("Test jwt token, current time: " + new Date(System.currentTimeMillis()));
        if(args.length < 2) {
            System.err.println("Usage: gauravk48.JwtTest [-c <username> <secret>] [-v <username> <secret> <token> ] [-k <length>]");
            System.exit(1);
        }
        String option = args[0];
        if(option.equalsIgnoreCase("-c")) {
            String username = args[1];
            String secret = args[2];
            String accessToken = generateAccessToken(username, secret);
            System.out.println(accessToken);
        } else if (option.equalsIgnoreCase("-v")) {
            String username = args[1];
            String secret = args[2];
            String token = args[3];
            String usernameFromToken = validateTokenAndGetSubj(secret, token);
            if(usernameFromToken.equals(username)) {
                System.out.println("Success");
            } else {
                System.out.println("Failure");
            }
        } else if (option.equalsIgnoreCase("-k")) {
            String key = generateKey(args[1]);
            System.out.println(key);
        }
    }

    public static String generateAccessToken(String username, String secret) {
        String accessToken = Jwts.builder().setIssuer("gauravk48")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1500000))
                .setSubject(username)
                .claim("type", "access")
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
        return accessToken;
    }

    public static String validateTokenAndGetSubj(String secret, String jwt) throws ExpiredJwtException, UnsupportedJwtException,
            MalformedJwtException, SignatureException, IllegalArgumentException {
        Jws<Claims> claims = null;

            claims = Jwts.parser()
                    .requireIssuer("gauravk48")
                    .setSigningKey(secret)
                    .parseClaimsJws(jwt);

            return claims.getBody().getSubject();
    }

    public static String generateKey(String lengthS) {
        String result = "";
        int length = Integer.valueOf(lengthS);
        result = RandomStringUtils.randomAlphanumeric(340);
        return result;
    }
}
