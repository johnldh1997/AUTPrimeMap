package com.example.autprimecampusmap;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener, GoogleMap.OnInfoWindowClickListener {
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE = 101;
    private GoogleMap mMap;

    //Create a marker in setted location with latitude and longitude
    private static final LatLng AUTSouthCampus = new LatLng(-36.984360, 174.879210);
    private Marker SouthCampus;

    private static final LatLng AUTSouthMA = new LatLng(-36.98496453, 174.88153517);
    private Marker MA;

    private static final LatLng AUTSouthMB = new LatLng(-36.98529876, 174.88189459);
    private Marker MB;

    private static final LatLng AUTSouthMC = new LatLng(-36.98573583, 174.88201797);
    private Marker MC;

    private static final LatLng AUTSouthMD = new LatLng(-36.98509308, 174.88268852);
    private Marker MD;

    private static final LatLng AUTSouthME = new LatLng(-36.98456173, 174.88236666);
    private Marker ME;

    private static final LatLng AUTSouthMF = new LatLng(-36.98624575, 174.88207698);
    private Marker MF;

    private static final LatLng AUTSouthMG = new LatLng(-36.98475884, 174.88288701);
    private Marker MG;

    private static final LatLng AUTSouthMH = new LatLng(-36.98549159, 174.88296747);
    private Marker MH;

    private static final LatLng AUTCityCampus = new LatLng(-36.852631, 174.766785);
    private Marker CityCampus;

    private static final LatLng AUTCityWA = new LatLng(-36.85317925, 174.76642817);
    private Marker WA;

    private static final LatLng AUTCityWB = new LatLng(-36.85339387, 174.76740181);
    private Marker WB;

    private static final LatLng AUTCityWC = new LatLng(-36.85362567, 174.7671919);
    private Marker WC;

    private static final LatLng AUTCityWD = new LatLng(-36.853836, 174.76706922);
    private Marker WD;

    private static final LatLng AUTCityWE = new LatLng(-36.8537201, 174.76632893);
    private Marker WE;

    private static final LatLng AUTCityWF = new LatLng(-36.85353553, 174.76523995);
    private Marker WF;

    private static final LatLng AUTCityWG = new LatLng(-36.85322647, 174.7658515);
    private Marker WG;

    private static final LatLng AUTCityWH = new LatLng(-36.85253967, 174.76605535);
    private Marker WH;

    private static final LatLng AUTCityWM = new LatLng(-36.854115, 174.76612777);
    private Marker WM;

    private static final LatLng AUTCityWN = new LatLng(-36.85446269, 174.7661975);
    private Marker WN;

    private static final LatLng AUTCityWO = new LatLng(-36.85418798, 174.76562887);
    private Marker WO;

    private static final LatLng AUTCityWP = new LatLng(-36.85374586, 174.76772904);
    private Marker WP;

    private static final LatLng AUTCityWR = new LatLng(-36.85499065, 174.76684123);
    private Marker WR;

    private static final LatLng AUTCityWS = new LatLng(-36.85409354, 174.76673931);
    private Marker WS;

    private static final LatLng AUTCityWT = new LatLng(-36.85245382, 174.76460963);
    private Marker WT;

    private static final LatLng AUTCityWU = new LatLng(-36.85381883, 174.76530969);
    private Marker WU;

    private static final LatLng AUTCityWW = new LatLng(-36.85465156, 174.76702362);
    private Marker WW;

    private static final LatLng AUTCityWY = new LatLng(-36.85348831, 174.76431459);
    private Marker WY;

    private static final LatLng AUTCityWZ = new LatLng(-36.85425236, 174.76732939);
    private Marker WZ;

    private static final LatLng AUTNorthCampus = new LatLng(-36.792930, 174.747960);
    private Marker NorthCampus;

    private static final LatLng AUTNorthAA = new LatLng(-36.79824162, 174.75727916);
    private Marker AA;

    private static final LatLng AUTNorthAB = new LatLng(-36.79797959, 174.75687683);
    private Marker AB;

    private static final LatLng AUTNorthAC = new LatLng(-36.79752856, 174.75659251);
    private Marker AC;

    private static final LatLng AUTNorthAE = new LatLng(-36.79868836, 174.7583735);
    private Marker AE;

    private static final LatLng AUTNorthAF = new LatLng(-36.79706034, 174.75747764);
    private Marker AF;

    private static final LatLng AUTNorthAG = new LatLng(-36.79721927, 174.756217);
    private Marker AG;

    private static final LatLng AUTNorthAH = new LatLng(-36.7964074, 174.75688487);
    private Marker AH;

    private static final LatLng AUTNorthAJ = new LatLng(-36.79792375, 174.75807309);
    private Marker AJ;

    private static final LatLng AUTNorthAK = new LatLng(-36.79937564, 174.75890994);
    private Marker AK;

    private static final LatLng AUTNorthAL = new LatLng(-36.7976832, 174.75726306);
    private Marker AL;

    private static final LatLng AUTNorthAM = new LatLng(-36.79849936, 174.75733817);
    private Marker AM;

    private static final LatLng AUTNorthAN = new LatLng(-36.79915657, 174.7580913);
    private Marker AN;

    private static final LatLng AUTNorthAO = new LatLng(-36.79909643, 174.75871682);
    private Marker AO;

    private static final LatLng AUTNorthAP = new LatLng(-36.79880434, 174.75907624);
    private Marker AP;

    private static final LatLng AUTNorthAR = new LatLng(-36.79926825, 174.75777805);
    private Marker AR;

    private static final LatLng AUTNorthAS = new LatLng(-36.79795812, 174.75654423);
    private Marker AS;

    private static final LatLng AUTNorthAT = new LatLng(-36.79768749, 174.7560668);
    private Marker AT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchLastLocation();

    }

    private void fetchLastLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }

        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    currentLocation = location;
                    Toast.makeText(getApplicationContext(), currentLocation.getLatitude() + "" + currentLocation.getLongitude(), Toast.LENGTH_SHORT).show();
                    SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map);
                    supportMapFragment.getMapAsync(MainActivity.this);
                }
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Adds campus markers to map
        addMarkersToMap();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        mMap.setMyLocationEnabled(true);

        //Setting listeners for events
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);
        mMap.setOnInfoWindowClickListener(this);

        //Adding a marker on current location and camera zooms in for current location
        LatLng latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("My current location");
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 5));
        googleMap.addMarker(markerOptions);
    }

    private void addMarkersToMap() {
        // Add markers to AUT campus locations
        SouthCampus = mMap.addMarker(new MarkerOptions()
                .position(AUTSouthCampus)
                .title("AUT south campus"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTSouthCampus));

        MA = mMap.addMarker(new MarkerOptions()
                .position(AUTSouthMA)
                .title("MA Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTSouthMA));

        MB = mMap.addMarker(new MarkerOptions()
                .position(AUTSouthMB)
                .title("MB Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTSouthMB));

        MC = mMap.addMarker(new MarkerOptions()
                .position(AUTSouthMC)
                .title("MC Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTSouthMC));

        MD = mMap.addMarker(new MarkerOptions()
                .position(AUTSouthMD)
                .title("MD Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTSouthMD));

        ME = mMap.addMarker(new MarkerOptions()
                .position(AUTSouthME)
                .title("ME Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTSouthME));

        MF = mMap.addMarker(new MarkerOptions()
                .position(AUTSouthMF)
                .title("MF Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTSouthMF));

        MG = mMap.addMarker(new MarkerOptions()
                .position(AUTSouthMG)
                .title("MG Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTSouthMG));

        MH = mMap.addMarker(new MarkerOptions()
                .position(AUTSouthMH)
                .title("MH Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTSouthMH));

        CityCampus = mMap.addMarker(new MarkerOptions()
                .position(AUTCityCampus)
                .title("AUT city campus"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTCityCampus));

        WA = mMap.addMarker(new MarkerOptions()
                .position(AUTCityWA)
                .title("WA Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTCityWA));

        WB = mMap.addMarker(new MarkerOptions()
                .position(AUTCityWB)
                .title("WB Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTCityWB));

        WC = mMap.addMarker(new MarkerOptions()
                .position(AUTCityWC)
                .title("WC Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTCityWC));

        WD = mMap.addMarker(new MarkerOptions()
                .position(AUTCityWD)
                .title("WD Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTCityWD));

        WE = mMap.addMarker(new MarkerOptions()
                .position(AUTCityWE)
                .title("WE Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTCityWE));

        WF = mMap.addMarker(new MarkerOptions()
                .position(AUTCityWF)
                .title("WF Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTCityWF));

        WG = mMap.addMarker(new MarkerOptions()
                .position(AUTCityWG)
                .title("WG Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTCityWG));

        WH = mMap.addMarker(new MarkerOptions()
                .position(AUTCityWH)
                .title("WH Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTCityWH));

        WM = mMap.addMarker(new MarkerOptions()
                .position(AUTCityWM)
                .title("WM Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTCityWM));

        WN = mMap.addMarker(new MarkerOptions()
                .position(AUTCityWN)
                .title("WN Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTCityWN));

        WO = mMap.addMarker(new MarkerOptions()
                .position(AUTCityWO)
                .title("WO Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTCityWO));

        WP = mMap.addMarker(new MarkerOptions()
                .position(AUTCityWP)
                .title("WP Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTCityWP));

        WR = mMap.addMarker(new MarkerOptions()
                .position(AUTCityWR)
                .title("WR Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTCityWR));

        WS = mMap.addMarker(new MarkerOptions()
                .position(AUTCityWS)
                .title("WS Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTCityWS));

        WT = mMap.addMarker(new MarkerOptions()
                .position(AUTCityWT)
                .title("WT Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTCityWT));

        WU = mMap.addMarker(new MarkerOptions()
                .position(AUTCityWU)
                .title("WU Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTCityWU));

        WW = mMap.addMarker(new MarkerOptions()
                .position(AUTCityWW)
                .title("WW Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTCityWW));

        WY = mMap.addMarker(new MarkerOptions()
                .position(AUTCityWY)
                .title("WY Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTCityWY));

        WZ = mMap.addMarker(new MarkerOptions()
                .position(AUTCityWZ)
                .title("WZ Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTCityWZ));

        NorthCampus = mMap.addMarker(new MarkerOptions()
                .position(AUTNorthCampus)
                .title("AUT north campus"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTNorthCampus));

        AA = mMap.addMarker(new MarkerOptions()
                .position(AUTNorthAA)
                .title("AA Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTNorthAA));

        AB = mMap.addMarker(new MarkerOptions()
                .position(AUTNorthAB)
                .title("AB Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTNorthAB));

        AC = mMap.addMarker(new MarkerOptions()
                .position(AUTNorthAC)
                .title("AC Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTNorthAC));

        AE = mMap.addMarker(new MarkerOptions()
                .position(AUTNorthAE)
                .title("AE Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTNorthAE));

        AF = mMap.addMarker(new MarkerOptions()
                .position(AUTNorthAF)
                .title("AF Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTNorthAF));

        AG = mMap.addMarker(new MarkerOptions()
                .position(AUTNorthAG)
                .title("AG Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTNorthAG));

        AH = mMap.addMarker(new MarkerOptions()
                .position(AUTNorthAH)
                .title("AH Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTNorthAH));

        AJ = mMap.addMarker(new MarkerOptions()
                .position(AUTNorthAJ)
                .title("AJ Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTNorthAJ));

        AK = mMap.addMarker(new MarkerOptions()
                .position(AUTNorthAK)
                .title("AK Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTNorthAK));

        AL = mMap.addMarker(new MarkerOptions()
                .position(AUTNorthAL)
                .title("AL Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTNorthAL));

        AM = mMap.addMarker(new MarkerOptions()
                .position(AUTNorthAM)
                .title("AM Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTNorthAM));

        AN = mMap.addMarker(new MarkerOptions()
                .position(AUTNorthAN)
                .title("AN Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTNorthAN));

        AO = mMap.addMarker(new MarkerOptions()
                .position(AUTNorthAO)
                .title("AO Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTNorthAO));

        AP = mMap.addMarker(new MarkerOptions()
                .position(AUTNorthAP)
                .title("AP Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTNorthAP));

        AR = mMap.addMarker(new MarkerOptions()
                .position(AUTNorthAR)
                .title("AR Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTNorthAR));

        AS = mMap.addMarker(new MarkerOptions()
                .position(AUTNorthAS)
                .title("AS Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTNorthAS));

        AT = mMap.addMarker(new MarkerOptions()
                .position(AUTNorthAT)
                .title("AT Building"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AUTNorthAT));

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fetchLastLocation();
                }
                break;
        }
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "Current location button clicked", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInfoWindowClick(Marker marker) {

        Toast.makeText(this, "Info window clicked", Toast.LENGTH_SHORT).show();

    }
}
