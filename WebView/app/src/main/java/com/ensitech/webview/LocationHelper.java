package com.ensitech.webview;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

public class LocationHelper {

    private Context context;
    private Location current;
    private LocationManager locationManager;
    private String provider = LocationManager.GPS_PROVIDER;

    public LocationHelper(Context context){
        this.context = context;
        this.locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if(context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || context.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationManager.requestLocationUpdates(provider, 0, 0, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                current = location;
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {}
            @Override
            public void onProviderEnabled(String s) {}
            @Override
            public void onProviderDisabled(String s) {}
        });
    }

    public Location getCurrentLocation() {
        if (current == null) {
            if (context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    || context.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                current = locationManager.getLastKnownLocation(provider);
            }
        }
        if (current == null){
            current = new Location(provider);
            current.setLatitude(0);
            current.setLongitude(0);
            current.setAltitude(0);
        }
        return current;

    }
}
