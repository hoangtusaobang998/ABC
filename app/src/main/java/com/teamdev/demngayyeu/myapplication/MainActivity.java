package com.teamdev.demngayyeu.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.AspectRatio;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.TorchState;
import androidx.camera.core.impl.VideoCaptureConfig;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Handler;
import android.view.TextureView;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private ListenableFuture<ProcessCameraProvider> cameraProviderFuture;
    private Preview imagePreview;
    private ImageCapture imageCapture;
    private PreviewView previewView;
    private CameraControl cameraControl;
    private CameraInfo cameraInfo;
    private float linearZoom = 0f;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.previewView = findViewById(R.id.preview_view);
        this.cameraProviderFuture = ProcessCameraProvider.getInstance(this);
        this.previewView.post(this::startCamera);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                previewView.post(new Runnable() {
                    @Override
                    public void run() {
                        toggleTorch();
                    }
                });
            }
        }, 1000);
    }

    private void toggleTorch() {
        if (this.cameraInfo == null) {
            return;
        }
        if (this.cameraInfo.getTorchState() == null) {
            return;
        }
        if (this.cameraInfo.getTorchState().getValue() == null) {
            return;
        }

        if (this.cameraInfo.getTorchState().getValue() == TorchState.ON) {
            this.cameraControl.enableTorch(false);
        } else {
            this.cameraControl.enableTorch(true);
        }
    }

    private void startCamera() {
        this.imagePreview = new Preview.Builder().setTargetAspectRatio(AspectRatio.RATIO_16_9).setTargetAspectRatio(this.previewView.getDisplay().getRotation()).build();
        this.imageCapture = new ImageCapture.Builder().
                setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY).
                setFlashMode(ImageCapture.FLASH_MODE_AUTO).build();


        final CameraSelector build = new CameraSelector.Builder().requireLensFacing(CameraSelector.LENS_FACING_BACK).build();


        this.cameraProviderFuture.addListener(() -> {
            try {
                ProcessCameraProvider processCameraProvider = cameraProviderFuture.get();
                processCameraProvider.unbindAll();
                Camera camera = processCameraProvider.bindToLifecycle(
                        MainActivity.this,
                        build,
                        imagePreview,
                        imageCapture);
                previewView.setPreferredImplementationMode(PreviewView.ImplementationMode.TEXTURE_VIEW);
                imagePreview.setSurfaceProvider(previewView.createSurfaceProvider(camera.getCameraInfo()));
                cameraControl = camera.getCameraControl();
                cameraInfo = camera.getCameraInfo();
                TextureView textureView=
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }

        }, ContextCompat.getMainExecutor(this));

    }

}
