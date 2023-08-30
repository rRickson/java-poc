package com.rRickson;

import com.rRickson.kinesis.Connection;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.kinesis.KinesisClient;
import software.amazon.awssdk.services.kinesis.model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static String streamName = "kinesis-poc";

    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            Connection kinesisClient = new Connection();
            populateStream(kinesisClient.connect());
            printStream(kinesisClient.connect());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void populateStream(KinesisClient kinesisClient) {
        SdkBytes data = SdkBytes.fromUtf8String("event_1");
        List<PutRecordsRequestEntry> putRecordsRequestEntryList
                = new ArrayList<>();
        PutRecordsRequestEntry putRecordsRequestEntry =
                PutRecordsRequestEntry.builder()
                        .data(data)
                        .partitionKey("event1")
                        .build();
        putRecordsRequestEntryList.add(putRecordsRequestEntry);
        PutRecordsRequest putRecordsRequest
                = PutRecordsRequest
                .builder()
                .streamName(streamName)
                .records(putRecordsRequestEntry)
                .build();

        PutRecordsResponse putRecordsResult = kinesisClient
                .putRecords(putRecordsRequest);
        System.out.println("Put records Result" + putRecordsResult);
    }

    private static void printStream(KinesisClient kinesisClient) {
        String shardIterator;
        String lastShardId = null;

        DescribeStreamRequest describeStreamRequest = DescribeStreamRequest.builder()
                .streamName(streamName)
                .build();

        List<Shard> shards = new ArrayList<>();
        DescribeStreamResponse streamRes;
        do {
            streamRes = kinesisClient.describeStream(describeStreamRequest);
            shards.addAll(streamRes.streamDescription().shards());

            if (shards.size() > 0) {
                lastShardId = shards.get(shards.size() - 1).shardId();
            }
        } while (streamRes.streamDescription().hasMoreShards());

        GetShardIteratorRequest itReq = GetShardIteratorRequest.builder()
                .streamName(streamName)
                .shardIteratorType("TRIM_HORIZON")
                .shardId(lastShardId)
                .build();

        GetShardIteratorResponse shardIteratorResult = kinesisClient.getShardIterator(itReq);
        shardIterator = shardIteratorResult.shardIterator();

        List<Record> records;
        while (true) {

            // Create a new getRecordsRequest with an existing shardIterator
            // Set the maximum records to return to 25

            GetRecordsRequest recordsRequest = GetRecordsRequest.builder()
                    .shardIterator(shardIterator)
                    .limit(1000)
                    .build();

            GetRecordsResponse result = kinesisClient.getRecords(recordsRequest);

            // Put the result into record list. The result can be empty.
            records = result.records();

            for (Record record : records) {
                SdkBytes byteBuffer = record.data();
                System.out.printf("Seq No: %s - %s%n", record.sequenceNumber(), new String(byteBuffer.asByteArray()));
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
                throw new RuntimeException(exception);
            }
        }
    }
}