package com.appsdeveloperblog.aws.lambda.authorizer;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.RSAKeyProvider;

public class JwtUtils {
    public DecodedJWT validateJwtForUser(String jwt,
                                         String region,
                                         String userPoolId,
                                         String principalIId,
                                         String audience){

        RSAKeyProvider keyProvider = new AwsCognitoRSAKeyProvider(region, userPoolId);

        Algorithm algorithm = Algorithm.RSA256(keyProvider);
        JWTVerifier jwtVerifier = JWT.require(algorithm)
                .withSubject(principalIId)
                .withAudience(audience)
                .withIssuer("https://cognito-idp." + region + ".amazonaws.com/" + userPoolId)
                .withClaim("token_use", "id")
                .build();

        return jwtVerifier.verify(jwt);
    }
}
