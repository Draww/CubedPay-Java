package co.melondev.cubedpay.data;

import com.google.common.base.Joiner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Arrays;

public class UploadedImage {

    private String id = "";
    private String url = "";

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void download(File file) throws IOException {
        ReadableByteChannel rbc = Channels.newChannel(new URL(url).openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
    }

    public File downloadToTempFile() throws IOException {
        String[] nameSplit = url.substring(url.lastIndexOf("/")).split("\\.");
        File file = File.createTempFile(
                "cubedpay-" + Joiner.on(".").join(Arrays.copyOfRange(nameSplit, 0, nameSplit.length - 2)),
                nameSplit[nameSplit.length - 1]);
        download(file);
        return file;
    }

    @Override
    public String toString() {
        return "UploadedImage{" +
                "url='" + url + '\'' +
                '}';
    }
}
