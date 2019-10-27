package com.dome;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.time.LocalTime;
import java.util.ArrayList;


public class server {


    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(9000), 0);
        System.out.println("server started at " + "9000");
        HttpContext context = server.createContext("/");
        context.setHandler(com.dome.server::handleRequest);
        server.start();
    }


    public static ArrayList<Long> trial_division(long N){
        ArrayList<Long> F = new ArrayList<>();
        long two=2L;
        while(N%2L==0L){
            N = N/2L;
            F.add(two);
        }
        long d = 3L;
        while(d*d <= N){
            while(N%d == 0L){
                N = N/d;
                F.add (d);
            }
            d = d+2L;
        }
        if (N != 1L){
            F.add (N);
        }
        return F;
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        ArrayList<Long> test= trial_division(10922354402502342L);
        String response ="array with primes : ";
        for (Long s : test)
        {
            response += s + ",";
        }
        response= response.substring(0,response.length()-1);
        exchange.sendResponseHeaders(200,response.length());
        OutputStream os = exchange.getResponseBody();

        System.out.println("Request Started: " + (LocalTime.now()));


        System.out.println("Request End: " + (LocalTime.now()));

            System.out.println("response: " + response);
            os.write(response.getBytes());


        os.close();
    }
}
