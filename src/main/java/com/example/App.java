package com.example;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Hello world!
 *
 */

//public class App 
//{
//    public static void main( String[] args )
//    {
//        System.out.println( "Hello World!" );
//    }
//}

// From http://news.mynavi.jp/column/java/056/

public class App {
    public static void main(String[] argv) 
        throws Exception {
        URI uri = new URI("http://example.com");
        URLConnection connection = uri.toURL().openConnection();

        // ヘッダ情報を出力
        Map headers = connection.getHeaderFields();
        for (Object key : headers.keySet()) {
            System.out.println(key + ": " + headers.get(key));
        }

        // コンテンツを出力
        BufferedReader reader =
            new BufferedReader(new InputStreamReader
                (connection.getInputStream(), "JISAutoDetect"));
        String buffer = reader.readLine();
        System.out.println();
        while (null != buffer) {
            System.out.println(buffer);
            buffer = reader.readLine();
        }
    }
}
