package com.rRickson.kinesis;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.kinesis.KinesisClient;

public class Connection {

    public static KinesisClient connect(){
        KinesisClient kinesisClient = KinesisClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build();
        return kinesisClient;
    }
    public static void disconect(KinesisClient kinesisClient){
        kinesisClient.close();
    }
}
