package io.armory.plugin.example.spring;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.netflix.spinnaker.clouddriver.aws.security.AmazonClientProvider;
import com.netflix.spinnaker.clouddriver.aws.security.NetflixAmazonCredentials;
import com.netflix.spinnaker.clouddriver.aws.security.config.CredentialsConfig;
import com.netflix.spinnaker.clouddriver.aws.security.config.CredentialsLoader;

import java.util.List;

public class OverrideCredentialsLoader<T extends NetflixAmazonCredentials> extends CredentialsLoader<T> {

    public OverrideCredentialsLoader(
            AWSCredentialsProvider credentialsProvider,
            AmazonClientProvider amazonClientProvider) {
        super(credentialsProvider, amazonClientProvider, (Class<T>) NetflixAmazonCredentials.class);
    }

    public List<T> load(CredentialsConfig source) throws Throwable {
        source.setAccessKeyId("123");
        return super.load(source);
    }
}
