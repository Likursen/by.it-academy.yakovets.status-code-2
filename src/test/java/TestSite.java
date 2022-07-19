import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TestSite {
    String URL;
    HttpClient httpClient;
    HttpGet httpGet;
    HttpPost httpPost;
    HttpResponse httpResponse;

    @Before
    public void openConnection() {
        httpClient = HttpClients.createDefault();
    }

    @Test
    public void statusCode200Test() {
        URL = "https://yandex.by";
        httpGet = new HttpGet(URL);
        try {
            httpResponse = httpClient.execute(httpGet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int actualStatusCode = httpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(200, actualStatusCode);
    }

    @Test
    public void statusCode403Test() {
        URL = "https://team.andersenlab.com/";
        httpPost = new HttpPost(URL);
        httpPost.setHeader("qwe", "qwe");
        try {
            httpResponse = httpClient.execute(httpPost);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int actualStatusCode = httpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(403, actualStatusCode);
    }
}
