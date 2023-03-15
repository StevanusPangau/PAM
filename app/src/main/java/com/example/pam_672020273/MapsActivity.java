package com.example.pam_672020273;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.pam_672020273.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap peta;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        peta = googleMap;
        LatLng lokasi = new LatLng(-7.3186119, 110.4996112);
        peta.addMarker(new MarkerOptions().position(lokasi).title("tekape"));
        peta.addMarker(new MarkerOptions().position(new LatLng(-7.2967925,110.4921393)).title("tekape"));
        peta.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        peta.moveCamera(CameraUpdateFactory.newLatLng(lokasi));
        peta.getUiSettings().setCompassEnabled(true);
        peta.getUiSettings().setZoomGesturesEnabled(true);
        peta.getUiSettings().setZoomControlsEnabled(true);
        peta.getUiSettings().setRotateGesturesEnabled(true);
        peta.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi,8.0f));
        peta.animateCamera(CameraUpdateFactory.zoomTo(15f));
    }
}