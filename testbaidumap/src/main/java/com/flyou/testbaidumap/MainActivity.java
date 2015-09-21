package com.flyou.testbaidumap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;

public class MainActivity extends AppCompatActivity {
    private boolean isFirstLoc = true;
    private BaiduMap map;
    private MapView mMapView;
    public double Longitude;
    public double Latitude;
    private LocationClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mMapView = (MapView) findViewById(R.id.bmapView);
        BaiduMap mBaiduMap = mMapView.getMap();
// 获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);



        //定义Maker坐标点
//    河南省郑州市航天商务大厦 113.670358,34.817174
        LatLng point = new LatLng(34.817174, 113.670358);
//构建Marker图标
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.mipmap.icon);
//构建MarkerOption，用于在地图上添加Marker
        OverlayOptions option = new MarkerOptions()
                .position(point)
                .title("航天商务大厦")

                .icon(bitmap);
//在地图上添加Marker，并显示
        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {


                switch (marker.getTitle()){
                    case "航天商务大厦":
                        Toast.makeText(MainActivity.this, "点击", Toast.LENGTH_SHORT).show();
                    break;

                    default:

                        break;

                }
                return false;
            }
        });
        mBaiduMap.addOverlay(option);







        map = mMapView.getMap();
        // 设置开启定位自己的位置
        map.setMyLocationEnabled(true);

        // 如果使用系统的让mCurrentMarker为空即可
        map.setMyLocationConfigeration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
        location();


    }

    private void showInMap() {
        //定义Maker坐标点
        LatLng point = new LatLng(Latitude, Longitude);

    }

    private void location() {
        client = new LocationClient(getApplicationContext()); // 声明LocationClient类

        // 注册监听
        client.registerLocationListener(Mylisetener);

        LocationClientOption option = new LocationClientOption();
        option.setCoorType("bd09ll");// 返回的定位结果是百度经纬度,默认值gcj02
        option.setScanSpan(5000);// 设置发起定位请求的间隔时间为5000ms
        option.setOpenGps(true);// 打开gps
        option.setIsNeedAddress(true);// 返回的定位结果包含地址信息
        option.setNeedDeviceDirect(true);// 返回的定位结果包含手机机头的方向
        client.setLocOption(option);
    }


    BDLocationListener Mylisetener = new BDLocationListener() {


        @Override
        public void onReceiveLocation(BDLocation location) {
            // map view 销毁后不在处理新接收的位置
            if (location == null || mMapView == null)
                return;
            MyLocationData locData = new MyLocationData.Builder().accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(100).latitude(location.getLatitude()).longitude(location.getLongitude()).build();
            //这只中心点坐标
            map.setMyLocationData(locData);
            Log.d("MainActivity", "location.getLatitude():" + location.getLatitude() + ",location.getLongitude():" + location.getLongitude());
            if (isFirstLoc) {
                isFirstLoc = false;
                LatLng ll = new LatLng(location.getLatitude(), location.getLongitude());

                // 缩放的范围是3-20
                MapStatusUpdate u = MapStatusUpdateFactory.newLatLngZoom(ll, 17f);

                map.animateMapStatus(u);

            }


        }

    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
        client.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
        client.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
}
