package nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by ning on 3/2/16.
 * FileChannelDemo && decode
 */
public class FileChannelDemo {
    public FileChannelDemo() {

    }

    public static void main(String args[]) {
        try {
            RandomAccessFile aFile = new RandomAccessFile("/home/ning/Desktop/test.txt", "rw");
            FileChannel inChannel = aFile.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(128);
            CharBuffer charbuf = CharBuffer.allocate(128);
            int bytesRead;

            bytesRead = inChannel.read(buf);
            Charset charset = Charset.forName("UTF-8");
            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead);
                buf.flip();
                System.out.println("**********");
                charbuf = charset.decode(buf);
                while (charbuf.hasRemaining()) {
                    System.out.print(charbuf.get());
                }
                buf.clear();
                charbuf.clear();
                bytesRead = inChannel.read(buf);
            }
            aFile.close();
        } catch (Exception e) {

        }
    }

}
