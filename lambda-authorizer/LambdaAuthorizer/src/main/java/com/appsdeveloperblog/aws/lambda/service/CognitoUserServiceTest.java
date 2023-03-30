package com.appsdeveloperblog.aws.lambda.service;

import com.google.gson.JsonObject;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminGetUserRequest;

public class CognitoUserServiceTest {

    private final CognitoIdentityProviderClient cognitoIdentityProviderClient;

    public CognitoUserServiceTest(String region){
        this.cognitoIdentityProviderClient = CognitoIdentityProviderClient.builder().re;
    }

    public JsonObject getUserByUserName(String userName, String poolId){
        AdminGetUserRequest adminGetUserRequest = AdminGetUserRequest.builder().username(userName).userPoolId(poolId).build();

        return null;
    }
}
