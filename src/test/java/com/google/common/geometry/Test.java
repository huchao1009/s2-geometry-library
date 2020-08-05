package com.google.common.geometry;

public class Test {
    public static void main(String[] args) {
        //距离1355.8918013163575
        double lng = 114.191564;
        double lat = 22.304697;
        double radius = 1360;//半径
        double capHeight = (2 * S2.M_PI) * (radius / 40075017);
        S2LatLng s2LatLng = S2LatLng.fromDegrees(lat, lng);
        S2Cap cap = S2Cap.fromAxisHeight(s2LatLng.toPoint(), capHeight * capHeight / 2);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 60000; i++) {
            double lat2 = 22.296760;
            double lng2 = 114.181578;
            S2LatLng s2LatLng2 = S2LatLng.fromDegrees(lat2, lng2);
            double earthDistance = s2LatLng.getEarthDistance(s2LatLng2); //单位为m
//            System.out.println(earthDistance);
            boolean contains = cap.contains(s2LatLng2.toPoint());
//            System.out.println(contains);
        }
        System.out.println("time: " + (System.currentTimeMillis() - start));
    }
}
